package dk.au.daimi.ascoveco.cpn.engine.daemon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import dk.au.daimi.ascoveco.cpn.engine.EnginePreferences;
import dk.au.daimi.ascoveco.cpn.engine.EvaluationException;
import dk.au.daimi.ascoveco.cpn.engine.Packet;
import dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation;

/**
 * @author mw
 */
public class DaemonSimulator implements SimulatorImplementation {
	DataInputStream dmoevalin, dmoin, cpnmldin;
	DataOutputStream dmoout, cpnmldout;
	Socket cpnmld, dmo, dmoeval;
	String banner;

	/**
	 * @throws IOException
	 *             if starting failed due to network error
	 * @throws EvaluationException
	 *             if starting failed due to an ML syntax error (should not happen)
	 */
	public DaemonSimulator() throws IOException, EvaluationException {
		final ScopedPreferenceStore standardPreferences = new ScopedPreferenceStore(new ConfigurationScope(),
		        dk.au.daimi.ascoveco.cpn.engine.Activator.PLUGIN_ID);
		final ScopedPreferenceStore preferences = new ScopedPreferenceStore(new ConfigurationScope(),
		        Activator.PLUGIN_ID);
		final InetAddress host = InetAddress.getByName(preferences.getString(DaemonEnginePreferences.HOST));
		final int port = preferences.getInt(DaemonEnginePreferences.PORT);
		final File image = new File(standardPreferences.getString(EnginePreferences.IMAGE));

		initialize(host, port, image);
	}

	/**
	 * @param host
	 *            host to connect to
	 * @param port
	 *            port to connect to
	 * @param image
	 *            image to use
	 * @throws IOException
	 *             if starting failed due to network error
	 * @throws EvaluationException
	 *             if starting failed due to ML evaluation error (happens if loading wrong image)
	 */
	public DaemonSimulator(final InetAddress host, final int port, final File image) throws IOException,
	        EvaluationException {
		initialize(host, port, image);
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation#destroy()
	 */
	public void destroy() {
		try {
			cpnmld.close();
		} catch (final IOException e) {
			// Ignore error
		}
		try {
			dmo.close();
		} catch (final IOException e) {
			// Ignore error
		}
		try {
			dmoeval.close();
		} catch (final IOException e) {
			// Ignore error
		}
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation#getBanner()
	 */
	public String getBanner() {
		return banner;
	}

	private String getBannerFromStream() throws IOException {
		byte[] data = new byte[10];
		int pos = 0;
		getEvalBytes(data, pos, 1);
		while (data[pos] != 1 && data[pos] != 2) {
			pos++;
			if (data.length <= pos) {
				final byte[] tmp = new byte[2 * data.length];
				for (int i = 0; i < pos; ++i) {
					tmp[i] = data[i];
				}
				data = tmp;
			}
			getEvalBytes(data, pos, 1);
		}
		if (data[pos] == 1) { return new String(data, 0, pos); }
		throw new IOException("Received an error for some reason; result = " + Arrays.toString(data));
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation#receive()
	 */
	public Packet receive() throws IOException {
		final Packet bis = new Packet();
		bis.receive(dmoin);
		return bis;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation#send(dk.au.daimi.ascoveco.cpn.engine.Packet)
	 */
	public void send(final Packet p) throws IOException {
		p.send(dmoout);
	}

	private Socket connectAndStartDaemon(final InetAddress host, final int port, final int retries) throws IOException {
		Socket cpnmldSocket = null;
		int retriesLeft = retries;
		while (retriesLeft > 0) {
			retriesLeft--;
			try {
				cpnmldSocket = new Socket(host, port);
				retriesLeft = 0;
			} catch (final IOException e) {
				if (retriesLeft == 0) {
					if (host.isLoopbackAddress()) {
						throw new IOException("Unable to start and connect to simulator");
					} else {
						throw e;
					}
				}
				if (host.isLoopbackAddress() || host.equals(InetAddress.getLocalHost())) {
					DaemonStarter.getInstance().startSimulatorDaemon(port);
				}
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e1) {
					// Ignore interrupt
				}
			}
		}
		return cpnmldSocket;
	}

	private void initialize(final InetAddress host, final int port, final File image) throws IOException,
	        SocketException {
		cpnmld = connectAndStartDaemon(host, port, 5);
		cpnmldout = new DataOutputStream(new BufferedOutputStream(cpnmld.getOutputStream()));
		cpnmldin = new DataInputStream(new BufferedInputStream(cpnmld.getInputStream()));
		new Packet().send(cpnmldout);
		new Packet().receive(cpnmldin);

		dmoeval = new Socket(host, port);
		dmoeval.setKeepAlive(true);
		final DataOutputStream dmoevalout = new DataOutputStream(new BufferedOutputStream(dmoeval.getOutputStream()));

		dmoevalin = new DataInputStream(new BufferedInputStream(dmoeval.getInputStream()));

		new Packet().send(dmoevalout);
		new Packet().receive(dmoevalin);

		dmo = new Socket(host, port);
		dmo.setKeepAlive(true);
		dmoout = new DataOutputStream(new BufferedOutputStream(dmo.getOutputStream()));
		dmoin = new DataInputStream(new BufferedInputStream(dmo.getInputStream()));
		new Packet().send(dmoout);
		new Packet().receive(dmoin);

		String parentDir = image.getParent();
		if (parentDir == null) {
			parentDir = ".";
		}
		new Packet("foo\0bar\0" + parentDir + "\0").send(cpnmldout);
		new Packet().receive(cpnmldin);
		new Packet(3, image.getName()).send(cpnmldout);
		new Packet().receive(cpnmldin);

		banner = getBannerFromStream();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.engine.SimulatorImplementation#getEvalBytes(byte[], int, int)
	 */
	public int getEvalBytes(final byte[] data, final int start, final int count) throws IOException {
		return dmoevalin.read(data, start, count);
	}

}

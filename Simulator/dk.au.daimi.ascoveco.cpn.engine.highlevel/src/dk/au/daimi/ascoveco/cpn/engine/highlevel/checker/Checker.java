package dk.au.daimi.ascoveco.cpn.engine.highlevel.checker;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import dk.au.daimi.ascoveco.cpn.engine.highlevel.Activator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.CheckerException;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.DeclarationCheckerException;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.HighLevelSimulator;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.LocalCheckFailed;
import dk.au.daimi.ascoveco.cpn.engine.highlevel.PageSorter;
import dk.au.daimi.ascoveco.cpn.model.FusionGroup;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.Transition;

/**
 * @author mw
 */
public class Checker {

	private final PetriNet petriNet;
	private final Random random = new Random();
	private final HighLevelSimulator s;
	private final File output;

	/**
	 * @param petriNet
	 *            net to check
	 * @param output
	 *            output directory; if null will be set to modelo directory
	 * @param highLevelSimulator
	 *            simulator to use for checking
	 */
	public Checker(final PetriNet petriNet, final File output, final HighLevelSimulator highLevelSimulator) {
		this.petriNet = petriNet;
		this.output = output;
		s = highLevelSimulator;
	}

	/**
	 * @param decl
	 *            declaration to check
	 * @throws DeclarationCheckerException
	 *             exception is invalid
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void checkDeclaration(final HLDeclaration decl) throws DeclarationCheckerException, IOException {
		s.checkDeclaration(decl);
	}

	/**
	 * @throws DeclarationCheckerException
	 *             one or more declarationa are invlaid
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void checkDeclarations() throws DeclarationCheckerException, IOException {
		for (final HLDeclaration decl : petriNet.declaration()) {
			checkDeclaration(decl);
		}
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 * @throws Exception
	 *             could not initialise simulator
	 */
	public void checkInitializing() throws IOException, Exception {
		// s.evaluate("val _ = CpnMLSys.GramError.debugState:= true;");
		s.initialize();
		s.evaluate("CPN\'Settings.use_manbind := true"); //$NON-NLS-1$

		s.initializeSyntaxCheck();
		s.setSimulationOptions(false, false, false, false, false, true, true, "", "", "", "", "", "");
		s.setInitializationSimulationOptions(true, true, random.nextInt() / 2);

		try {
			final Resource resource = petriNet.eResource();
			if (resource != null) {

				final IWorkspace workspace = ResourcesPlugin.getWorkspace();
				final URI uri = resource.getURI();
				final String modelName = uri.trimFileExtension().lastSegment();
				String modelDir = "";
				if (uri.isPlatformResource()) {
					modelDir = workspace.getRoot().findMember(uri.toPlatformString(true)).getLocation().toFile()
					        .getParentFile().getAbsolutePath();
				}
				String outputDir = "";
				if (output != null) {
					outputDir = output.getAbsolutePath();
				}

				s.setModelNameModelDirOutputDir(modelName, modelDir, outputDir);
			}
		} catch (final Exception e) {
			Activator.logger.log(Level.WARNING,
			        "Setting of model directory and/or output directory failed.  This is usually not severe.", e);
		}

	}

	/**
	 * @param page
	 *            page to check
	 * @param prime
	 *            whether the page is prime
	 * @throws IOException
	 *             if an IO error occurred
	 * @throws CheckerException
	 *             if the page is inavlid
	 */
	public void checkPage(final Page page, final boolean prime) throws IOException, CheckerException {
		s.checkPage(page, prime);
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 * @throws CheckerException
	 *             if one or more pages are invalid
	 */
	public void checkPages() throws IOException, CheckerException {
		final PageSorter ps = new PageSorter(petriNet.getPage());
		for (final Page page : ps) {
			checkPage(page, ps.isPrime(page));
		}
	}

	/**
	 * @param id
	 *            id of fusion group
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForFusionGroup(final String id) throws IOException {
		s.generateInstanceForFusionGroup(id);
	}

	/**
	 * @param id
	 *            id of place
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForPlace(final String id) throws IOException {
		s.generateInstanceForPlace(id);
	}

	/**
	 * @param id
	 *            id of transition
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstanceForTransition(final String id) throws IOException {
		s.generateInstanceForTransition(id);
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void generateInstances() throws IOException {
		for (final FusionGroup fusionGroup : petriNet.getFusionGroups()) {
			generateInstanceForFusionGroup(fusionGroup.getId());
		}

		for (final Page page : petriNet.getPage()) {
			for (final RefPlace refPlace : page.readyFusionGroups()) {
				generateInstanceForPlace(refPlace.getId());
			}

			for (final RefPlace refPlace : page.readyPortPlaces()) {
				generateInstanceForPlace(refPlace.getId());
			}

			for (final Place place : page.readyPlaces()) {
				generateInstanceForPlace(place.getId());
			}

			for (final Transition transition : page.readyTransitions()) {
				generateInstanceForTransition(transition.getId());
			}
		}

		initialiseSimulationScheduler();
	}

	/**
	 * @throws IOException
	 *             if an IO error occurred
	 */
	public void initialiseSimulationScheduler() throws IOException {
		s.initialiseSimulationScheduler();
	}

	/**
	 * @throws ErrorInitializingSMLInterface
	 *             if the SML interface could not be initialized
	 */
	public void instantiateSMLInterface() throws ErrorInitializingSMLInterface {
		try {
			s.lock();
			s.evaluate("structure CPN'NetCapture = CPN'NetCapture(structure CPN'InstTable = CPN'InstTable)");
			s.evaluate("CPN'NetCapture.initNet ()");
			s.evaluate("CPN'NetCapture.checkNames()");
			s.evaluate("structure CPN'State = CPN'State(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'State.genMark(CPN'NetCapture.getNet()))");
			s.evaluate("CPN'Env.use_string(CPN'State.genState(CPN'NetCapture.getNet()))");
			s.evaluate("structure CPN'Event = CPN'Event(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'Event.genBind(CPN'NetCapture.getNet()))");
			s.evaluate("CPN'Env.use_string(CPN'Event.genEvent(CPN'NetCapture.getNet()))");
			s.evaluate("structure CPNToolsModel = CPNToolsModel(structure CPNToolsState = CPNToolsState structure CPNToolsEvent = CPNToolsEvent)");
			s.evaluate("structure CPN'HashFunction = CPN'HashFunction(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'HashFunction.genHashFunction(CPN'NetCapture.getNet()))");
			s.evaluate("structure CPN'Serializer = CPN'Serializer(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'Serializer.genSerializer(CPN'NetCapture.getNet()))");
			s.evaluate("structure CPN'Order = CPN'Order(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'Order.genStateOrder(CPN'NetCapture.getNet()))");
			s.evaluate("structure CPN'PackCommon = CPN'PackCommon(structure JavaExecute = JavaExecute)");
			s.evaluate("structure CPN'PackFunction = CPN'PackFunction(structure CPN'NetCapture = CPN'NetCapture)");
			s.evaluate("CPN'Env.use_string(CPN'PackFunction.genPackerFunction(CPN'NetCapture.getNet()))");
		} catch (final Exception e) {
			throw new ErrorInitializingSMLInterface(e);
		} finally {
			s.release();
		}
	}

	/**
	 * @throws LocalCheckFailed
	 */
	public void localCheck() throws LocalCheckFailed {
		LocalChecker.getInstance().check(petriNet);
	}

}

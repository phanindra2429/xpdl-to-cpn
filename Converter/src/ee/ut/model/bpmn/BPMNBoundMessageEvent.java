package ee.ut.model.bpmn;

import ee.ut.converter.BProcess;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.SimDataParser;

public class BPMNBoundMessageEvent extends BPMNElement {

	private String outputPlaceId;
	private int percentage; // how frequently this event will happen
	private String taskId;
	private String inputPlaceId;
	private String delayArcId;

	public BPMNBoundMessageEvent(BProcess pr, Parser p, Object o) {
		super(p, pr);

		elementId = parser.getElementParser().getId(o);
		elementName = parser.getElementParser().getName(o);

		inputPlaceId = process.getCpnet().addPlace(elementName + "IN").getId();

		outputPlaceId = process.getCpnet().addPlace(elementName + "OUT")
				.getId();

		String t = process.getCpnet().addTrans().getId();

		process.getCpnet().addArc(inputPlaceId, t);
		delayArcId = process.getCpnet().addArc(t, outputPlaceId).getId();

		taskId = parser.getElementParser().getBoundaryEventTaskId(o);
		BPMNTask task = (BPMNTask) process.getElement(taskId);
		task.addBounMessageEvent(this);
	}

	@Override
	public void addSimulationData(SimDataParser simDataParser) {
		String probability = simDataParser
				.getBoundMessageEventProbability(elementId);
		BPMNTask task = (BPMNTask) process.getElement(taskId);
		task.setBoundMessageEventProbability(elementId, probability);

		// TODO: This is currently depending on the order of elements!
		// If message event is before timer, then no delay is specified!
		int i = task.getBoundTimer();
		if (i > 0) {
			process.getCpnet().setArcAnnot(delayArcId,
					"@+round(uniform(0.0," + i + ".0))");
		}
	}

	public int getPercentage() {
		return percentage;
	}

	@Override
	public String getInputPID() {
		return inputPlaceId;
	}

	@Override
	public String getOutputPID(String ref) {
		return outputPlaceId;
	}

	@Override
	public String getOutputPID() {
		return outputPlaceId;
	}
}

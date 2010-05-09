package ee.ut.converter.factory;

import ee.ut.converter.CPNProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.ElementParser;
import ee.ut.model.bpmn.BPMNIntermediateTimerEvent;

public class BPMNIntermediateTimerEventFactory extends AbstractElementFactory {

	public BPMNIntermediateTimerEventFactory(CPNProcess cPNProcess,
			ElementParser elementParser) {
		super(cPNProcess, elementParser);
	}

	@Override
	public Element create(Object obj) throws Exception {
		return new BPMNIntermediateTimerEvent(cPNProcess, obj, elementParser);
	}

}
package ee.ut.converter.factory;

import ee.ut.converter.BProcess;
import ee.ut.converter.Element;
import ee.ut.converter.parser.Parser;

public abstract class AbstractElementFactory {

	protected Parser parser;

	public AbstractElementFactory(Parser p) {
		parser = p;
	}

	public abstract Element create(BProcess pr, Object obj);

}

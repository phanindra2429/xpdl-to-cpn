package dk.au.daimi.ascoveco.cpn.model.importer;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesFactory;
import dk.au.daimi.ascoveco.util.ParserUtil;

/**
 * @author mw
 */
public class CPNTypeParser {

	/**
	 * 
	 */
	public static final String andNode = "and";

	/**
	 * 
	 */
	public static final String byNode = "by";
	/**
	 * 
	 */
	public static final String idNode = "id";

	/**
	 * 
	 */
	public static final String mlNode = "ml";
	/**
	 * 
	 */
	public static final String recordfieldNode = "recordfield";
	private static final CpntypesFactory typeFactory = CpntypesFactory.eINSTANCE;
	/**
	 * 
	 */
	public static final String typeNode = "type";
	/**
	 * 
	 */
	public static final String unionfieldNode = "unionfield";
	/**
	 * 
	 */
	public static final String withNode = "with";

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processAlias(final Node n) {
		final CPNAlias aliasType = CPNTypeParser.typeFactory.createCPNAlias();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				aliasType.setType(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return aliasType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processBool(final Node n) {
		final CPNBool bool = CPNTypeParser.typeFactory.createCPNBool();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				boolean firstId = true;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.idNode)) {
						if (firstId) {
							bool.setFalseValue(ParserUtil.getTextFromElement(withCurrentNode));
							firstId = false;
						} else {
							bool.setTrueValue(ParserUtil.getTextFromElement(withCurrentNode));
						}
					}
				}
			}
		}

		return bool;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processEnum(final Node n) {
		final CPNEnum enumType = CPNTypeParser.typeFactory.createCPNEnum();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				enumType.addValue(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return enumType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processIndex(final Node n) {
		final CPNIndex indexType = CPNTypeParser.typeFactory.createCPNIndex();

		final NodeList nl = n.getChildNodes();
		boolean firstValue = true;
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.mlNode)) {
				if (firstValue) {
					indexType.setLow(ParserUtil.getTextFromElement(currentNode));
					firstValue = false;
				} else {
					indexType.setHigh(ParserUtil.getTextFromElement(currentNode));
				}
			} else if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				indexType.setName(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return indexType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processInt(final Node n) {
		final CPNInt intType = CPNTypeParser.typeFactory.createCPNInt();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				boolean firstValue = true;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.mlNode)) {
						if (firstValue) {
							intType.setLow(ParserUtil.getTextFromElement(withCurrentNode));
							firstValue = false;
						} else {
							intType.setHigh(ParserUtil.getTextFromElement(withCurrentNode));
						}
					}
				}
			}
		}

		return intType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processList(final Node n) {
		final CPNList listType = CPNTypeParser.typeFactory.createCPNList();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				boolean firstValue = true;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.mlNode)) {
						if (firstValue) {
							listType.setLow(ParserUtil.getTextFromElement(withCurrentNode));
							firstValue = false;
						} else {
							listType.setHigh(ParserUtil.getTextFromElement(withCurrentNode));
						}
					}
				}
			} else if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				listType.setType(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return listType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processProduct(final Node n) {
		final CPNProduct productType = CPNTypeParser.typeFactory.createCPNProduct();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				productType.addType(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return productType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processRecord(final Node n) {
		final CPNRecord recordType = CPNTypeParser.typeFactory.createCPNRecord();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.recordfieldNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				boolean firstValue = true;
				String id = null;
				String name = null;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.idNode)) {
						if (firstValue) {
							id = ParserUtil.getTextFromElement(withCurrentNode);
							firstValue = false;
						} else {
							name = ParserUtil.getTextFromElement(withCurrentNode);
						}
					}
				}

				recordType.addValue(id, name);
			}
		}

		return recordType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processString(final Node n) {
		final CPNString stringType = CPNTypeParser.typeFactory.createCPNString();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				boolean firstValue = true;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.mlNode)) {
						if (firstValue) {
							stringType.setRangeLow(ParserUtil.getTextFromElement(withCurrentNode));
							firstValue = false;
						} else {
							stringType.setRangeHigh(ParserUtil.getTextFromElement(withCurrentNode));
						}
					} else if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.andNode)) {
						final NodeList andNl = withCurrentNode.getChildNodes();
						boolean andFirstValue = true;
						for (int k = 0, andCnt = andNl.getLength(); k < andCnt; k++) {
							final Node andCurrentNode = andNl.item(k);
							if (ParserUtil.isElementNodeOfType(andCurrentNode, CPNTypeParser.mlNode)) {
								if (andFirstValue) {
									stringType.setLengthLow(ParserUtil.getTextFromElement(andCurrentNode));
									andFirstValue = false;
								} else {
									stringType.setLengthHigh(ParserUtil.getTextFromElement(andCurrentNode));
								}
							}
						}
					}
				}
			}
		}

		return stringType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processSubset(final Node n) {
		final CPNSubset subsetType = CPNTypeParser.typeFactory.createCPNSubset();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				subsetType.setWith(ParserUtil.getTextFromChild(currentNode, CPNTypeParser.mlNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.byNode)) {
				subsetType.setBy(ParserUtil.getTextFromChild(currentNode, CPNTypeParser.mlNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.idNode)) {
				subsetType.setType(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return subsetType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processUnion(final Node n) {
		final CPNUnion unionType = CPNTypeParser.typeFactory.createCPNUnion();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.unionfieldNode)) {
				final NodeList withNl = currentNode.getChildNodes();
				String id = null;
				String name = null;
				for (int j = 0, withCnt = withNl.getLength(); j < withCnt; j++) {
					final Node withCurrentNode = withNl.item(j);
					if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.idNode)) {
						id = ParserUtil.getTextFromElement(withCurrentNode);
					} else if (ParserUtil.isElementNodeOfType(withCurrentNode, CPNTypeParser.typeNode)) {
						name = ParserUtil.getTextFromChild(withCurrentNode, CPNTypeParser.idNode);
					}
				}

				unionType.addValue(id, name);
			}
		}

		return unionType;
	}

	/**
	 * @param n node
	 * @return type
	 */
	public static CPNType processUnit(final Node n) {
		final CPNUnit unit = CPNTypeParser.typeFactory.createCPNUnit();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, CPNTypeParser.withNode)) {
				unit.setId(ParserUtil.getTextFromChild(currentNode, CPNTypeParser.idNode));
			}
		}

		return unit;
	}

}

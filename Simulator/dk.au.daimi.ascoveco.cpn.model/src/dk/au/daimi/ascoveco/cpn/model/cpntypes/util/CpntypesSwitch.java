/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.util;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage
 * @generated
 */
public class CpntypesSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected final static CpntypesPackage modelPackage = CpntypesPackage.eINSTANCE;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CpntypesSwitch() {
		// Raise visibility
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CpntypesPackage.CPN_TYPE: {
				CPNType cpnType = (CPNType)theEObject;
				T result = caseCPNType(cpnType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_UNIT: {
				CPNUnit cpnUnit = (CPNUnit)theEObject;
				T result = caseCPNUnit(cpnUnit);
				if (result == null) result = caseCPNType(cpnUnit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_ENUM: {
				CPNEnum cpnEnum = (CPNEnum)theEObject;
				T result = caseCPNEnum(cpnEnum);
				if (result == null) result = caseCPNType(cpnEnum);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_PRODUCT: {
				CPNProduct cpnProduct = (CPNProduct)theEObject;
				T result = caseCPNProduct(cpnProduct);
				if (result == null) result = caseCPNType(cpnProduct);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_REAL: {
				CPNReal cpnReal = (CPNReal)theEObject;
				T result = caseCPNReal(cpnReal);
				if (result == null) result = caseCPNType(cpnReal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_INDEX: {
				CPNIndex cpnIndex = (CPNIndex)theEObject;
				T result = caseCPNIndex(cpnIndex);
				if (result == null) result = caseCPNType(cpnIndex);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_STRING: {
				CPNString cpnString = (CPNString)theEObject;
				T result = caseCPNString(cpnString);
				if (result == null) result = caseCPNType(cpnString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_ALIAS: {
				CPNAlias cpnAlias = (CPNAlias)theEObject;
				T result = caseCPNAlias(cpnAlias);
				if (result == null) result = caseCPNType(cpnAlias);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_INT: {
				CPNInt cpnInt = (CPNInt)theEObject;
				T result = caseCPNInt(cpnInt);
				if (result == null) result = caseCPNType(cpnInt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_BOOL: {
				CPNBool cpnBool = (CPNBool)theEObject;
				T result = caseCPNBool(cpnBool);
				if (result == null) result = caseCPNType(cpnBool);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_LIST: {
				CPNList cpnList = (CPNList)theEObject;
				T result = caseCPNList(cpnList);
				if (result == null) result = caseCPNType(cpnList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_RECORD: {
				CPNRecord cpnRecord = (CPNRecord)theEObject;
				T result = caseCPNRecord(cpnRecord);
				if (result == null) result = caseCPNType(cpnRecord);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_UNION: {
				CPNUnion cpnUnion = (CPNUnion)theEObject;
				T result = caseCPNUnion(cpnUnion);
				if (result == null) result = caseCPNType(cpnUnion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.CPN_SUBSET: {
				CPNSubset cpnSubset = (CPNSubset)theEObject;
				T result = caseCPNSubset(cpnSubset);
				if (result == null) result = caseCPNType(cpnSubset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CpntypesPackage.NAME_TYPE_PAIR: {
				NameTypePair nameTypePair = (NameTypePair)theEObject;
				T result = caseNameTypePair(nameTypePair);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Type</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNType(CPNType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Unit</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNUnit(CPNUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Enum</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Enum</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNEnum(CPNEnum object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Product</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNProduct(CPNProduct object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Real</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Real</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNReal(CPNReal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Index</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Index</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNIndex(CPNIndex object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNString(CPNString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Alias</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Alias</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNAlias(CPNAlias object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Int</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Int</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNInt(CPNInt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Bool</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Bool</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNBool(CPNBool object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN List</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNList(CPNList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Record</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Record</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNRecord(CPNRecord object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Union</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Union</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNUnion(CPNUnion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Subset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Subset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNSubset(CPNSubset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name Type Pair</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name Type Pair</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameTypePair(NameTypePair object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // CpntypesSwitch

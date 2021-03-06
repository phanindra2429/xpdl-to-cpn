/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>CPN String</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl#getRangeLow <em>Range Low</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl#getRangeHigh <em>Range High</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl#getLengthLow <em>Length Low</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl#getLengthHigh <em>Length High</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CPNStringImpl extends CPNTypeImpl implements CPNString {
	/**
	 * The default value of the '{@link #getRangeLow() <em>Range Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRangeLow()
	 * @generated
	 * @ordered
	 */
	protected static final String RANGE_LOW_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRangeLow() <em>Range Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRangeLow()
	 * @generated
	 * @ordered
	 */
	protected String rangeLow = RANGE_LOW_EDEFAULT;
	/**
	 * The default value of the '{@link #getRangeHigh() <em>Range High</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRangeHigh()
	 * @generated
	 * @ordered
	 */
	protected static final String RANGE_HIGH_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRangeHigh() <em>Range High</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRangeHigh()
	 * @generated
	 * @ordered
	 */
	protected String rangeHigh = RANGE_HIGH_EDEFAULT;
	/**
	 * The default value of the '{@link #getLengthLow() <em>Length Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLengthLow()
	 * @generated
	 * @ordered
	 */
	protected static final String LENGTH_LOW_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLengthLow() <em>Length Low</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLengthLow()
	 * @generated
	 * @ordered
	 */
	protected String lengthLow = LENGTH_LOW_EDEFAULT;
	/**
	 * The default value of the '{@link #getLengthHigh() <em>Length High</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLengthHigh()
	 * @generated
	 * @ordered
	 */
	protected static final String LENGTH_HIGH_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLengthHigh() <em>Length High</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLengthHigh()
	 * @generated
	 * @ordered
	 */
	protected String lengthHigh = LENGTH_HIGH_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CPNStringImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CpntypesPackage.Literals.CPN_STRING;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRangeLow() {
		return rangeLow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeLow(String newRangeLow) {
		String oldRangeLow = rangeLow;
		rangeLow = newRangeLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_STRING__RANGE_LOW, oldRangeLow, rangeLow));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getRangeHigh() {
		return rangeHigh;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRangeHigh(String newRangeHigh) {
		String oldRangeHigh = rangeHigh;
		rangeHigh = newRangeHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_STRING__RANGE_HIGH, oldRangeHigh, rangeHigh));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLengthLow() {
		return lengthLow;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthLow(String newLengthLow) {
		String oldLengthLow = lengthLow;
		lengthLow = newLengthLow;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_STRING__LENGTH_LOW, oldLengthLow, lengthLow));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getLengthHigh() {
		return lengthHigh;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLengthHigh(String newLengthHigh) {
		String oldLengthHigh = lengthHigh;
		lengthHigh = newLengthHigh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CpntypesPackage.CPN_STRING__LENGTH_HIGH, oldLengthHigh, lengthHigh));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CpntypesPackage.CPN_STRING__RANGE_LOW:
				return getRangeLow();
			case CpntypesPackage.CPN_STRING__RANGE_HIGH:
				return getRangeHigh();
			case CpntypesPackage.CPN_STRING__LENGTH_LOW:
				return getLengthLow();
			case CpntypesPackage.CPN_STRING__LENGTH_HIGH:
				return getLengthHigh();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CpntypesPackage.CPN_STRING__RANGE_LOW:
				setRangeLow((String)newValue);
				return;
			case CpntypesPackage.CPN_STRING__RANGE_HIGH:
				setRangeHigh((String)newValue);
				return;
			case CpntypesPackage.CPN_STRING__LENGTH_LOW:
				setLengthLow((String)newValue);
				return;
			case CpntypesPackage.CPN_STRING__LENGTH_HIGH:
				setLengthHigh((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CpntypesPackage.CPN_STRING__RANGE_LOW:
				setRangeLow(RANGE_LOW_EDEFAULT);
				return;
			case CpntypesPackage.CPN_STRING__RANGE_HIGH:
				setRangeHigh(RANGE_HIGH_EDEFAULT);
				return;
			case CpntypesPackage.CPN_STRING__LENGTH_LOW:
				setLengthLow(LENGTH_LOW_EDEFAULT);
				return;
			case CpntypesPackage.CPN_STRING__LENGTH_HIGH:
				setLengthHigh(LENGTH_HIGH_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CpntypesPackage.CPN_STRING__RANGE_LOW:
				return RANGE_LOW_EDEFAULT == null ? rangeLow != null : !RANGE_LOW_EDEFAULT.equals(rangeLow);
			case CpntypesPackage.CPN_STRING__RANGE_HIGH:
				return RANGE_HIGH_EDEFAULT == null ? rangeHigh != null : !RANGE_HIGH_EDEFAULT.equals(rangeHigh);
			case CpntypesPackage.CPN_STRING__LENGTH_LOW:
				return LENGTH_LOW_EDEFAULT == null ? lengthLow != null : !LENGTH_LOW_EDEFAULT.equals(lengthLow);
			case CpntypesPackage.CPN_STRING__LENGTH_HIGH:
				return LENGTH_HIGH_EDEFAULT == null ? lengthHigh != null : !LENGTH_HIGH_EDEFAULT.equals(lengthHigh);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rangeLow: ");
		result.append(rangeLow);
		result.append(", rangeHigh: ");
		result.append(rangeHigh);
		result.append(", lengthLow: ");
		result.append(lengthLow);
		result.append(", lengthHigh: ");
		result.append(lengthHigh);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#asString()
	 */
	public String asString() {
		return "string" + postFixAsString();
	}

} // CPNStringImpl

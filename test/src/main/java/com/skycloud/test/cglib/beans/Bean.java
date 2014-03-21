package com.skycloud.test.cglib.beans;

import java.beans.*;

/***
 * 
 * @author baliuka
 */
public abstract class Bean implements java.io.Serializable {

	/** serialVersionUID [long] */
	private static final long serialVersionUID = 2243656224902802339L;

	String sampleProperty;

	abstract public void addPropertyChangeListener(PropertyChangeListener listener);

	abstract public void removePropertyChangeListener(PropertyChangeListener listener);

	public String getSampleProperty() {
		return sampleProperty;
	}

	public void setSampleProperty(String value) {
		this.sampleProperty = value;
	}

	public String toString() {
		return "sampleProperty is " + sampleProperty;
	}

}
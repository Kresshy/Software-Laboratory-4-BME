/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.BaseObject;

/**
 * Pályaelemek grafikus ősosztálya.
 * 
 * @param <T> a csatolt pályaelem típusa
 */
public abstract class GraphicsBase<T extends BaseObject> implements GraphicsObject {

	/**
	 * Csatolt pályaelem.
	 */
	protected T	wrappedObject;

	/**
	 * Páldányosít egy grafikus pályaelemet.
	 * 
	 * @param wrappedObject a csatolt pályaelem
	 */
	public GraphicsBase(T wrappedObject) {
		this.wrappedObject = wrappedObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(GraphicsBase<T> o) {
		try {
			return wrappedObject == o.wrappedObject;
		} catch (ClassCastException e) {
			return false;
		}
	}

	/**
	 * Lekérdezi a csatolt pályaelemet.
	 * 
	 * @return a csatolt pályaelem
	 */
	public T getWrappedObject() {
		return wrappedObject;
	}

	/**
	 * Beállítja a csatolt pályaelemet.
	 * 
	 * @param wrappedObject az új csatolt pályaelem
	 */
	public void setWrappedObject(T wrappedObject) {
		this.wrappedObject = wrappedObject;
	}
}

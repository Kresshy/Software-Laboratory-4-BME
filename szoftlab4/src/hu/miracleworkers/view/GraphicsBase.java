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

	private static final int	paintScale	= 2;

	/**
	 * Csatolt pályaelem.
	 */
	protected T					wrappedObject;

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
		return wrappedObject == o.wrappedObject;
	}

	/**
	 * Lekérdezi kirajzolási méretet.
	 * 
	 * @return a kirajzolási méret
	 */
	public int getPaintSize() {
		return 2 * wrappedObject.getRadius() * paintScale;
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

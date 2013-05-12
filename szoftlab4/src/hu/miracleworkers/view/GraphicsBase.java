/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.BaseObject;
import hu.miracleworkers.model.Point;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Pályaelemek grafikus ősosztálya.
 * 
 * @param <T> a csatolt pályaelem típusa
 */
public abstract class GraphicsBase<T extends BaseObject> implements GraphicsObject {

	private static final int	paintScale	= 1;

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
	 * Lekérdezi a csatolt pályaelem színét.
	 * 
	 * @return a csatolt pályaelem színe
	 */
	public abstract Color getColor();

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// Pályaelem kirajzolása
		int size = getPaintSize();
		Point pos = wrappedObject.getPosition();
		graphics.setColor(getColor());
		graphics.fillOval(pos.getCoordX() - size / 2, pos.getCoordY() - size / 2, size, size);
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

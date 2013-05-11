/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Ant;

import java.awt.Graphics;

/**
 * Hangya grafikus osztály.
 */
public class GAnt extends GraphicsBase<Ant> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt hangya példány
	 */
	public GAnt(Ant wrappedObject) {
		super(wrappedObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// TODO Auto-generated method stub

	}

}

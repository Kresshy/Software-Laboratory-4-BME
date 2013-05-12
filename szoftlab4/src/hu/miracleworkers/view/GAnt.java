/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Ant;

import java.awt.Color;

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

	@Override
	public Color getColor() {
		// Hangya színe
		return Color.BLACK;
	}

}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Poison;

import java.awt.Color;

/**
 * Méreg grafikus osztály.
 */
public class GPoison extends GraphicsBase<Poison> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt méreg példány
	 */
	public GPoison(Poison wrappedObject) {
		super(wrappedObject);
	}

	@Override
	public Color getColor() {
		// Méreg színe
		return Color.GREEN;
	}

}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Creature;

import java.awt.Color;

/**
 * Élőlény grafikus osztály.
 */
public class GCreature extends GraphicsBase<Creature> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt élőlény példány
	 */
	public GCreature(Creature wrappedObject) {
		super(wrappedObject);
	}

	@Override
	public Color getColor() {
		// Élőlény színe (gyakorlatilag hangyászsün)
		return Color.GRAY;
	}

}

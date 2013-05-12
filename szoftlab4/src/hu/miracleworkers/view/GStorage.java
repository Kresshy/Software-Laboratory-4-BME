/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Storage;

import java.awt.Color;

/**
 * Tároló grafikus osztály.
 */
public class GStorage extends GraphicsBase<Storage> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt tároló példány
	 */
	public GStorage(Storage wrappedObject) {
		super(wrappedObject);
	}

	@Override
	public Color getColor() {
		// Tárolók színe
		if (wrappedObject.isAttractive()) {
			// Ételraktár színe
			return Color.RED;
		} else {
			// Hangyaboly színe
			return Color.ORANGE;
		}
	}

}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Storage;

import java.awt.Graphics;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// TODO: Tárolók kirajzolása
		if (wrappedObject.isAttractive()) {
			// Ételraktár kirajzolása
		} else {
			// Hangyaboly kirajzolása
		}
	}

}

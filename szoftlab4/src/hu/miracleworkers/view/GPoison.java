/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Point;
import hu.miracleworkers.model.Poison;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Méreg grafikus osztály.
 */
public class GPoison extends GraphicsBase<Poison> {

	private static final BufferedImage	image	= loadImage("graphics/poison.png");

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt méreg példány
	 */
	public GPoison(Poison wrappedObject) {
		super(wrappedObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// Méreg kirajzolása
		int size = getPaintSize();
		Point pos = wrappedObject.getPosition();
		graphics.drawImage(image, pos.getCoordX() - (size / 2), pos.getCoordY() - (size / 2), size,
				size, null);
	}

}

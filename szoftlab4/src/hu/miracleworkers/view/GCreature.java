/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.AntEater;
import hu.miracleworkers.model.Creature;
import hu.miracleworkers.model.Point;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Élőlény grafikus osztály.
 */
public class GCreature extends GraphicsBase<Creature> {

	private static final BufferedImage	anteater	= loadImage("graphics/anteater.png");

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt élőlény példány
	 */
	public GCreature(Creature wrappedObject) {
		super(wrappedObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// Hangyászsün kirajzolása
		if (((AntEater) wrappedObject).isVisible()) {
			int size = getPaintSize();
			Point pos = wrappedObject.getPosition();
			graphics.drawImage(anteater, pos.getCoordX() - (size / 2),
					pos.getCoordY() - (size / 2), size, size, null);
		}
	}
}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Obstacle;
import hu.miracleworkers.model.Point;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Akadály grafikus osztály.
 */
public class GObstacle extends GraphicsBase<Obstacle> {

	private static final BufferedImage	pebble		= loadImage("graphics/pebble.png");
	private static final BufferedImage	puddle		= loadImage("graphics/puddle.png");
	private static final BufferedImage	antsinker	= loadImage("graphics/antsinker.png");

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt akadály példány
	 */
	public GObstacle(Obstacle wrappedObject) {
		super(wrappedObject);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// Akadályok kirajzolása
		BufferedImage image;
		if (wrappedObject.isMovable()) {
			// Kavics kirajzolása
			image = pebble;
		} else {
			if (wrappedObject.isSolid()) {
				// Pocsolya kirajzolása
				image = puddle;
			} else {
				// Hangyaleső kirajzolása
				image = antsinker;
			}
		}
		int size = getPaintSize();
		Point pos = wrappedObject.getPosition();
		graphics.drawImage(image, pos.getCoordX() - (size / 2), pos.getCoordY() - (size / 2), size,
				size, null);
	}

}

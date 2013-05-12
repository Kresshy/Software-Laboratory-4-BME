/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Ant;
import hu.miracleworkers.model.Point;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Hangya grafikus osztály.
 */
public class GAnt extends GraphicsBase<Ant> {

	private static final BufferedImage	normal				= loadImage("graphics/ant.png");
	private static final BufferedImage	poisoned			= loadImage("graphics/ant_poisoned.png");
	private static final BufferedImage	withCargo			= loadImage("graphics/ant_withcargo.png");
	private static final BufferedImage	poisonedWithCargo	= loadImage("graphics/ant_poisoned_withcargo.png");

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
		// Hangya kirajzolása
		BufferedImage image = normal;
		// TODO: Hangya különböző állapotai
		// TODO: Hangya forgatása
		int size = getPaintSize();
		Point pos = wrappedObject.getPosition();
		graphics.drawImage(image, pos.getCoordX() - (size / 2), pos.getCoordY() - (size / 2), size,
				size, null);
	}

}

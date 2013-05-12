/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Ant;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Hangya grafikus osztály.
 */
public class GAnt extends GraphicsBase<Ant> {

	BufferedImage	ant;

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt hangya példány
	 */
	public GAnt(Ant wrappedObject) {
		super(wrappedObject);
		try {

			ant = ImageIO.read(new File("graphics\\hangya.png"));

		} catch (IOException e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// TODO: Hangya kirajzolása

		Ant wrappedAnt = getWrappedObject();
		graphics.drawImage(ant, wrappedAnt.getPosition().getCoordX() - (ant.getWidth() / 2), wrappedAnt.getPosition()
				.getCoordY() - (ant.getHeight() / 2), getPaintSize(), getPaintSize(), null);
	}

}

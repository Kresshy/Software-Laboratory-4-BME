/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Creature;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Élőlény grafikus osztály.
 */
public class GCreature extends GraphicsBase<Creature> {

	BufferedImage	anteater;

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt élőlény példány
	 */
	public GCreature(Creature wrappedObject) {
		super(wrappedObject);
		try {

			anteater = ImageIO.read(new File("graphics\\sün.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		Creature wrappedCreature = getWrappedObject();
		graphics.drawImage(anteater, wrappedCreature.getPosition().getCoordX(), wrappedCreature
				.getPosition().getCoordY(), null);
	}
}

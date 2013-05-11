/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Obstacle;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Akadály grafikus osztály.
 */
public class GObstacle extends GraphicsBase<Obstacle> {

	BufferedImage	pebble, puddle, antsinker;

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt akadály példány
	 */
	public GObstacle(Obstacle wrappedObject) {
		super(wrappedObject);

		try {

			pebble = ImageIO.read(new File("graphics\\kavics.png"));
			puddle = ImageIO.read(new File("graphics\\pocsolya.png"));
			antsinker = ImageIO.read(new File("graphics\\hangyanyelő.png"));

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
		// TODO: Akadályok kirajzolása

		Obstacle wrappedObstacle = getWrappedObject();
		if (wrappedObject.isMovable()) {
			graphics.drawImage(pebble, wrappedObstacle.getPosition().getCoordX(), wrappedObstacle
					.getPosition().getCoordY(), null);
		} else {
			if (wrappedObject.isSolid()) {
				graphics.drawImage(puddle, wrappedObstacle.getPosition().getCoordX(),
						wrappedObstacle.getPosition().getCoordY(), null);
			} else {
				graphics.drawImage(antsinker, wrappedObstacle.getPosition().getCoordX(),
						wrappedObstacle.getPosition().getCoordY(), null);
			}
		}
	}

}

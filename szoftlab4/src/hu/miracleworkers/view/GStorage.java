/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Storage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Tároló grafikus osztály.
 */
public class GStorage extends GraphicsBase<Storage> {

	BufferedImage	foodstorage, anthill;

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt tároló példány
	 */
	public GStorage(Storage wrappedObject) {
		super(wrappedObject);
		try {

			anthill = ImageIO.read(new File("graphics\\hangyaboly.png"));
			foodstorage = ImageIO.read(new File("graphics\\foodstorage.png"));

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
		// TODO: Tárolók kirajzolása
		Storage wrappedStorage = getWrappedObject();
		if (wrappedObject.isAttractive()) {
			graphics.drawImage(foodstorage, wrappedStorage.getPosition().getCoordX(),
					wrappedStorage.getPosition().getCoordY(), null);
		} else {
			graphics.drawImage(anthill, wrappedStorage.getPosition().getCoordX(), wrappedStorage
					.getPosition().getCoordY(), null);
		}
	}

}

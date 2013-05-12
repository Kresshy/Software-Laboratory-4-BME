/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Point;
import hu.miracleworkers.model.Storage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Tároló grafikus osztály.
 */
public class GStorage extends GraphicsBase<Storage> {

	private static final BufferedImage	foodstorage0	= loadImage("graphics/foodstorage_0.png");
	private static final BufferedImage	foodstorage1	= loadImage("graphics/foodstorage_1.png");
	private static final BufferedImage	foodstorage2	= loadImage("graphics/foodstorage_2.png");
	private static final BufferedImage	foodstorage3	= loadImage("graphics/foodstorage_3.png");
	private static final BufferedImage	foodstorage4	= loadImage("graphics/foodstorage_4.png");
	private static final BufferedImage	anthill			= loadImage("graphics/anthill.png");

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
		// Tárolók kirajzolása
		BufferedImage image;
		Storage wrappedStorage = getWrappedObject();
		if (wrappedObject.isAttractive()) {
			// Ételraktár kirajzolása
			// TODO: Ételmennyiségtől függő kép kiválasztása
			image = foodstorage4;
		} else {
			// Hangyaboly kirajzolása
			image = anthill;
		}
		int size = getPaintSize();
		Point pos = wrappedObject.getPosition();
		graphics.drawImage(image, pos.getCoordX() - (size / 2), pos.getCoordY() - (size / 2), size,
				size, null);
	}
}

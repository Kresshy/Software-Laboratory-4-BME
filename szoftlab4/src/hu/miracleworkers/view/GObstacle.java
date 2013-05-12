/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Obstacle;

import java.awt.Color;

/**
 * Akadály grafikus osztály.
 */
public class GObstacle extends GraphicsBase<Obstacle> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt akadály példány
	 */
	public GObstacle(Obstacle wrappedObject) {
		super(wrappedObject);
	}

	@Override
	public Color getColor() {
		// Akadályok kirajzolása
		if (wrappedObject.isMovable()) {
			// Kavics színe
			return Color.LIGHT_GRAY;
		} else {
			if (wrappedObject.isSolid()) {
				// Pocsolya színe
				return Color.CYAN;
			} else {
				// Hangyaleső színe
				return Color.YELLOW;
			}
		}
	}

}

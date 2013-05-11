/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Obstacle;

import java.awt.Graphics;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// TODO: Akadályok kirajzolása
		if (wrappedObject.isMovable()) {
			// Kavics kirajzolása
		} else {
			if (wrappedObject.isSolid()) {
				// Tócsa kirajzolása
			} else {
				// Hangyaleső kirajzolása
			}
		}
	}

}

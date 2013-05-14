/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Effect;
import hu.miracleworkers.model.Point;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

/**
 * Effektek grafikus osztály.
 */
public class GEffects implements GraphicsObject {

	private Map<Point, Effect>	effects;

	/**
	 * Példányosít egy új grafikus elemet.
	 */
	public GEffects() {
		effects = new HashMap<Point, Effect>();
	}

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param effects a pályán található effektek
	 */
	public GEffects(Map<Point, Effect> effects) {
		this.effects = effects;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// Effektek kirajzolása (konkrétan a szagnyomok)
		graphics.setColor(Color.RED);
		for (Point pos : effects.keySet()) {
			graphics.fillOval(pos.getCoordX() - 1, pos.getCoordY() - 1, 3, 3);
		}
	}

	public void setEffects(Map<Point, Effect> effects) {
		this.effects = effects;
	}

}

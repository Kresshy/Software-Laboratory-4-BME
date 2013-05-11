/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.Effect;
import hu.miracleworkers.model.Point;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.view.GraphicsObject#paintObject(java.awt.Graphics)
	 */
	@Override
	public void paintObject(Graphics graphics) {
		// TODO Auto-generated method stub

	}

	public void setEffects(Map<Point, Effect> effects) {
		this.effects = effects;
	}

}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import java.awt.Graphics;

/**
 * Grafikus objektumok interfésze.
 */
public interface GraphicsObject {

	/**
	 * Objektum kirajzolása.
	 * 
	 * @param graphics a kirajzoláshoz használt "vászon"
	 */
	public void paintObject(Graphics graphics);

}

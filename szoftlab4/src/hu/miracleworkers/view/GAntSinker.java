/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.model.AntSinker;

import java.awt.Graphics;

/**
 * Hangyaleső grafikus osztály.
 */
public class GAntSinker extends GraphicsBase<AntSinker> {

	/**
	 * Példányosít egy új grafikus elemet.
	 * 
	 * @param wrappedObject a csatolt hangyaleső példány
	 */
	public GAntSinker(AntSinker wrappedObject) {
		super(wrappedObject);
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

}

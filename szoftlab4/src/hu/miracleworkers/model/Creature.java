/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Élőlény osztály.
 */
public abstract class Creature extends BaseObject {

	/** Pálya */
	protected Scene	scene;

	/**
	 * Példányosít egy új élőlényt.
	 * 
	 * @param position az élőlény pozíciója
	 * @param scene a pálya amihez az élőlény tartozik
	 * @param radius az élőlény hatóköre
	 */
	public Creature(Point position, Scene scene, int radius) {
		super(position, radius);
		this.scene = scene;
	}

	/**
	 * Lekérdezi a pályát amihez az élőlény tartozik.
	 */
	public Scene getScene() {

		return scene;

	}

	/**
	 * Az élőlény megölése.
	 */
	public void terminate() {

		// Dummy default implementáció

	}

}

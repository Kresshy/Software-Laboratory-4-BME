package hu.miracleworkers.model;

import java.awt.Color;

public abstract class Creature extends BaseObject {

	protected Scene	scene;

	public Creature(Point position, Color color, int radius, Scene scene) {
		super(position, color, radius);
		this.scene = scene;
	}

	public void setScene(Scene scene) {

		// Pálya beállítása
		this.scene = scene;

	}

	public void terminate() {

		// Dummy default implementáció

	}

}

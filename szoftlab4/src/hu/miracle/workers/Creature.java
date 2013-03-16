package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public abstract class Creature extends BaseObject {

	protected Scene scene;

	public Creature(Point position, Color color, int radius, Scene scene) {
		super(position, color, radius);
		this.scene = scene;
	}

	public void setScene(Scene scene) {
		System.out.println(getClass().getCanonicalName() + ".setScene()");

		// Pálya beállítása
		this.scene = scene;
	}

	public void terminate() {
		System.out.println(getClass().getCanonicalName() + ".terminate()");
	}

}

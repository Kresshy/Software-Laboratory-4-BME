package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class AntHill extends Storage {

	private Scene scene;

	public AntHill(Point position, Scene scene, int capacity, int packet) {
		super(position, Color.BLUE, 3, capacity, packet, false); // TODO: Grafikus jellemzők meghatározása
		this.scene = scene;
	}
	
	@Override
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		// Hangyák születése
		// Minden hangyára
		for (int i = getItems(); i > 0; i--) {
			// Létrehozás
			Ant ant = new Ant(getPosition(), scene, this);
			// Tárolás
			scene.getAnts().add(ant);
		}
	}

}

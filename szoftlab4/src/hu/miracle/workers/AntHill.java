package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class AntHill extends Storage {

	private Scene scene;

	public AntHill(Point position, Scene scene, int capacity) {
		super(position, Color.BLUE, 3, capacity, false); // TODO: Grafikus jellemzők meghatározása
		this.scene = scene;
	}

	@Override
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");

		// Maximum kivehető elemek meghatározása
		int count = Math.min(capacity - amount, 3);
		// Elemek kivétele
		amount += count;
		// Elemek visszaadása
		return count;
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

	@Override
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");

		// Hangyák halála
		// Sorbaállítás
		amount -= count;
	}

}

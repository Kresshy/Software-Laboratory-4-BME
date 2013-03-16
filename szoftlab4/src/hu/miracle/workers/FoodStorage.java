package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class FoodStorage extends Storage {

	// Constructor
	public FoodStorage(Point position, int capacity) {
		super(position, Color.RED, 3, capacity, true); // TODO: Grafikus jellemzők meghatározása
	}

	// Public interface
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// etelfelvetel
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");

		if (amount > 0) {
			amount--;
			return 1;
		} else {
			return 0;
		}

	}

	// etelvisszarakas
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");

		if (capacity < amount + count) {
			this.amount += capacity - amount;
		} else {
			this.amount += count;
		}
	}
}

package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // Tarolt elemek
	protected int capacity; // Tarolt elemek maximalis szama
	protected int packet;
	protected boolean attractive;

	public Storage(Point position, Color color, int radius, int capacity, int packet, boolean attractive) {
		super(position, color, radius);
		this.capacity = capacity;
		this.attractive = attractive;
	}

	// Abstract methods
	// Tarolobol elemeket vesz ki, etelfelvetelhez szukseges
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");

		// Maximálisan kivehető elemek meghatározása
		int count = Math.min(capacity - amount, packet);
		// Tárolt elemek csökkentése
		amount -= count;
		// Kivett elemek visszaadása
		return count;
	}

	// Taroloba elemeket tesz vissza, etel visszatetelehez es
	// hangyak ujjaeledesehez szukseges
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");
		
		// Tárolt elemek növelése
		amount = Math.min(capacity, amount + count);
	}

	// Public interface
	public boolean hasItems() {
		return (amount < 0);
	}

	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");
		// FIXME
		return false;
	}

}

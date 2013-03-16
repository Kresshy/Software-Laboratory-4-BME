package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // Tarolt elemek
	protected int capacity; // Tarolt elemek maximalis szama
	protected boolean attractive;

	public Storage(Point position, Color color, int radius, int capacity, boolean attractive) {
		super(position, color, radius);
		this.capacity = capacity;
		this.attractive = attractive;
	}

	// Abstract methods
	// Tarolobol elemeket vesz ki, etelfelvetelhez szukseges
	public abstract int getItems();

	// Taroloba elemeket tesz vissza, etel visszatetelehez es
	// hangyak ujjaeledesehez szukseges
	public abstract void putItems(int count);

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

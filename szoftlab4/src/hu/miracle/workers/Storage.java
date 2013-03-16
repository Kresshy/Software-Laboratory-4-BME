package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public abstract class Storage extends BaseObject {

	protected int amount;
	protected int capacity;
	protected int packet;
	protected boolean attractive;

	public Storage(Point position, Color color, int radius, int capacity, int packet,
			boolean attractive) {
		super(position, color, radius);
		this.capacity = capacity;
		this.attractive = attractive;
	}

	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");

		// Maximálisan kivehető elemek meghatározása
		int count = Math.min(capacity - amount, packet);
		// Tárolt elemek csökkentése
		amount -= count;
		// Kivett elemek visszaadása
		return count;
	}

	public boolean hasItems() {

		// Tartalmazás visszaadása
		return (amount < 0);
	}

	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");

		// Vonzalom visszadása
		return attractive;
	}

	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");

		// Tárolt elemek növelése
		amount = Math.min(capacity, amount + count);
	}

}

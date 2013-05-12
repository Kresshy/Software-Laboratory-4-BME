/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.view.GStorage;
import hu.miracleworkers.view.GraphicsBase;

/**
 * Tároló osztály.
 */
public abstract class Storage extends BaseObject {

	/** Tárolt elemek száma. */
	protected int		amount;

	/** Tárolható elemek maximális száma. */
	protected int		capacity;

	/** Elemkivételkor kiadott elemek száma. */
	protected int		packet;

	/** Vonzás. */
	protected boolean	attractive;

	/**
	 * Példányosít egy új tárolót.
	 * 
	 * @param position a tároló pozíciója
	 * @param radius a tároló hatóköre
	 * @param capacity a tárolt elemek maximális száma
	 * @param packet az egyszerre kiadott elemek száma
	 * @param attractive az tároló vonzó-e a hangyák számára
	 */
	public Storage(Point position, int radius, int capacity, int packet, boolean attractive) {
		super(position, radius);
		this.capacity = capacity;
		this.amount = capacity;
		this.packet = packet;
		this.attractive = attractive;
	}

	/**
	 * Lekérdezi a tárolt elemek számát.
	 * 
	 * @return a tárolt elemek száma
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * Lekérdezi a tárolható elemek maximális számát.
	 * 
	 * @return a tárolható elemek maximális száma
	 */
	public int getCapacity() {
		return capacity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.BaseObject#getGraphicsWrapper()
	 */
	@Override
	public GraphicsBase getGraphicsWrapper() {
		return new GStorage(this);
	}

	/**
	 * Elemek kivétele.
	 * 
	 * @return a kivett elemek száma
	 */
	public int getItems() {

		// Maximálisan kivehető elemek meghatározása
		int count = Math.min(amount, packet);
		// Tárolt elemek csökkentése
		amount -= count;

		// Kivett elemek visszaadása
		return count;
	}

	/**
	 * Ellenőrzi, hogy a tároló tartalmaz-e elemeket.
	 * 
	 * @return true, ha a tároló tartalmaz elemeket.
	 */
	public boolean hasItems() {

		// Tartalmazás visszaadása
		return (amount > 0);
	}

	/**
	 * Ellenőrzi, hogy a tároló vonzza-e a hangyákat.
	 * 
	 * @return true, ha a tároló vonzza a hangyákat
	 */
	public boolean isAttractive() {

		// Vonzalom visszadása
		return attractive;
	}

	/**
	 * Elemek berakása.
	 * 
	 * @param count a berakandó elemek száma
	 */
	public void putItems(int count) {

		// Tárolt elemek növelése
		amount = Math.min(capacity, amount + count);

	}
}

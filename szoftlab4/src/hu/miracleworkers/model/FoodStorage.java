/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Ételraktár osztály.
 */
public class FoodStorage extends Storage {

	/**
	 * Példányosít egy új ételraktárat.
	 * 
	 * @param position az ételraktár pozíciója
	 * @param capacity az ételraktárban tárolható ételek maximális száma
	 * @param packet a hangyánként kiadott étel mennyisége
	 */
	public FoodStorage(Point position, int capacity, int packet) {
		super(position, 45, capacity, packet, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.SceneObject#handleTick()
	 */
	@Override
	public void handleTick() {

		// Dummy default implementáció

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"FoodStorage %%d < position = %s, amount = %d, capacity = %d, packet = %d >",
				position, amount, capacity, packet);
	}

}

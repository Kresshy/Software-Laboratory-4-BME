package hu.miracle.workers;

import java.awt.Color;

public class FoodStorage extends Storage {

	public FoodStorage(Point position, int capacity, int packet) {
		super(position, Color.RED, 3, capacity, packet, true); // TODO: Grafikus jellemzők meghatározása
	}

	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

	public String toString() {
		return String.format(
				"FoodStorage %%d < position = %s, amount = %d, capacity = %d, packet = %d >",
				position, amount, capacity, packet);
	}

}

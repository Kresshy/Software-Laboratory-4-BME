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
	public String toString(){
		return String.format("FoodStorage %%d < position = (%d,%d), amount = %d, capacity = %d, packet = %d >", position.getX(), position.getY(),amount,capacity,packet);
	}

}

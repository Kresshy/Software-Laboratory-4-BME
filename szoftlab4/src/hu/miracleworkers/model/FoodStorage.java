package hu.miracleworkers.model;

public class FoodStorage extends Storage {

	public FoodStorage(Point position, int capacity, int packet) {
		super(position, 3, capacity, packet, true);
	}

	public void handleTick() {

		// Dummy default implementáció

	}

	public String toString() {
		return String.format(
				"FoodStorage %%d < position = %s, amount = %d, capacity = %d, packet = %d >",
				position, amount, capacity, packet);
	}

}

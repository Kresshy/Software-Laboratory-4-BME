package hu.miracle.workers;

public class FoodStorage extends Storage {

	private static final String className = "FoodStorage";

	// Constructor
	public FoodStorage() {
	}

	// Public interface
	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	// Etelfelvetel !!!!!!!!!!!!!!!!!!!!!!!!
	public int getItems() {
		System.out.println(className + " getItems");
		return 0;
	}

	// Etelvisszarakas
	public void putItems(int count) {
		System.out.println(className + " putItems");
	}
}

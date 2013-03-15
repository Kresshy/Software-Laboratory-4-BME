package hu.miracle.workers;

public class FoodStorage extends Storage {

	// Constructor
	public FoodStorage() {
	}

	// Public interface
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// etelfelvetel
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");
		return 0;
	}

	// etelvisszarakas
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");
	}
}

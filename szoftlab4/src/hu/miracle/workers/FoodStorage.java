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

	public int getItems() { // �telfelv�tel !!!!!!!!!!!!!!!!!!!!!!!!
		System.out.println(className + " getItems");
		return 0;
	}

	public void putItems(int count) {
		System.out.println(className + " putItems");
	} // �telvisszarak�s
}

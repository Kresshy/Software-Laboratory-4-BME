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

	 // �telfelv�tel !!!!!!!!!!!!!!!!!!!!!!!!
	public int getItems() {
		System.out.println(className + " getItems");
		return 0;
	}

	// �telvisszarak�s
	public void putItems(int count) {
		System.out.println(className + " putItems");
	} 
}

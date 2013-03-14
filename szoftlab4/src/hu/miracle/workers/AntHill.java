package hu.miracle.workers;

public class AntHill extends Storage {

	private static final String className = "AntHill";

	// Members
	private Scene scene; // Szükséges hogy a hangyák ismerhessék a scene-t

	// Constructor
	public AntHill() {
	}

	// Protected methods
	// Itt vissza kéne adni a storage elemeit, jelenleg a hangyákat, illetve annak a számát
	public int getItems() { // Remélem lehet így kitakarni - sajnos nem lehet !!!!!!!!!!!!
		System.out.println(className + " getItems");
		return 0;
	}

	// Public interface
	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	public void putItems(int count) {
		System.out.println(className + " putItems");
	} // Hangyák halálakor, hogy újabb hangya szülessen
}

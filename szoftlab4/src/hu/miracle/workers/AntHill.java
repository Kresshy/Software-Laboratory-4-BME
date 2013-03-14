package hu.miracle.workers;

public class AntHill extends Storage {

	private static final String className = "AntHill";

	// Members
	private Scene scene; // Sz�ks�ges hogy a hangy�k ismerhess�k a scene-t

	// Constructor
	public AntHill() {
	}

	// Protected methods
	// Itt vissza k�ne adni a storage elemeit, jelenleg a hangy�kat, illetve annak a sz�m�t
	public int getItems() { // Rem�lem lehet �gy kitakarni - sajnos nem lehet !!!!!!!!!!!!
		System.out.println(className + " getItems");
		return 0;
	}

	// Public interface
	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	public void putItems(int count) {
		System.out.println(className + " putItems");
	} // Hangy�k hal�lakor, hogy �jabb hangya sz�lessen
}

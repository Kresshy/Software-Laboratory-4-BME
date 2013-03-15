package hu.miracle.workers;

public class AntHill extends Storage {

	// Members
	private Scene scene; // Szukseges hogy a hangyak ismerhessek a scene-t

	// Constructor
	public AntHill() {
	}

	// Protected methods
	// Nem hasznaljuk kivulrol, mert a storage-bol elem kivetelere van. Viszont
	// a visszateresi ertekeben be lehet konfigolni hanyasaval spawnoljanak a
	// hangyak.
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");
		return 0;
	}

	// Public interface
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (amount < capacity) {
			// Hangya letrehozasa
			amount += 1;
		}
	}

	// Hangyak halalakor uj hangya szulethessen
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");
	} // Hangyak halalakor, hogy ujabb hangya szulessen

}

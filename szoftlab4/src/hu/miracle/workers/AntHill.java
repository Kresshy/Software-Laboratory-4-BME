package hu.miracle.workers;

public class AntHill extends Storage {

	// Members
	private Scene scene; // Szükséges hogy a hangyák ismerhessék a scene-t

	// Constructor
	public AntHill() {
	}

	// Protected methods
	// Nem használjuk kivülről, mert a storage-ból elem kivételére van. Viszont
	// a visszatérési értékében be lehet konfigolni hányasával spawnoljanak a
	// hangyák.
	// TODO
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");
		return 0;
	}

	// Public interface
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// Hangyak halalakor uj hangya szulethessen
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");
		// TODO
	} // Hangyák halálakor, hogy újabb hangya szülessen

}

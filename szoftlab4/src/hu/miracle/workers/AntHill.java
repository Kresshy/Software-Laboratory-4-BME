package hu.miracle.workers;

public class AntHill extends Storage {

	// Members
	private Scene scene; // Szukseges hogy a hangyak ismerhessek a scene-t

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

		if (amount < capacity) {
			// Hangya letrehozasa
			amount += 1;
		}
	}

	// Hangyák halálakor, hogy újabb hangya szülessen
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");
		// TODO
	}

}

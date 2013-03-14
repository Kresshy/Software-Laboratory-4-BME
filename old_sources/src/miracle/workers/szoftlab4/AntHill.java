package miracle.workers.szoftlab4;

public class AntHill extends Storage {
	// Members
    private Scene scene; // Szükséges hogy a hangyák ismerhessék a scene-t

    // Constructor
    public AntHill() {}

    // Protected methods
    public int getItems() { // Remélem lehet így kitakarni - sajnos nem lehet !!!!!!!!!!!!!!!!!
		return 0;
	}

    // Public interface
    public void handleTick() {}
    public void putItems(int count) {} // Hangyák halálakor, hogy újabb hangya szülessen
}

package miracle.workers.szoftlab4;

public class AntHill extends Storage {
	// Members
    private Scene scene; // Sz�ks�ges hogy a hangy�k ismerhess�k a scene-t

    // Constructor
    public AntHill() {}

    // Protected methods
    public int getItems() { // Rem�lem lehet �gy kitakarni - sajnos nem lehet !!!!!!!!!!!!!!!!!
		return 0;
	}

    // Public interface
    public void handleTick() {}
    public void putItems(int count) {} // Hangy�k hal�lakor, hogy �jabb hangya sz�lessen
}

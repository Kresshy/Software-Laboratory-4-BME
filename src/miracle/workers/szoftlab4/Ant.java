package miracle.workers.szoftlab4;

public class Ant extends Creature {
	// Members
    private Storage home;
    private Storage source;
    private boolean poisoned;
    private int health;
    private int cargo;

    // Constructor
    public Ant() {}

    // Protected methods
    protected void routeAndMove() {}

    // Public interface
    public void setSource(Storage storage) {} // �telfelv�telkor haszn�lva, hogy tudja hova kell visszavinni hal�l eset�n
    public void setPoisoned(boolean poisoned) {}
    public void handleTick() {}
    public void terminate() {} // Override
}

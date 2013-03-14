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
    public void setSource(Storage storage) {} // Ételfelvételkor használva, hogy tudja hova kell visszavinni halál esetén
    public void setPoisoned(boolean poisoned) {}
    public void handleTick() {}
    public void terminate() {} // Override
}

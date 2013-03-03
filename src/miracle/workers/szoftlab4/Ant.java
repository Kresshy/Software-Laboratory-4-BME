package miracle.workers.szoftlab4;

public class Ant extends Creature {
	// Members
    private AntHill home;
    private FoodStorage source;
    private boolean poisoned;
    private boolean cargo;
    private int health;

    // Constructor
    public Ant() {}

    // Public interface
    public void setSource(FoodStorage source) {}
    public void handleTick() {}
    public void terminateAnt() {}
}

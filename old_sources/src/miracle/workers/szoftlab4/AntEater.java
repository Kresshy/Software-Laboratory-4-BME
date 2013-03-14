package miracle.workers.szoftlab4;

public class AntEater extends Creature {
	// Members
    private boolean visible; // Jelen van-e
    private int hunger;
    private int wait;

    // Constructor
    public AntEater() {}

    // Protected methods
    protected void routeAndMove() {}

    // Public interface
    public boolean isVisible() {
		return visible;}
    public void handleTick() {}
}

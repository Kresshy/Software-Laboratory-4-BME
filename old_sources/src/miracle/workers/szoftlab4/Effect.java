package miracle.workers.szoftlab4;

public abstract class Effect {
	// Members
    protected int timeout;
    protected boolean attractive;

    // Abstract methods
    public abstract void interact(Creature creature); // Nem tudom szükség van-e rá

    // Public interface
    public void isDebris() {}
    public void handleTick() {}
}

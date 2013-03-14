package miracle.workers.szoftlab4;

public class Obstacle extends BaseObject {
	// Members
    protected boolean solid; // Tömörség/áthatolhatatlanság

    // Constructor
    public Obstacle() {}

    // Public interface
    public boolean isSolid() {
		return solid;
	}
    public boolean isDebris() { // Eltávolítandó-e az akadály !!!!!!!!!!!!!!!!!!!!!!!!
		return solid;
	}
    public void handleTick() {}
    public void interact(Creature creature) {} // Interakció, pl mérgezéskor és hangyalesõ táplálkozásakor
}

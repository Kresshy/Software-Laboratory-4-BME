package miracle.workers.szoftlab4;

public class Obstacle extends BaseObject {
	// Members
    protected boolean solid; // T�m�rs�g/�thatolhatatlans�g

    // Constructor
    public Obstacle() {}

    // Public interface
    public boolean isSolid() {
		return solid;
	}
    public boolean isDebris() { // Elt�vol�tand�-e az akad�ly !!!!!!!!!!!!!!!!!!!!!!!!
		return solid;
	}
    public void handleTick() {}
    public void interact(Creature creature) {} // Interakci�, pl m�rgez�skor �s hangyales� t�pl�lkoz�sakor
}

package hu.miracle.workers;

public class Obstacle extends BaseObject {

	private static final String className = "Obstacle";

	// Members
	protected boolean solid; // T�m�rs�g/�thatolhatatlans�g

	// Constructor
	public Obstacle() {
	}

	// Public interface
	public boolean isSolid() {
		System.out.println(className + " isSolid");
		return solid;
	}

	public boolean isDebris() { 							// Elt�vol�tand�-e az akad�ly
		System.out.println(className + " isDebris"); 		// !!!!!!!!!!!!!!!!!!!!!!!!
		return solid;
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	// Interakci�, pl m�rgez�skor �s hangyales� t�pl�lkoz�sakor
	public void interact(Creature creature) {
		System.out.println(className + " interact");
	} 
}

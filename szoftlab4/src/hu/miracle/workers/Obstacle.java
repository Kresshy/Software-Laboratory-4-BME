package hu.miracle.workers;

public class Obstacle extends BaseObject {

	private static final String className = "Obstacle";

	// Members
	protected boolean solid; // Tömörség/áthatolhatatlanság

	// Constructor
	public Obstacle() {
	}

	// Public interface
	public boolean isSolid() {
		System.out.println(className + " isSolid");
		return solid;
	}

	public boolean isDebris() { 							// Eltávolítandó-e az akadály
		System.out.println(className + " isDebris"); 		// !!!!!!!!!!!!!!!!!!!!!!!!
		return solid;
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	// Interakció, pl mérgezéskor és hangyalesõ táplálkozásakor
	public void interact(Creature creature) {
		System.out.println(className + " interact");
	} 
}

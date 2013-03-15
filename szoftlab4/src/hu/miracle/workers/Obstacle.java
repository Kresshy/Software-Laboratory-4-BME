package hu.miracle.workers;

public class Obstacle extends BaseObject {

	// Members
	protected boolean solid; // Tömörség/áthatolhatatlanság

	// Constructor
	public Obstacle() {
	}

	// Public interface
	public boolean isSolid() {
		System.out.println(getClass().getCanonicalName() + ".isSolid()");
		return solid;
	}

	// Eltávolítandó-e az akadály
	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");
		return false;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// Interakció, pl mérgezéskor és hangyaleső táplálkozásakor
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}

}

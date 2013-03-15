package hu.miracle.workers;

public class Obstacle extends BaseObject {

	private static final String className = "Obstacle";

	// Members
	protected boolean solid; // Tomorseg athatolhatalansag

	// Constructor
	public Obstacle() {
	}

	// Public interface
	public boolean isSolid() {
		System.out.println(className + " isSolid");
		return solid;
	}

	// Eltavolitando-e az akadaly
	public boolean isDebris() { 							
		System.out.println(className + " isDebris"); 		
		return false;
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	// Interakcio pl mergezeskor vagy hangyaleso talalkozasakor
	public void interact(Creature creature) {
		System.out.println(className + " interact");
	} 
}

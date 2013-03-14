package hu.miracle.workers;

public class AntEater extends Creature {
	
	private static final String className = "AntEater";
	
	// Members
	private boolean visible; // Jelen van-e
	private int hunger;
	private int wait;

	// Constructor
	public AntEater() {
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(className + " routeAndMove");
	}

	// Public interface
	public boolean isVisible() {
		System.out.println(className + " isVisible");
		return visible;
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}
}

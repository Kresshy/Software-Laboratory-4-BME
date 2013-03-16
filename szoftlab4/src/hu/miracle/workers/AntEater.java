package hu.miracle.workers;

public class AntEater extends Creature {

	// Members
	private boolean visible; // Jelen van-e
	private int hunger;
	private int wait;

	// Constructor
	public AntEater() {
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");
	}

	// Public interface
	public boolean isVisible() {
		System.out.println(getClass().getCanonicalName() + ".isVisible()");
		return visible;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (visible) {
			routeAndMove();
		}

	}
}

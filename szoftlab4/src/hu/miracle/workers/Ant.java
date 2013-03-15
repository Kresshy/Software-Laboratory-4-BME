package hu.miracle.workers;

public class Ant extends Creature {

	// Members
	private Storage home;
	private Storage source;
	private boolean poisoned;
	private int health;
	private int cargo;

	// Constructor
	public Ant() {

	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(getClass().getCanonicalName() + ".setPoisoned()");
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	@Override
	public void terminate() {
		System.out.println(getClass().getCanonicalName() + ".terminate()");
	}

	public void setSource(Storage storage) {
		System.out.println(getClass().getCanonicalName() + ".setSource()");
	}

}

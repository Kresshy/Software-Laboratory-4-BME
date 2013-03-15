package hu.miracle.workers;

public class Ant extends Creature {

	private static final String className = "Ant";

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
		System.out.println(className + "routeAndMove");
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(className + "setPoisoned");
	}

	public void handleTick() {
		System.out.println(className + "handleTick");
	}

	@Override
	public void terminate() {
		System.out.println(className + "terminate");
	}

	public void setSource(Storage storage) {
		System.out.println(className + "setSource");
	}

}

package hu.miracle.workers;

public abstract class Effect {

	private static final String className = "Effect";

	// Members
	protected int timeout;
	protected boolean attractive;

	// Abstract methods
	// Nem tudom szukseg van-e ra
	public abstract void interact(Creature creature); 

	// Public interface
	public void isDebris() {
		System.out.println(className + " isDebris");
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}
}

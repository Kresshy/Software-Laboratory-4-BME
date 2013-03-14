package hu.miracle.workers;

public abstract class Effect {

	private static final String className = "Effect";

	// Members
	protected int timeout;
	protected boolean attractive;

	// Abstract methods
	public abstract void interact(Creature creature); // Nem tudom sz�ks�g van-e
														// r�

	// Public interface
	public void isDebris() {
		System.out.println(className + " isDebris");
	}

	public void handleTick() {
		System.out.println(className + " handleTick");
	}
}

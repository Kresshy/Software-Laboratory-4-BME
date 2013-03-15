package hu.miracle.workers;

public abstract class Effect {

	// Members
	protected int timeout;
	protected boolean attractive;

	// Abstract methods
	// Nem tudom szükség van-e rá
	public abstract void interact(Creature creature);

	// Public interface
	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");
		return attractive;
	}

	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");
		return false;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}
}

package hu.miracle.workers;

public abstract class Effect {

	// Members
	protected int timeout;
	protected boolean attractive;
	
	public Effect(int timeout, boolean attractive) {
		this.timeout = timeout;
		this.attractive = attractive;
	}

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
		
		if (timeout > 0) {
			return false;
		} else {
			return true;
		}
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
		
		if (timeout > 0){
			timeout--;
		}
	}

}

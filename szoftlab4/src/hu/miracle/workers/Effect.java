package hu.miracle.workers;

public abstract class Effect {

	protected boolean attractive;
	protected int timeout;

	public Effect(int timeout, boolean attractive) {
		this.timeout = timeout;
		this.attractive = attractive;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}
	}

	public abstract void interact(Creature creature);

	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");

		// Vonzalom visszaadása
		return attractive;
	}

	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

}

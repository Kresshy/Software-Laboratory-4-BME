package hu.miracleworkers.model;

public abstract class Effect {

	protected boolean	attractive;
	protected int		timeout;

	public Effect(int timeout, boolean attractive) {
		this.timeout = timeout;
		this.attractive = attractive;
	}

	public void handleTick() {

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

	}

	public abstract void interact(Creature creature);

	public boolean isAttractive() {

		// Vonzalom visszaadása
		return attractive;
	}

	public boolean isDebris() {

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

}

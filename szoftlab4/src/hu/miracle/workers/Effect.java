package hu.miracle.workers;

public abstract class Effect {

	protected boolean attractive;
	protected int timeout;

	public Effect(int timeout, boolean attractive) {
		this.timeout = timeout;
		this.attractive = attractive;
	}

	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

		CallLogger.getLogger().exiting();
	}

	public abstract void interact(Creature creature);

	public boolean isAttractive() {
		CallLogger.getLogger().entering(this, "isAttractive");

		CallLogger.getLogger().exiting();

		// Vonzalom visszaadása
		return attractive;
	}

	public boolean isDebris() {
		CallLogger.getLogger().entering(this, "isDebris");

		CallLogger.getLogger().exiting();

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

}

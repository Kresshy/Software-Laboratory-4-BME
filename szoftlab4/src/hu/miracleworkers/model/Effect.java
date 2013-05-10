/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Effekt osztály.
 */
public abstract class Effect {

	/** Vonzás. */
	protected boolean	attractive;

	/** Elillanásig hátralévő idő. */
	protected int		timeout;

	/**
	 * Példányosít egy új effektet.
	 * 
	 * @param timeout az effekt elillanási ideje
	 * @param attractive az effekt vonzó-e a hangyák számára
	 */
	public Effect(int timeout, boolean attractive) {
		this.timeout = timeout;
		this.attractive = attractive;
	}

	/**
	 * Óraütés kezelése.
	 */
	public void handleTick() {

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

	}

	/**
	 * Kölcsönhatás.
	 * 
	 * @param creature a kölcsönhatásba lépő élőlény
	 */
	public abstract void interact(Creature creature);

	/**
	 * Ellenőrzi, hogy az effekt vonzó-e a hangyák számára.
	 * 
	 * @return true, ha az effekt vonzó a hangyák számára
	 */
	public boolean isAttractive() {

		// Vonzalom visszaadása
		return attractive;
	}

	/**
	 * Ellenőrzi, hogy az effekt eltakarítható-e.
	 * 
	 * @return true, ha az effekt eltakarítható
	 */
	public boolean isDebris() {

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

}

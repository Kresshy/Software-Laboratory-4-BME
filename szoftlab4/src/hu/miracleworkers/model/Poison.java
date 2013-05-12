/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.view.GPoison;
import hu.miracleworkers.view.GraphicsBase;

/**
 * Méreg osztály.
 */
public class Poison extends Obstacle {

	/** Elillanásig hátralévő idő. */
	private int	timeout;

	/**
	 * Példányosít egy új mérget.
	 * 
	 * @param position a méreg pozíciója
	 * @param scene a pálya amihez a méreg tartozik
	 */
	public Poison(Point position, Scene scene) {
		super(position, scene, 25, false, false);
		this.timeout = 500;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#getGraphicsWrapper()
	 */
	@Override
	public GraphicsBase getGraphicsWrapper() {
		return new GPoison(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#handleTick()
	 */
	@Override
	public void handleTick() {

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#interact(hu.miracleworkers.model.Creature )
	 */
	@Override
	public void interact(Creature creature) {

		// FIXME
		// Mérgezés beállítása
		((Ant) creature).setPoisoned(true);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#isDebris()
	 */
	@Override
	public boolean isDebris() {

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#toString()
	 */
	@Override
	public String toString() {
		return String.format("Poison %%d < position = %s, radius = %d, timeout = %d >", position,
				radius, timeout);
	}

}

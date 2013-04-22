package hu.miracle.workers;

import java.awt.Color;

public class Poison extends Obstacle {

	private int timeout;

	public Poison(Scene scene, Point position) {
		super(scene, position, Color.GREEN, 5, false, false);
		this.timeout = 5;
	}

	@Override
	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

		CallLogger.getLogger().exiting();
	}

	@Override
	public void interact(Creature creature) {
		CallLogger.getLogger().entering(this, "interact");

		// FIXME
		// Mérgezés beállítása
		((Ant) creature).setPoisoned(true);

		CallLogger.getLogger().exiting();
	}

	@Override
	public boolean isDebris() {
		CallLogger.getLogger().entering(this, "isDebris");

		CallLogger.getLogger().exiting();

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

	public String toString() {
		return String.format("Poison %%d < position = %s, radius = %d, timeout = %d >", position,
				radius, timeout);
	}

}

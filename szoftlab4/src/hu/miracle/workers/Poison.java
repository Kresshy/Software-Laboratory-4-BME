package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class Poison extends Obstacle {

	private int timeout;

	public Poison(Point position) {
		super(position, Color.GREEN, 5, false, false);
		this.timeout = 10;
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

}

package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class Poison extends Obstacle {

	private int timeout;

	public Poison(Point position) {
		super(position, Color.GREEN, 5, false);
		this.timeout = 10;
	}

	@Override
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}
	}

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");

		// FIXME
		// Mérgezés beállítása
		((Ant) creature).setPoisoned(true);
	}

	@Override
	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

}

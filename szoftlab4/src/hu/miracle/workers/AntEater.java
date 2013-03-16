package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class AntEater extends Creature {

	private boolean visible;
	private int hunger;
	private int wait;

	public AntEater(Point position, Scene scene) {
		super(position, Color.DARK_GRAY, 2, scene); // TODO: Grafikus jellemzők meghatározása
		this.wait = 20; // TODO: Kezdőérték meghatározása
		this.hunger = 10; // TODO: Kezdőérték meghatározása
	}

	@Override
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		// Ha a sün előtérben van
		if (visible) {
			// Ha a sün éhes
			if (hunger > 0) {
				List<Ant> ants = scene.getAnts();
				// Minden hangyára
				for (Ant ant : ants) {
					// Ha a sün hatókörében van
					if (pointInRange(ant.getPosition())) {
						// Hangya elpusztítása
						ant.terminate();
						// Éhség csökkentése
						hunger -= 1;
						// Hogy egyesével egye a hangyákat
						break;
					}
				}
			}

			// Mozgás
			routeAndMove();
		} else {
			// Ha várakozik
			if (wait > 0) {
				// Várakozási idő csökkentése
				wait--;
			} else {
				// Belépési pont és irány meghatározása
				// TODO: Algoritmus kidolgozása
				// Megjelenés
				visible = true;
			}
		}
	}

	public boolean isVisible() {
		System.out.println(getClass().getCanonicalName() + ".isVisible()");

		// Láthatóság visszaadása
		return visible;
	}

	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");

		// TODO: Algoritmus kidolgozása
	}
}

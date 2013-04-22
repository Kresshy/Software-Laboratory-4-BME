package hu.miracle.workers;

import java.awt.Color;
import java.util.List;

public class AntEater extends Creature {

	private boolean visible;
	private int hunger;
	private int wait;
	private int timeout;

	public AntEater(Point position, Scene scene, int wait, int hunger) {
		super(position, Color.DARK_GRAY, 2, scene); // TODO: Grafikus jellemzők meghatározása
		this.wait = wait;
		this.hunger = hunger;
		this.visible = false;
		this.timeout = wait;
	}

	@Override
	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

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
			} else {
				visible = false;
				timeout = wait;
			}

			// Mozgás
			routeAndMove();
		} else {
			// Ha várakozik
			if (timeout > 0) {
				// Várakozási idő csökkentése
				timeout--;
			} else {
				// Belépési pont és irány meghatározása
				// TODO: Algoritmus kidolgozása
				// Megjelenés
				visible = true;
			}
		}

		CallLogger.getLogger().exiting();
	}

	public boolean isVisible() {
		CallLogger.getLogger().entering(this, "isVisible");

		CallLogger.getLogger().exiting();

		// Láthatóság visszaadása
		return visible;
	}

	// TODO ezt át kell gondolni, meg behúzni a régi verziót
	protected void routeAndMove() {
		CallLogger.getLogger().entering(this, "routeAndMove");

		List<Ant> ants = scene.getAnts();

		List<Obstacle> obstacles = scene.getObstacles();

		// TODO: ellenorizni ezt nem vagom hogy kene
		for (Obstacle obstacle : obstacles) {
			if (pointInRange(obstacle.getPosition())) {
				if (obstacle.movable) {
					obstacle.setPosition(new Point(obstacle.getPosition().getX() + 1, obstacle
							.getPosition().getY()));
				}
			}
		}

		setPosition(new Point(getPosition().getX() + 1, getPosition().getY()));
		// TODO: Algoritmus kidolgozása

		CallLogger.getLogger().exiting();
	}

	public String toString() {
		return String.format(
				"AntEater %%d < position = %s, hunger = %d, timeout = %d, visible = %s >",
				position, hunger, timeout, String.valueOf(visible));
	}
}

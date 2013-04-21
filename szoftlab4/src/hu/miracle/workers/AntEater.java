package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;
import java.util.List;

public class AntEater extends Creature {

	private boolean visible;
	private int hunger;
	private int wait;

	public AntEater(Point position, Scene scene) {
		super(position, Color.DARK_GRAY, 2, scene); // TODO: Grafikus jellemzők
													// meghatározása
		this.wait = 20; // TODO: Kezdőérték meghatározása
		this.hunger = 10; // TODO: Kezdőérték meghatározása
		this.visible = true;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
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

		CallLogger.getLogger().exiting();
	}

	public boolean isVisible() {
		CallLogger.getLogger().entering(this, "isVisible");

		CallLogger.getLogger().exiting();

		// Láthatóság visszaadása
		return visible;
	}

	protected void routeAndMove() {
		CallLogger.getLogger().entering(this, "routeAndMove");

		List<Ant> ants = scene.getAnts();

		for (Ant ant : ants) {
			if (pointInRange(ant.getPosition())) {
				ant.terminate();
			}
		}

		List<Obstacle> obstacles = scene.getObstacles();

		// TODO: ellenorizni ezt nem vagom hogy kene
		for (Obstacle obstacle : obstacles) {
			if (pointInRange(obstacle.getPosition())) {
				if (obstacle.movable) {
					obstacle.setPosition(new Point(getPosition().x + 1, getPosition().y));
				}
			}
		}

		setPosition(new Point(getPosition().x + 1, getPosition().y));
		// TODO: Algoritmus kidolgozása

		CallLogger.getLogger().exiting();
	}
}

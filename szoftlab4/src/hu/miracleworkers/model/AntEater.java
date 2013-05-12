/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.model.Point.Direction;

import java.util.List;

/**
 * Hangyászsün osztály.
 */
public class AntEater extends Creature {

	/** Láthatóság. */
	private boolean	visible;

	/** Éhség. */
	private int		hunger;

	/** Várakozási idő. */
	private int		wait;

	/** Megjelenésíg hátralévő idő. */
	private int		timeout;

	/**
	 * Példányosít egy új hangyászsünt.
	 * 
	 * @param position a hangyászsün pozíciója
	 * @param scene a pálya amihez a hangyászsün tartozik
	 * @param wait a hangyászsün várakozási ideje
	 * @param hunger a hangyászsün éhségének mértéke
	 */
	public AntEater(Point position, Scene scene, int wait, int hunger) {
		super(position, scene, 25);
		this.wait = wait;
		this.hunger = hunger;
		this.visible = false;
		this.timeout = wait;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.SceneObject#handleTick()
	 */
	@Override
	public void handleTick() {

		// Ha a sün előtérben van
		if (visible) {
			// Ha a sün éhes
			if (hunger > 0) {
				List<Ant> ants = scene.getAnts();
				// Minden hangyára
				for (Ant ant : ants) {
					try {
						// Ha a sün hatókörében van
						if (pointInRange(ant.getPosition())) {
							// Hangya elpusztítása
							ant.terminate();
							// Éhség csökkentése
							hunger -= 1;
							// Hogy egyesével egye a hangyákat
							break;
						}
					} catch (NullPointerException e) {
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

	}

	/**
	 * Ellenőrzi, hogy a hangyászsün látható-e.
	 * 
	 * @return true, ha a hangyászsün látható
	 */
	public boolean isVisible() {
		// Láthatóság visszaadása
		return visible;
	}

	/**
	 * Útvonalkeresés és mozgás.
	 */
	protected void routeAndMove() {

		Direction new_direction = Direction.RIGHT;
		Point new_position = getPosition().step(new_direction, 1);

		List<Obstacle> obstacles = scene.getObstacles();
		for (Obstacle obstacle : obstacles) {
			if (obstacle.pointInRange(new_position)) {
				if (obstacle.isMovable(new_direction, 2)) {
					obstacle.moveTo(new_direction);
				}
			}
		}

		setPosition(new_position);
		// TODO: Algoritmus kidolgozása

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"AntEater %%d < position = %s, hunger = %d, timeout = %d, visible = %s >",
				position, hunger, timeout, String.valueOf(visible));
	}
}

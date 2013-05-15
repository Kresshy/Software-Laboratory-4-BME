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
	private boolean		visible;

	/** Éhség. */
	private int			hunger;

	/** Megevett hangyák száma. */
	private int			eaten;

	/** Várakozási idő. */
	private int			wait;

	/** Megjelenésíg hátralévő idő. */
	private int			timeout;

	/** Mozgási irány. */
	private Direction	direction;

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
		this.direction = Direction.values()[(int) (Math.random() * (Direction.values().length))];
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
			if (hunger > eaten) {
				List<Ant> ants = scene.getAnts();
				// Minden hangyára
				for (Ant ant : ants) {
					// Ha a sün hatókörében van
					if (pointInRange(ant.getPosition())) {
						// Hangya elpusztítása
						ant.terminate();
						// Megevett hangyák növelése
						eaten++;
						// Hogy egyesével egye a hangyákat
						break;
					}
				}
			} else {
				visible = false;
				timeout = wait;
				eaten = 0;
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
				direction = Direction.values()[(int) (Math.random() * (Direction.values().length))];
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

		Direction new_direction = direction;
		Point new_position = getPosition().step(direction, 1);

		// Visszafordítás a pálya szélén
		int x = new_position.getX(), y = new_position.getY();
		if (x < 0 || y < 0 || x > getScene().getDimension().width
				|| y > getScene().getDimension().height) {
			int rand = -1 + (int) (Math.random() * 4);
			direction = Point.rotateDirection(direction, 3 + rand);
			new_position = getPosition().step(direction, 1);
		}

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

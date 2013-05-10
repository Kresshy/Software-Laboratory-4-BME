/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.model.Point.Direction;

import java.util.List;

/**
 * Akadály osztály.
 */
public class Obstacle extends BaseObject {

	/** Tömörség. */
	protected boolean	solid;

	/** Mozdíthatóság. */
	protected boolean	movable;

	/** Pálya. */
	protected Scene		scene;

	/**
	 * Példányosít egy új akadályt.
	 * 
	 * @param position az akadály pozíciója
	 * @param scene a pálya amihez az akadály tartozik
	 * @param radius az akadály hatóköre
	 * @param solid az akadály tömörsége
	 * @param movable az akadály mozdíthatósága
	 */
	public Obstacle(Point position, Scene scene, int radius, boolean solid, boolean movable) {
		super(position, radius);
		this.solid = solid;
		this.movable = movable;
		this.scene = scene;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.BaseObject#handleTick()
	 */
	@Override
	public void handleTick() {

		// Dummy default implementáció

	}

	/**
	 * Kölcsönhatás.
	 * 
	 * @param creature a kölcsönhatásba lépő élőlény
	 */
	public void interact(Creature creature) {

		// Dummy default implementáció

	}

	/**
	 * Ellenőrzi, hogy az akadály eltakarítható-e.
	 * 
	 * @return true, ha az akadály eltakarítható
	 */
	public boolean isDebris() {

		// Eltávolíthatóság visszaadása
		return false;
	}

	/**
	 * Ellenőrzi, hogy az akadály mozdítható-e.
	 * 
	 * @param direction a mozdítás iránya
	 * @param depth az akadály mozdítása hány további akadályra hat
	 * @return true, ha az akadály mozdítható
	 */
	public boolean isMovable(Direction direction, int depth) {

		if (depth > 0) {
			// Következő munkapont meghatározása
			Point op_point = getPosition();
			// Amíg ki nem érünk az aktuális akadályból
			while (pointInRange(op_point))
				// Lépés a tolás irányába
				op_point = op_point.step(direction, 1);

			// Útban lévő akadályok ellenőrzése
			boolean all_movable = true;
			List<Obstacle> obstacles = scene.getObstacles();
			// Minden akadályra
			for (Obstacle obstacle : obstacles) {
				if (obstacle != this && obstacle.movable && obstacle.pointInRange(op_point)) {
					all_movable = all_movable
							&& obstacle.isMovable(op_point.direction(obstacle.getPosition()),
									depth - 1);
				}
			}

			return all_movable;
		} else
			return false;
	}

	/**
	 * Ellenőrzi, hogy az akadály tömör-e.
	 * 
	 * @return true, ha az akadály tömör
	 */
	public boolean isSolid() {

		// Tömörség visszaadása
		return solid;
	}

	/**
	 * Mozgatás.
	 * 
	 * @param direction a mozgatás iránya
	 */
	public void moveTo(Direction direction) {
		if (movable) {
			// Következő munkapont meghatározása
			Point op_point = getPosition();
			// Amíg ki nem érünk az aktuális akadályból
			while (pointInRange(op_point))
				// Lépés a tolás irányába
				op_point = op_point.step(direction, 1);

			List<Obstacle> obstacles = scene.getObstacles();
			for (Obstacle obstacle : obstacles) {
				if (obstacle != this && obstacle.pointInRange(op_point)) {
					obstacle.moveTo(op_point.direction(obstacle.getPosition()));
				}
			}

			setPosition(getPosition().step(direction, 1));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"Obstacle %%d < position = %s, radius = %d, solid = %s, movable = %s >", position,
				radius, String.valueOf(solid), String.valueOf(movable));

	}
}

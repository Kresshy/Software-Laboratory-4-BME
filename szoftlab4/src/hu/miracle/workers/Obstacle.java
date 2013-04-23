﻿package hu.miracle.workers;

import hu.miracle.workers.Point.Direction;

import java.awt.Color;
import java.util.List;

public class Obstacle extends BaseObject {

	protected boolean solid;
	protected boolean movable;
	protected Scene scene;

	public Obstacle(Scene scene, Point position, Color color, int radius, boolean solid,
			boolean movable) {
		super(position, color, radius);
		this.solid = solid;
		this.movable = movable;
		this.scene = scene;
	}

	public boolean isSolid() {
		CallLogger.getLogger().entering(this, "isSolid");

		CallLogger.getLogger().exiting();

		// Tömörség visszaadása
		return solid;
	}

	public boolean isDebris() {
		CallLogger.getLogger().entering(this, "isDebris");

		CallLogger.getLogger().exiting();

		// Eltávolíthatóság visszaadása
		return false;
	}

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

	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

	public void interact(Creature creature) {
		CallLogger.getLogger().entering(this, "interact");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

	public String toString() {
		return String.format(
				"Obstacle %%d < position = %s, radius = %d, solid = %s, movable = %s >", position,
				radius, String.valueOf(solid), String.valueOf(movable));

	}
}

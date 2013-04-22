package hu.miracle.workers;

import hu.miracle.workers.Point.Direction;

import java.awt.Color;
import java.util.List;

public class Obstacle extends BaseObject {

	protected boolean solid;
	protected boolean movable;
	protected Scene scene;

	public Obstacle(Scene scene, Point position, Color color, int radius, boolean solid, boolean movable) {
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

	public boolean isMovable(Direction dir, int deep) {

		if (deep < 0)
			return false;

		deep--;

		List<Obstacle> obstacles = scene.getObstacles();

		for (Obstacle obstacle : obstacles) {
			if (obstacle != this && obstacle.pointInRange(getPosition())) {
				if (getPosition().direction(obstacle.getPosition()) == Direction.RIGHT
						|| getPosition().direction(obstacle.getPosition()) == Direction.TOP_RIGHT
						|| getPosition().direction(obstacle.getPosition()) == Direction.BOTTOM_RIGHT && getPosition() != obstacle.getPosition()) {
					if (obstacle.isMovable(Direction.RIGHT, deep)) {
						return movable;
					}
				}
			}
		}

		return movable;
	}

	public void moveToDirection(Direction dir) {
		setPosition(new Point(getPosition().getX() + 1, getPosition().getY()));
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
		return String.format("Obstacle %%d < position = %s, radius = %d, solid = %s, movable = %s >", position, radius, String.valueOf(solid),
				String.valueOf(movable));

	}
}

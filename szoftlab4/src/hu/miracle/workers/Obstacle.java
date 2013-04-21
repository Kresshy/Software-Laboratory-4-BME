package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class Obstacle extends BaseObject {

	protected boolean solid;
	protected boolean movable;

	public Obstacle(Point position, Color color, int radius, boolean solid, boolean movable) {
		super(position, color, radius);
		this.solid = solid;
		this.movable = movable;
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

	public boolean isMovable() {
		return movable;
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
}

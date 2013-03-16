package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class Obstacle extends BaseObject {

	protected boolean solid;

	public Obstacle(Point position, Color color, int radius, boolean solid) {
		super(position, color, radius);
		this.solid = solid;
	}

	public boolean isSolid() {
		System.out.println(getClass().getCanonicalName() + ".isSolid()");

		// Tömörség visszaadása
		return solid;
	}

	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");

		// Eltávolíthatóság visszaadása
		return false;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}

}

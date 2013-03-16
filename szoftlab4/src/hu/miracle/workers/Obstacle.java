package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

public class Obstacle extends BaseObject {

	// Members
	protected boolean solid; // Tomorseg/athatolhatatlansag

	// Constructor
	public Obstacle(Point position, Color color, int radius, boolean solid) {
		super(position, color, radius);
		this.solid = solid;
	}

	// Public interface
	public boolean isSolid() {
		System.out.println(getClass().getCanonicalName() + ".isSolid()");
		return solid;
	}

	// Eltavolitando-e az akadaly
	public boolean isDebris() {
		System.out.println(getClass().getCanonicalName() + ".isDebris()");
		return false;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// Interakcio, pl mergezeskor es hangyaleso taplalkozasakor
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}

}

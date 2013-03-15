package hu.miracle.workers;

import java.util.List;

public class AntEater extends Creature {

	// Members
	private boolean visible; // Jelen van-e
	private int hunger;
	private int wait;

	// Constructor
	public AntEater() {
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");
	}

	// Public interface
	public boolean isVisible() {
		System.out.println(getClass().getCanonicalName() + ".isVisible()");
		return visible;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (visible) {
			// Eloterben
			List<Ant> ants = scene.getAnts();
			// ...
			// Ha van ennivalo hangya es ehes
			if (hunger > 0) {
				for (Ant ant : ants) {
					if (pointInRange(ant.getPosition())) {
						ant.terminate();
						hunger -= 1;
					}
				}
			}

		} else {
			// Hatterben
			if (wait > 0) {
				wait -= 1;
			} else {
				// Belepesi pont meghatarozasa
				// Megjelenes
			}

		}
	}
}

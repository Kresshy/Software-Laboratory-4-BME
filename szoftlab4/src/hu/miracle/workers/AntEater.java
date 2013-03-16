package hu.miracle.workers;

import java.awt.Point;
import java.util.List;

public class AntEater extends Creature {

	// Members
	private boolean visible; // Jelen van-e
	private int hunger;
	private int wait;

	// Constructor
	public AntEater(Scene scene, int wait, int hunger) {
		super(scene);
		this.wait = wait;
		this.hunger = hunger;
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");

		for (Ant ant : scene.getAnts()) {
			if (pointInRange(ant.getPosition()) == true) {
				if (hunger > 0) {
					ant.terminate();
					hunger--;
				}
			}
		}
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
						break; // Hogy ne tomegesen hanem egyesevel egye a
								// hangyakat
					}
				}
			}
			routeAndMove();

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

	@Override
	public boolean pointInRange(Point point) {

		if (Point.distance(this.position.x, this.position.y, point.x, point.y) < this.radius) {
			return true;
		} else {
			return false;
		}

	}
}

package hu.miracle.workers;

import java.awt.Point;
import java.util.List;

public class Ant extends Creature {

	// Members
	private Storage home;
	private Storage source;
	private boolean poisoned;
	private int health;
	private int cargo;

	// Constructor
	public Ant() {

	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");

		// ...
		scene.getStorages();
		// ...
		scene.discoverEffects(this);
		// ...
		List<Obstacle> obstacles = scene.discoverObstacles(this);
		for (Obstacle obstacle : obstacles) {
			obstacle.interact(this);
		}
		// ...
		Point newpos = new Point();
		Pheromone pheromone = new Pheromone();
		setPosition(newpos);
		scene.placeEffect(newpos, pheromone);
		// ...
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(getClass().getCanonicalName() + ".setPoisoned()");
	}

	@Override
	public void terminate() {
		System.out.println(getClass().getCanonicalName() + ".terminate()");

		if (source != null) {
			source.putItems(cargo);
		}
		// ...
		home.putItems(1);
		// ...
		// Eltavolitas a scene-bol
	}

	public void setSource(Storage storage) {
		System.out.println(getClass().getCanonicalName() + ".setSource()");
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (health <= 0) {
			terminate();
		}
		if (poisoned) {
			health -= 1;
		}
		// ...
		routeAndMove();
		// ...
	}
}

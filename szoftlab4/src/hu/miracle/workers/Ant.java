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
	// FIXME
	public Ant(Storage home, Storage source, boolean poisoned, int health, Scene scene) {
		super(scene);
		this.home = home;
		this.source = source;
		this.poisoned = poisoned;
		this.health = health;
		this.cargo = 0;
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");

		// TODO: Átnézni, befejezni
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
		// FIXME: Pheromone konstruktor
		Pheromone pheromone = null; // = new Pheromone();
		setPosition(newpos);
		scene.placeEffect(newpos, pheromone);
		// ...
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(getClass().getCanonicalName() + ".setPoisoned()");

		this.poisoned = poisoned;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (health <= 0) {
			terminate();
		}
		if (poisoned) {
			health -= 1;
		}

		// FIXME: Kajafelvétel/-letétel
		for (Storage storage : scene.getStorages()) {

			// Ezt felejtsd el.
			if (storage instanceof FoodStorage) {

				if (pointInRange(storage.getPosition())) {
					cargo = storage.getItems();
					source = storage;
				}
			}
		}

		routeAndMove();
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
		// TODO: Eltávolítás a scene-ből
		// health = 0;
	}

	public void setSource(Storage storage) {
		System.out.println(getClass().getCanonicalName() + ".setSource()");
		// TODO
	}

	// FIXME: Eltávolítás
	public boolean isDead() {
		if (health > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean pointInRange(Point point) {
		// FIXME: Egyszerűsítés
		if (Point.distance(this.position.x, this.position.y, point.x, point.y) < this.radius) {
			return true;
		} else {
			return false;
		}
	}

}

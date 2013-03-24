package hu.miracle.workers;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Scene {

	private Dimension dimension;
	private List<Ant> ants;
	private List<Storage> storages;
	private List<Obstacle> obstacles;
	private List<Creature> creatures;
	private Map<Point, Effect> effects; // Ez a tároló továbbra sem végleges

	public Scene() {
		this.ants = new ArrayList<Ant>();
		this.storages = new ArrayList<Storage>();
		this.obstacles = new ArrayList<Obstacle>();
		this.creatures = new ArrayList<Creature>();
		this.effects = new HashMap<Point, Effect>();
	}

	public void buildScene(String settings) {
		CallLogger.getLogger().entering(this, "buildScene");

		// TODO: Pálya építése

		CallLogger.getLogger().exiting();
	}

	protected void clearDebris() {
		CallLogger.getLogger().entering(this, "clearDebris");

		// Minden akadályra
		Iterator<Obstacle> iobstacles = obstacles.iterator();
		while (iobstacles.hasNext()) {
			Obstacle obstacle = iobstacles.next();
			// Ha szemét
			if (obstacle.isDebris()) {
				// Eltávolítás
				iobstacles.remove();
			}
		}

		// Minden effektre
		Iterator<Entry<Point, Effect>> ieffects = effects.entrySet().iterator();
		while (ieffects.hasNext()) {
			Entry<Point, Effect> entry = ieffects.next();
			// Ha szemét
			if (entry.getValue().isDebris()) {
				// Eltávolítás
				ieffects.remove();
			}
		}

		CallLogger.getLogger().exiting();
	}

	// Egy pont korzeteben eltunteti az effekteket, szagtalanito sprayhez
	// szukseges
	public void clearEffects(Point point) {
		CallLogger.getLogger().entering(this, "clearEffect");

		// Minden effektre
		Iterator<Entry<Point, Effect>> ieffects = effects.entrySet().iterator();
		while (ieffects.hasNext()) {
			Entry<Point, Effect> entry = ieffects.next();
			// Ha a pont környezetébe esik
			// TODO: Környezet méretének meghatározása
			if (point.distance(entry.getKey()) < 10) {
				// Eltávolítás
				ieffects.remove();
			}
		}

		CallLogger.getLogger().exiting();
	}

	public void delegateTick() {
		CallLogger.getLogger().entering(this, "delegateTick");

		// Tick-kezelések
		for (Ant ant : ants) {
			ant.handleTick();
		}
		for (Creature creature : creatures) {
			creature.handleTick();
		}
		for (Storage storage : storages) {
			storage.handleTick();
		}
		for (Obstacle obstacle : obstacles) {
			obstacle.handleTick();
		}
		for (Effect effect : effects.values()) {
			effect.handleTick();
		}
		// Szemét eltakarítása
		clearDebris();

		CallLogger.getLogger().exiting();
	}

	public Map<Point, Effect> discoverEffects(BaseObject object) {
		CallLogger.getLogger().entering(this, "discoverEffects");

		Map<Point, Effect> inrange = new HashMap<Point, Effect>();
		// Minden effektre
		for (Entry<Point, Effect> entry : effects.entrySet()) {
			// Ha az objektum hatókörében van
			if (object.pointInRange(entry.getKey())) {
				// Hozzáadás
				inrange.put(entry.getKey(), entry.getValue());
			}
		}

		CallLogger.getLogger().exiting();

		// Hatókörben lévő effektek visszaadása
		return inrange;
	}

	public List<Obstacle> discoverObstacles(BaseObject object) {
		CallLogger.getLogger().entering(this, "discoverObstacles");

		List<Obstacle> inrange = new ArrayList<Obstacle>();
		// Minden akadályra
		for (Obstacle obstacle : obstacles) {
			// Ha az objektum hatókörében van
			if (object.pointInRange(obstacle.getPosition())) {
				// Hozzáadás
				inrange.add(obstacle);
			}
		}

		CallLogger.getLogger().exiting();

		// Hatókörben lévő akadályok visszaadása
		return inrange;
	}

	public List<Ant> getAnts() {
		CallLogger.getLogger().entering(this, "getAnts");

		CallLogger.getLogger().exiting();

		// Hangyák visszaadása
		return ants;
	}

	public List<Creature> getCreatures() {
		CallLogger.getLogger().entering(this, "getCreatures");

		CallLogger.getLogger().exiting();

		// Élőlények visszaadása
		return creatures;
	}

	// Public interface
	public Dimension getDimension() {
		CallLogger.getLogger().entering(this, "getDimension");

		CallLogger.getLogger().exiting();

		// Méret visszaadása
		return dimension;
	}

	public List<Obstacle> getObstacles() {
		CallLogger.getLogger().entering(this, "getObstacles");

		CallLogger.getLogger().exiting();

		// Akadályok visszaadása
		return obstacles;
	}

	public List<Storage> getStorages() {
		CallLogger.getLogger().entering(this, "getStorages");

		CallLogger.getLogger().exiting();

		// Tárolók visszaadása
		return storages;
	}

	public void placeEffect(Point point, Effect effect) {
		CallLogger.getLogger().entering(this, "placeEffect");

		// Új effekt eltárolása
		effects.put(point, effect);

		CallLogger.getLogger().exiting();
	}

	public void placeObstacle(Obstacle obstacle) {
		CallLogger.getLogger().entering(this, "placeObstacle");

		// Új objektum eltárolása
		obstacles.add(obstacle);

		CallLogger.getLogger().exiting();
	}

}

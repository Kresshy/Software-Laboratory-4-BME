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
		System.out.println(getClass().getCanonicalName() + ".buildScene()");

		// TODO: Pálya építése
	}

	protected void clearDebris() {
		System.out.println(getClass().getCanonicalName() + ".clearDebris()");

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
	}

	// Egy pont korzeteben eltunteti az effekteket, szagtalanito sprayhez
	// szukseges
	public void clearEffects(Point point) {
		System.out.println(getClass().getCanonicalName() + ".clearEffect()");

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
	}

	public void delegateTick() {
		System.out.println(getClass().getCanonicalName() + ".delegateTick()");

		try {
			// Tick-kezelések
			for (Ant ant : ants) {
				ant.handleTick();
			}
			for (Storage storage : storages) {
				storage.handleTick();
			}
			for (Obstacle obstacle : obstacles) {
				obstacle.handleTick();
			}
			for (Creature creature : creatures) {
				creature.handleTick();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		// Szemét eltakarítása
		clearDebris();
	}

	public Map<Point, Effect> discoverEffects(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverEffects()");

		Map<Point, Effect> inrange = new HashMap<Point, Effect>();
		// Minden effektre
		for (Entry<Point, Effect> entry : effects.entrySet()) {
			// Ha az objektum hatókörében van
			if (object.pointInRange(entry.getKey())) {
				// Hozzáadás
				inrange.put(entry.getKey(), entry.getValue());
			}
		}
		// Hatókörben lévő effektek visszaadása
		return inrange;
	}

	public List<Obstacle> discoverObstacles(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverObstacles()");

		List<Obstacle> inrange = new ArrayList<Obstacle>();
		// Minden akadályra
		for (Obstacle obstacle : obstacles) {
			// Ha az objektum hatókörében van
			if (object.pointInRange(obstacle.getPosition())) {
				// Hozzáadás
				inrange.add(obstacle);
			}
		}
		// Hatókörben lévő akadályok visszaadása
		return inrange;
	}

	public List<Ant> getAnts() {
		System.out.println(getClass().getCanonicalName() + ".getAnts()");

		// Hangyák visszaadása
		return ants;
	}

	public List<Creature> getCreatures() {
		System.out.println(getClass().getCanonicalName() + ".getCreatures()");

		// Élőlények visszaadása
		return creatures;
	}

	// Public interface
	public Dimension getDimension() {
		System.out.println(getClass().getCanonicalName() + ".getDimension()");

		// Méret visszaadása
		return dimension;
	}

	public List<Obstacle> getObstacles() {
		System.out.println(getClass().getCanonicalName() + ".getObstacles()");

		// Akadályok visszaadása
		return obstacles;
	}

	public List<Storage> getStorages() {
		System.out.println(getClass().getCanonicalName() + ".getStorages()");

		// Tárolók visszaadása
		return storages;
	}

	public void placeEffect(Point point, Effect effect) {
		System.out.println(getClass().getCanonicalName() + ".placeEffect()");

		// Új effekt eltárolása
		effects.put(point, effect);
	}

	public void placeObstacle(Obstacle obstacle) {
		System.out.println(getClass().getCanonicalName() + ".placeObstacle()");

		// Új objektum eltárolása
		obstacles.add(obstacle);
	}

}

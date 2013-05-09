package hu.miracleworkers.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Scene {

	private Dimension			dimension;
	private List<Ant>			ants;
	private List<Storage>		storages;
	private List<Obstacle>		obstacles;
	private List<Creature>		creatures;
	private Map<Point, Effect>	effects;	// Ez a tároló továbbra sem végleges

	public Scene() {
		this.ants = new ArrayList<Ant>();
		this.storages = new ArrayList<Storage>();
		this.obstacles = new ArrayList<Obstacle>();
		this.creatures = new ArrayList<Creature>();
		this.effects = new HashMap<Point, Effect>();
	}

	protected void clearDebris() {

		// Minden akadályra
		Iterator<Obstacle> iobstacles = obstacles.iterator();
		while (iobstacles.hasNext()) {
			Obstacle obstacle = iobstacles.next();
			// Ha szemét
			if (obstacle.isDebris()) {
				// FIXME: Kimenet eltávolítása
				System.out.println(String.format("Poison %d evaporated.",
						getObstacles().indexOf(obstacle)));
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

		// Minden hangyára
		Iterator<Ant> iants = ants.iterator();
		while (iants.hasNext()) {
			Ant ant = iants.next();
			// Ha szemét
			if (ant == null) {
				// Eltávolítás
				iants.remove();
			}
		}

	}

	// Egy pont korzeteben eltunteti az effekteket, szagtalanito sprayhez
	// szukseges
	public void clearEffects(Point point) {

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

		// Tick-kezelések
		for (Storage storage : storages) {
			storage.handleTick();
		}
		for (Obstacle obstacle : obstacles) {
			obstacle.handleTick();
		}
		for (Effect effect : effects.values()) {
			effect.handleTick();
		}
		for (Ant ant : ants) {
			ant.handleTick();
		}
		for (Creature creature : creatures) {
			creature.handleTick();
		}
		// Szemét eltakarítása
		clearDebris();

	}

	public Map<Point, Effect> discoverEffects(BaseObject object) {

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

		List<Obstacle> inrange = new ArrayList<Obstacle>();
		// Minden akadályra
		for (Obstacle obstacle : obstacles) {
			// Ha az objektum hatókörében van
			if (obstacle.pointInRange(object.getPosition())) {
				// Hozzáadás
				inrange.add(obstacle);
			}
		}

		// Hatókörben lévő akadályok visszaadása
		return inrange;
	}

	public List<Ant> getAnts() {

		// Hangyák visszaadása
		return ants;
	}

	public List<Creature> getCreatures() {

		// Élőlények visszaadása
		return creatures;
	}

	// Public interface
	public Dimension getDimension() {

		// Méret visszaadása
		return dimension;
	}

	public List<Obstacle> getObstacles() {

		// Akadályok visszaadása
		return obstacles;
	}

	public List<Storage> getStorages() {

		// Tárolók visszaadása
		return storages;
	}

	public void placeEffect(Point point, Effect effect) {

		// Új effekt eltárolása
		effects.put(point, effect);

	}

	public void placeObstacle(Obstacle obstacle) {

		// Új objektum eltárolása
		obstacles.add(obstacle);

	}

}

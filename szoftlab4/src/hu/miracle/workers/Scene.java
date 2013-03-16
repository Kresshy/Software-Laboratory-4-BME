package hu.miracle.workers;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Scene {

	// Members
	private Dimension dimension;
	private List<Ant> ants;
	private List<Storage> storages;
	private List<Obstacle> obstacles;
	private List<Creature> creatures;
	private Map<Point, Effect> effects; // Ez a tarolo tovabbra sem vegleges,
										// csak implementaciokor derul ki, hogy
										// labonlottuk-e magunkat.

	// Constructor
	public Scene() {
		this.ants = new ArrayList<Ant>();
		this.storages = new ArrayList<Storage>();
		this.obstacles = new ArrayList<Obstacle>();
		this.creatures = new ArrayList<Creature>();
		this.effects = new HashMap<Point, Effect>();
	}

	// Protected methods
	// Eltavolitja a szemetet a palyarol (lejart akadalyok es effektek)
	protected void clearDebris() {
		System.out.println(getClass().getCanonicalName() + ".clearDebris()");

		for (Obstacle obstacle : obstacles) {
			if (obstacle.isDebris()) {
				// Eltavolitas
				// obstacles.remove(obstacle); // Az iteratoros eltavolitassal
				// gondok lehetnek
			}
		}

		for (Effect effect : effects.values()) {
			if (effect.isDebris()) {
				// Eltavolitas
			}
		}
	}

	// Public interface
	public Dimension getDimension() {
		System.out.println(getClass().getCanonicalName() + ".getDimension()");
		return dimension;
	}

	public List<Ant> getAnts() {
		System.out.println(getClass().getCanonicalName() + ".getAnts()");
		return ants;
	}

	public List<Storage> getStorages() {
		System.out.println(getClass().getCanonicalName() + ".getStorages()");
		return storages;
	}

	public List<Obstacle> getObstacles() {
		System.out.println(getClass().getCanonicalName() + ".getObstacles()");
		return obstacles;
	}

	public List<Creature> getCreatures() {
		System.out.println(getClass().getCanonicalName() + ".getCreatures()");
		return creatures;
	}

	// Egy objektum kornyeki effekteket adja vissza, a hangya
	// utvonaltervezesehez kell
	// Mi baj a BaseObject-tel Szabi?
	public Map<Point, Effect> discoverEffects(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverEffects()");
		return effects;
	}

	// Egy objektum kornyeki akadalyokat adja vissza, a hangya
	// utvonaltervezesehez es a mergezeshez kell
	public List<Obstacle> discoverObstacles(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverObstacles()");
		return obstacles;
	}

	// uj effektet tarol el, szagnyom letetelehez szukseges
	public void placeEffect(Point point, Effect effect) {
		System.out.println(getClass().getCanonicalName() + ".placeEffect()");
		effects.put(point, effect);
	}

	// Egy pont korzeteben eltunteti az effekteket, szagtalanito sprayhez
	// szukseges
	public void clearEffects(Point point) {
		System.out.println(getClass().getCanonicalName() + ".clearEffect()");

		Iterator it = effects.entrySet().iterator();

		while (it.hasNext()) {

			Map.Entry pairs = (Map.Entry) it.next();
			Effect effect = (Effect) pairs.getValue();
			Point keyPoint = (Point) pairs.getKey();

			double distance = Point.distance(keyPoint.x, keyPoint.y, point.x, point.y);

			// A Szageltávolítónak fix sugarat adtam, hogy tudjuk vizsgálni
			// beleesik-e ebbe a sugárba a pont vagy sem
			if (distance < 4) {
				it.remove();
			}

		}

	}

	// uj akadalyt tarol el, mereg sprayhez szukseges
	public void placeObstacle(Obstacle obstacle) {
		System.out.println(getClass().getCanonicalName() + ".placeObstacle()");
		obstacles.add(obstacle);
	}

	// Ez itt csak placeholder, fogalmam sincs hogyan taroljuk a palyakat es
	// milyen parameterekre lesz szukseg
	public void buildScene(String settings) {
		System.out.println(getClass().getCanonicalName() + ".buildScene()");
	}

	// ez a függvény kezeli a scene tickre történő tevékenységét is
	public void delegateTick() {
		System.out.println(getClass().getCanonicalName() + ".delegateTick()");

		clearDebris();

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

		clearDebris();
	}

}

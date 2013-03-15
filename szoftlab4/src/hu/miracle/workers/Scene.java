package hu.miracle.workers;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Scene {

	// Members
	private Dimension dimension;
	private List<Ant> ants;
	private List<Storage> storages;
	private List<Obstacle> obstacles;
	private List<Creature> creatures;
	private Map<Point, Effect> effects; // Ez a tároló továbbra sem végleges,
										// csak implementációkor derül ki, hogy
										// lábonlőttük-e magunkat.

	// Constructor
	public Scene() {
		this.ants = new ArrayList<Ant>();
		this.storages = new ArrayList<Storage>();
		this.obstacles = new ArrayList<Obstacle>();
		this.creatures = new ArrayList<Creature>();
	}

	// Protected methods
	// Eltávolítja a szemetet a pályáról (lejárt akadályok és effektek)
	protected void clearDebris() {
		System.out.println(getClass().getCanonicalName() + ".clearDebris()");
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

	// Egy objektum környéki effekteket adja vissza, a hangya
	// útvonaltervezéséhez kell
	public Map<Point, Effect> discoverEffects(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverEffects()");
		return effects;
	}

	// Egy objektum környéki akadályokat adja vissza, a hangya
	// útvonaltervezéséhez és a mérgezéshez kell
	public List<Obstacle> discoverObstacles(BaseObject object) {
		System.out.println(getClass().getCanonicalName() + ".discoverObstacles()");
		return obstacles;
	}

	// Új effektet tárol el, szagnyom letételéhez szükséges
	public void placeEffect(Point point, Effect effect) {
		System.out.println(getClass().getCanonicalName() + ".placeEffect()");
	}

	// Egy pont körzetében eltünteti az effekteket, szagtalanító sprayhez
	// szükséges
	public void clearEffects(Point point) {
		System.out.println(getClass().getCanonicalName() + ".clearEffect()");
	}

	// Új akadályt tárol el, méreg sprayhez szükséges
	public void placeObstacle(Obstacle obstacle) {
		System.out.println(getClass().getCanonicalName() + ".placeObstacle()");
	}

	// Ez itt csak placeholder, fogalmam sincs hogyan tároljuk a pályákat és
	// milyen paraméterekre lesz szükség
	public void buildScene(String settings) {
		System.out.println(getClass().getCanonicalName() + ".buildScene()");
	}

	public void delegateTick() {
		System.out.println(getClass().getCanonicalName() + ".delegateTick()");

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
	}

}

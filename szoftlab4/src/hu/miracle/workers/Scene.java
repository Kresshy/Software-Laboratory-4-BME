package hu.miracle.workers;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Map;

public class Scene {

	private static final String className = "Scene";

	// Members
	private Dimension dimension;
	private List<Ant> ants;
	private List<Storage> storages;
	private List<Obstacle> obstacles;
	private List<Creature> creatures;
	private Map<Point, Effect> effects; // Ez elvileg nem lista lesz, de még nem
										// tudom megmondani hogy mi

	// Protected methods
	// Eltávolítja a szemetet a pályáról (lejárt akadályok és effektek)
	protected void clearDebris() {
		System.out.println(className + " clearDebris");
	}

	// Public interface
	public Dimension getDimension() {
		System.out.println(className + " getDimension");
		return dimension;
	}

	public List<Ant> getAnts() {
		System.out.println(className + " getAnts");
		return ants;
	}

	public List<Storage> getStorages() {
		System.out.println(className + " getStorages");
		return storages;
	}

	public List<Obstacle> getObstacles() {
		System.out.println(className + " getObstacles");
		return obstacles;
	}

	public List<Creature> getCreatures() {
		System.out.println(className + "getCreatures");
		return creatures;
	}

	public Map<Point, Effect> discoverEffects(Point point) {
		System.out.println(className + " discoverEffects");
		return effects;
	}

	// Egy pont környéki akadályokat adja vissza, a hangya útvonaltervezéséhez
	// és a mérgezéshez kell
	public List<Obstacle> discoverObstacles(Point point) {
		System.out.println(className + " discoverObstacles");
		return obstacles;
	}

	// Új effektet tárol el, szagnyom letételéhez szükséges
	public void placeEffect(Point point, Effect effect) {
		System.out.println(className + " placeEffect");
	} 

	// Egy pont körzetében eltünteti az effekteket, szagtalanító sprayhez
	// szüksége
	public void clearEffects(Point point) {
		System.out.println(className + " clearEffect");
	}

	// Új akadályt tárol el, méreg sprayhez szükséges
	public void placeObstacle(Obstacle obstacle) {
		System.out.println(className + " placeObstacle");
	}

	// Ez itt csak placeholder, fogalmam sincs hogyan tároljuk a pályákat és
	// milyen paraméterekre lesz szükség
	public void buildScene(String settings) {
		System.out.println(className + " buildScene");
	}

	public void delegateTick() {
		System.out.println(className + " delegateTick");
	}
}

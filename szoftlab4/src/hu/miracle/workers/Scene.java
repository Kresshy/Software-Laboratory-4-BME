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
	private Map<Point, Effect> effects; // Ez elvileg nem lista lesz, de m�g nem
										// tudom megmondani hogy mi

	// Protected methods
	// Elt�vol�tja a szemetet a p�ly�r�l (lej�rt akad�lyok �s effektek)
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

	// Egy pont k�rny�ki akad�lyokat adja vissza, a hangya �tvonaltervez�s�hez
	// �s a m�rgez�shez kell
	public List<Obstacle> discoverObstacles(Point point) {
		System.out.println(className + " discoverObstacles");
		return obstacles;
	}

	// �j effektet t�rol el, szagnyom let�tel�hez sz�ks�ges
	public void placeEffect(Point point, Effect effect) {
		System.out.println(className + " placeEffect");
	} 

	// Egy pont k�rzet�ben elt�nteti az effekteket, szagtalan�t� sprayhez
	// sz�ks�ge
	public void clearEffects(Point point) {
		System.out.println(className + " clearEffect");
	}

	// �j akad�lyt t�rol el, m�reg sprayhez sz�ks�ges
	public void placeObstacle(Obstacle obstacle) {
		System.out.println(className + " placeObstacle");
	}

	// Ez itt csak placeholder, fogalmam sincs hogyan t�roljuk a p�ly�kat �s
	// milyen param�terekre lesz sz�ks�g
	public void buildScene(String settings) {
		System.out.println(className + " buildScene");
	}

	public void delegateTick() {
		System.out.println(className + " delegateTick");
	}
}

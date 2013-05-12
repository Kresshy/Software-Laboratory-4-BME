/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Pálya osztály.
 */
public class Scene {

	/** Méret. */
	private Dimension			dimension;

	/** Hangyák. */
	private List<Ant>			ants;

	/** Tárolók. */
	private List<Storage>		storages;

	/** Akadályok. */
	private List<Obstacle>		obstacles;

	/** Élőlények. */
	private List<Creature>		creatures;

	/** Effektek. */
	private Map<Point, Effect>	effects;	// Ez a tároló továbbra sem végleges

	/**
	 * Példányosít egy új pályát.
	 */
	public Scene() {
		this.ants = new ArrayList<Ant>();
		this.storages = new ArrayList<Storage>();
		this.obstacles = new ArrayList<Obstacle>();
		this.creatures = new ArrayList<Creature>();
		this.effects = new HashMap<Point, Effect>();
	}

	/**
	 * Törmelékek eltakarítása.
	 */
	protected void clearDebris() {

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

		// Minden hangyára
		Iterator<Ant> iants = ants.iterator();
		while (iants.hasNext()) {
			Ant ant = iants.next();
			// Ha szemét
			if (ant.isDebris()) {
				// Eltávolítás
				iants.remove();
			}
		}

	}

	/**
	 * Effektek törlése egy pont környezetében.
	 * 
	 * @param point a törlendő terüleet középpontja
	 */
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

	/**
	 * Óraütés delegálása a pályaelemeknek.
	 */
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

	/**
	 * Effektek felderítése egy pályaelem környezetében.
	 * 
	 * @param object a pályaelem
	 * @return a pályaelem környezetében lévő effektek
	 */
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

	/**
	 * Akadályok felderítése egy pályaelem környezetében.
	 * 
	 * @param object a pályaelem
	 * @return a pályaelem környezetében lévő akadályok
	 */
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

	/**
	 * Lekérdezi a hangyák listáját.
	 * 
	 * @return a hangyák listája
	 */
	public List<Ant> getAnts() {

		// Hangyák visszaadása
		return ants;
	}

	/**
	 * Lekérdezi az élőlények listáját.
	 * 
	 * @return az élőlények listája
	 */
	public List<Creature> getCreatures() {

		// Élőlények visszaadása
		return creatures;
	}

	/**
	 * Lekérdezi a pálya méreteit.
	 * 
	 * @return a pálya méretei
	 */
	public Dimension getDimension() {

		// Méret visszaadása
		return dimension;
	}

	/**
	 * Lekérdezi az effektek listáját.
	 * 
	 * @return az effektek listája
	 */
	public Map<Point, Effect> getEffects() {
		return effects;
	}

	/**
	 * Lekérdezi az akadályok listáját.
	 * 
	 * @return az akadályok listája
	 */
	public List<Obstacle> getObstacles() {

		// Akadályok visszaadása
		return obstacles;
	}

	/**
	 * Lekérdezi a tárolók listáját.
	 * 
	 * @return a tárolók listája
	 */
	public List<Storage> getStorages() {

		// Tárolók visszaadása
		return storages;
	}

	/**
	 * Effekt letétele.
	 * 
	 * @param point az effekt pozíciója
	 * @param effect az effekt
	 */
	public void placeEffect(Point point, Effect effect) {

		// Új effekt eltárolása
		effects.put(point, effect);

	}

	/**
	 * Akadály letétele.
	 * 
	 * @param obstacle az akadály
	 */
	public void placeObstacle(Obstacle obstacle) {

		// Új objektum eltárolása
		obstacles.add(obstacle);

	}

}

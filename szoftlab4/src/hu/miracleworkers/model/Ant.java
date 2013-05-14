/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.model.Point.Direction;
import hu.miracleworkers.view.GAnt;
import hu.miracleworkers.view.GraphicsBase;

import java.util.List;
import java.util.Map;

/**
 * Hangya osztály.
 */
public class Ant extends Creature {

	/** Mérgezettség. */
	private boolean		poisoned;

	/** Életerő. */
	private int			health;

	/** Szállított teher. */
	private int			cargo;

	/** Otthon. */
	private Storage		home;

	/** Ételforrás. */
	private Storage		source;

	/** Utolsó mozgás iránya. */
	private Direction	last_direction;

	/**
	 * Példányosít egy új hangyát.
	 * 
	 * @param position a hangya pozíciója
	 * @param scene a pálya amihez a hangya tartozik
	 * @param home a hangya otthona
	 */
	public Ant(Point position, Scene scene, Storage home) {
		super(position, scene, 10);
		this.home = home;
		this.poisoned = false;
		this.health = 200; // TODO: Kezdőérték meghatározása
		this.cargo = 0;
		int rand = (int) (Math.random() * Direction.values().length);
		this.last_direction = Direction.values()[rand];
	}

	/**
	 * Lekérdezi az utolsó mozgás irányát.
	 * 
	 * @return az utolsó mozgás iránya
	 */
	public Direction getDirection() {
		return last_direction;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Creature#getGraphicsWrapper()
	 */
	@Override
	public GraphicsBase getGraphicsWrapper() {
		return new GAnt(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.BaseObject#handleTick()
	 */
	@Override
	public void handleTick() {

		// Ha meg van mérgezve
		if (poisoned) {
			// Élet csökkentése
			health--;
		}

		// Ha elfogyott az élete
		if (health <= 0) {
			// Megsemmisítés
			terminate();
			return;
		}

		// Ételfelvétel
		// Ha nincs rakomány
		if (cargo == 0) {
			// Minden tárolóra
			for (Storage storage : scene.getStorages()) {
				// Ha a tároló vonzza a hangyát és van benne étel
				if (storage.isAttractive() && storage.hasItems()) {
					// Ha a hangya hatókörében van
					if (pointInRange(storage.getPosition())) {
						// Rakomány feltöltése
						cargo = storage.getItems();
						// Ételforrás beállítása
						setSource(storage);
					}
				}
			}
		} else {
			// Ételletétel
			// Ha a hangya hatókörében van
			if (pointInRange(home.getPosition())) {
				// Rakomány kiürítése
				cargo = 0;
				// Ételforrás törlése
				setSource(null);
			}
		}

		// Mozgás
		routeAndMove();

	}

	/**
	 * Leellenőrzi, hogy cipel-e a hangya élelmet.
	 * 
	 * @return true, ha a hangya élelmet cipel
	 */
	public boolean hasCargo() {
		return (cargo > 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.BaseObject#isDebris()
	 */
	@Override
	public boolean isDebris() {
		return health <= 0;
	}

	/**
	 * Leellenőrzi, hogy a hangya meg van-e mérgezve.
	 * 
	 * @return true, ha a hangya meg van mérgezve
	 */
	public boolean isPoisoned() {
		return poisoned;
	}

	/**
	 * Útvonalkeresés és mozgás.
	 */
	protected void routeAndMove() {

		// Céltároló kiválasztása
		Storage target = null;
		// Ha van rakomány
		if (hasCargo()) {
			// Célpont beállítása a szülőbolyra
			target = home;
		} else {
			// Legközelebbi vonzó tároló meghatározása
			// Minden tárolóra
			for (Storage storage : scene.getStorages()) {
				// Ha a tároló vonzza a hangyát és van benne étel
				if (storage.isAttractive() && storage.hasItems()) {
					// Ha még nincs célpont vagy az aktuális tároló közelebb van
					if (target == null
							|| getPosition().distance(storage.getPosition()) < getPosition()
									.distance(target.getPosition())) {
						// Célpont beállítása a tárolóra
						target = storage;
					}
				}
			}
			if (target == null)
				target = home;
		}

		Direction direction = last_direction;
		Point last_position = getPosition();

		// int pheromones = 0;
		// for (Effect effect : effects.values())
		// if (effect.isAttractive())
		// pheromones++;

		// Effectek figyelembe vétele az útválasztásnál
		Map<Point, Effect> effects = scene.discoverEffects(this);
		// Ha van célpont
		if (target != null) {
			if (target != home) {
				if (effects.size() == 0) {
					int rand = -2 + (int) (Math.random() * 5);
					direction = getPosition().direction(target.getPosition());
					direction = Point.rotateDirection(direction, rand);
				}
			} else {
				direction = getPosition().direction(target.getPosition());
			}
			setPosition(getPosition().step(direction, 1));
		} else {
			direction = Direction.LEFT;
		}
		// TODO: Algoritmus kidolgozása

		// Akadályok figyelembe vétele az útválasztásnál
		List<Obstacle> obstacles;
		boolean clean_step = false;
		while (!clean_step) {
			clean_step = true;
			obstacles = scene.discoverObstacles(this);
			for (Obstacle obstacle : obstacles) {
				if (obstacle.isSolid()) {
					// Az óramutató járásának irányába elfordul
					direction = Direction.values()[(direction.ordinal() + 1)
							% Direction.values().length];
					setPosition(last_position.step(direction, 1));
					clean_step = false;
					break;
				}
			}
		}
		last_direction = last_position.direction(getPosition());
		// TODO: Algoritmus kidolgozása

		// Szagnyom letétele
		if (effects.size() == 0) {
			Pheromone new_pheromone = new Pheromone();
			scene.placeEffect(getPosition(), new_pheromone);
		}
		// Akadályokra lépés
		obstacles = scene.discoverObstacles(this);
		// TODO: Algoritmus kidolgozása
		for (Obstacle obstacle : obstacles) {
			if (!obstacle.isSolid()) {
				obstacle.interact(this);
			}
		}

	}

	/**
	 * Beállítja a hangya mérgezettségét.
	 * 
	 * @param poisoned a hangya mérgezettsége
	 */
	public void setPoisoned(boolean poisoned) {

		// Mérgezettség beállítása
		this.poisoned = poisoned;

	}

	/**
	 * Beállítja a hangya ételforrását.
	 * 
	 * @param source a hangya új ételforrása
	 */
	public void setSource(Storage source) {

		// Ételforrás beállítása
		this.source = source;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Creature#terminate()
	 */
	@Override
	public void terminate() {

		// Étel visszatétele
		if (source != null) {
			source.putItems(cargo);
		}

		// Előkészítés respawnra.
		home.putItems(1);

		// Élet nullára csökkentése
		health = 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Ant %%d < position = %s, health = %d, cargo = %d, poisoned = %s >",
				position, health, cargo, String.valueOf(poisoned));
	}

}

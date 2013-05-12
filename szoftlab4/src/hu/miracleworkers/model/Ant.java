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
	private boolean	poisoned;

	/** Életerő. */
	private int		health;

	/** Szállított teher. */
	private int		cargo;

	/** Otthon. */
	private Storage	home;

	/** Ételforrás. */
	private Storage	source;

	/**
	 * Példányosít egy új hangyát.
	 * 
	 * @param position a hangya pozíciója
	 * @param scene a pálya amihez a hangya tartozik
	 * @param home a hangya otthona
	 */
	public Ant(Point position, Scene scene, Storage home) {
		super(position, scene, 5);
		this.home = home;
		this.poisoned = false;
		this.health = 3; // TODO: Kezdőérték meghatározása
		this.cargo = 0;
	}

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
	 * Útvonalkeresés és mozgás.
	 */
	protected void routeAndMove() {

		// Céltároló kiválasztása
		Storage target = null;
		// Ha van rakomány
		if (cargo > 0) {
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
		}

		Direction direction;
		Point old_position = getPosition();
		if (target != null) {
			// Új pozíció meghatározása
			direction = getPosition().direction(target.getPosition());
			setPosition(getPosition().step(direction, 1));
		} else {
			direction = Direction.RIGHT;
		}
		// TODO: Algoritmus kidolgozása

		// Effectek figyelembe vétele az útválasztásnál
		// TODO: Meghatározni, hogy hatnak-e az effektek a haza tartó hangyákra
		Map<Point, Effect> effects = scene.discoverEffects(this);
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
					setPosition(old_position.step(direction, 1));
					clean_step = false;
					break;
				}
			}
		}
		// TODO: Algoritmus kidolgozása

		// Szagnyom letétele
		Pheromone new_pheromone = new Pheromone();
		scene.placeEffect(getPosition(), new_pheromone);
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
	 * Beállítja a hangya mérgezettségét
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

		// Eltávolítás a scene-ből
		// scene.getAnts().remove(this);
		int i = scene.getAnts().indexOf(this);
		scene.getAnts().set(i, null);

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

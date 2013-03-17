package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;
import java.util.List;
import java.util.Map;

public class Ant extends Creature {

	private boolean poisoned;
	private int health;
	private int cargo;
	private Storage home;
	private Storage source;

	public Ant(Point position, Scene scene, Storage home) {
		super(position, Color.BLACK, 1, scene); // TODO: Grafikus jellemzők
												// meghatározása
		this.home = home;
		this.poisoned = false;
		this.health = 5; // TODO: Kezdőérték meghatározása
		this.cargo = 0;
	}

	@Override
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		// Ha elfogyott az élete
		if (health <= 0) {
			// Megsemmisítés
			terminate();
		}

		// Ha meg van mérgezve
		if (poisoned) {
			// Élet csökkentése
			health--;
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
		}

		// Ételletétel
		// Ha a hangya hatókörében van
		if (pointInRange(home.getPosition())) {
			// Rakomány kiürítése
			cargo = 0;
			// Ételforrás törlése
			setSource(null);
		}

		// Mozgás
		routeAndMove();
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");

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

		// Új pozíció meghatározása
		Point new_position = new Point();
		// TODO: Algoritmus kidolgozása

		// Effectek figyelembe vétele az útválasztásnál
		// TODO: Meghatározni, hogy hatnak-e az effektek a haza tartó hangyákra
		Map<Point, Effect> effects = scene.discoverEffects(this);
		// TODO: Algoritmus kidolgozása

		// Akadályok figyelembe vétele az útválasztásnál
		List<Obstacle> obstacles = scene.discoverObstacles(this);
		// TODO: Algoritmus kidolgozása

		// Lépés
		// Új pozíció beállítása
		setPosition(new_position);
		// Szagnyom letétele
		Pheromone new_pheromone = new Pheromone();
		scene.placeEffect(new_position, new_pheromone);
		// Akadályokra lépés
		obstacles = scene.discoverObstacles(this);
		// TODO: Algoritmus kidolgozása
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(getClass().getCanonicalName() + ".setPoisoned()");

		// Mérgezettség beállítása
		this.poisoned = poisoned;
	}

	public void setSource(Storage source) {
		System.out.println(getClass().getCanonicalName() + ".setSource()");

		// Ételforrás beállítása
		this.source = source;
	}

	@Override
	public void terminate() {
		System.out.println(getClass().getCanonicalName() + ".terminate()");

		// Étel visszatétele
		if (source != null) {
			source.putItems(cargo);
		}

		// Előkészítés respawnra.
		home.putItems(1);

		// Eltávolítás a scene-ből
		scene.getAnts().remove(this);
	}

}

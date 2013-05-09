package hu.miracleworkers.model;

import java.awt.Color;

public class AntSinker extends Obstacle {

	public AntSinker(Scene scene, Point position) {
		// TODO: Grafikus jellemzők meghatározása
		super(scene, position, Color.GRAY, 2, false, false);
	}

	@Override
	public void interact(Creature creature) {

		// Interakcióba lépő élőlény elpusztítása
		creature.terminate();

	}

	public String toString() {
		return String.format("AntSinker %%d < position = %s, radius = %d >", position, radius);
	}

}

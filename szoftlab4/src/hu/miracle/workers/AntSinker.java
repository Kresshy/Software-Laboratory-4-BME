﻿package hu.miracle.workers;

import java.awt.Color;

public class AntSinker extends Obstacle {

	public AntSinker(Point position) {
		super(position, Color.GRAY, 2, false, false); // TODO: Grafikus jellemzők meghatározása
	}

	@Override
	public void interact(Creature creature) {
		CallLogger.getLogger().entering(this, "interact");

		// Interakcióba lépő élőlény elpusztítása
		creature.terminate();

		CallLogger.getLogger().exiting();
	}

	public String toString() {
		return String.format("AntSinker %%d < position = %s, radius = %d >", position, radius);
	}

}

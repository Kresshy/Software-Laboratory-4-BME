package hu.miracle.workers;

import java.awt.Color;

public abstract class Creature extends BaseObject {

	protected Scene scene;

	public Creature(Point position, Color color, int radius, Scene scene) {
		super(position, color, radius);
		this.scene = scene;
	}

	public void setScene(Scene scene) {
		CallLogger.getLogger().entering(this, "setScene");

		// Pálya beállítása
		this.scene = scene;

		CallLogger.getLogger().exiting();
	}

	public void terminate() {
		CallLogger.getLogger().entering(this, "terminate");

		// Dummy default implementáció
		
		CallLogger.getLogger().exiting();
	}

}

package hu.miracle.workers;

import java.awt.Color;

public class AntHill extends Storage {

	private Scene scene;

	public AntHill(Point position, Scene scene, int capacity, int packet) {
		super(position, Color.BLUE, 3, capacity, packet, false); // TODO: Grafikus jellemzők meghatározása
		this.scene = scene;
	}

	@Override
	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Hangyák születése
		// Minden hangyára
		for (int i = getItems(); i > 0; i--) {
			// Létrehozás
			Ant ant = new Ant(getPosition(), scene, this);
			// Tárolás
			scene.getAnts().add(ant);
		}

		CallLogger.getLogger().exiting();
	}
	public String toString(){
		return String.format("AntHill %%d < position = (%d,%d), amount = %d, capacity = %d, packet = %d >", position.getX(), position.getY(),amount,capacity,packet);
	}

}

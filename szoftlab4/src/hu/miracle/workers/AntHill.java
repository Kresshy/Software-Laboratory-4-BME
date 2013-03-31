package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "anthill")
public class AntHill extends Storage {

	private Scene scene;

	public AntHill() {
		// TODO Auto-generated constructor stub
	}

	public AntHill(Point position, Scene scene, int capacity, int packet) {
		// TODO: Grafikus jellemzők meghatározása
		super(position, Color.BLUE, 3, capacity, packet, false);
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

}

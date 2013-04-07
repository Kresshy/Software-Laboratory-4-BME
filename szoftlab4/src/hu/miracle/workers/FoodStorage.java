package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "foodstorage")
public class FoodStorage extends Storage {

	public FoodStorage() {
		// TODO Auto-generated constructor stub
	}

	public FoodStorage(Point position, int capacity, int packet) {
		// TODO: Grafikus jellemzők meghatározása
		super(position, Color.RED, 3, capacity, packet, true);
	}

	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

}

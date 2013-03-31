package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement(name = "storage")
@XmlSeeAlso({ FoodStorage.class, AntHill.class })
public abstract class Storage extends BaseObject {

	protected int amount;
	protected int capacity;
	protected int packet;
	protected boolean attractive;

	public Storage() {

	}

	public Storage(Point position, Color color, int radius, int capacity, int packet,
			boolean attractive) {
		super(position, color, radius);
		this.capacity = capacity;
		this.amount = capacity;
		this.attractive = attractive;
	}

	public int getItems() {
		CallLogger.getLogger().entering(this, "getItems");

		// Maximálisan kivehető elemek meghatározása
		int count = Math.min(amount - packet, packet);
		// Tárolt elemek csökkentése
		amount -= count;

		CallLogger.getLogger().exiting();

		// Kivett elemek visszaadása
		return count;
	}

	public boolean hasItems() {
		CallLogger.getLogger().entering(this, "hasItems");

		CallLogger.getLogger().exiting();

		// Tartalmazás visszaadása
		return (amount > 0);
	}

	public boolean isAttractive() {
		CallLogger.getLogger().entering(this, "isAttractive");

		CallLogger.getLogger().exiting();

		// Vonzalom visszadása
		return attractive;
	}

	public void putItems(int count) {
		CallLogger.getLogger().entering(this, "putItems");

		// Tárolt elemek növelése
		amount = Math.min(capacity, amount + count);

		CallLogger.getLogger().exiting();
	}

}

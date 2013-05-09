package hu.miracleworkers.model;

public abstract class Storage extends BaseObject {

	protected int		amount;
	protected int		capacity;
	protected int		packet;
	protected boolean	attractive;

	public Storage(Point position, int radius, int capacity, int packet, boolean attractive) {
		super(position, radius);
		this.capacity = capacity;
		this.amount = capacity;
		this.packet = packet;
		this.attractive = attractive;
	}

	public int getItems() {

		// Maximálisan kivehető elemek meghatározása
		int count = Math.min(amount, packet);
		// Tárolt elemek csökkentése
		amount -= count;

		// Kivett elemek visszaadása
		return count;
	}

	public boolean hasItems() {

		// Tartalmazás visszaadása
		return (amount > 0);
	}

	public boolean isAttractive() {

		// Vonzalom visszadása
		return attractive;
	}

	public void putItems(int count) {

		// Tárolt elemek növelése
		amount = Math.min(capacity, amount + count);

	}

}

package hu.miracle.workers;

public class FoodStorage extends Storage {

	// Constructor
	public FoodStorage(int capacity) {
		super(capacity, true);
	}

	// Public interface
	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");
	}

	// etelfelvetel
	public int getItems() {
		System.out.println(getClass().getCanonicalName() + ".getItems()");

		if (amount > 0) {
			amount--;
			return 1;
		} else {
			return 0;
		}

	}

	// etelvisszarakas
	public void putItems(int count) {
		System.out.println(getClass().getCanonicalName() + ".putItems()");

		if (capacity < amount + count) {
			this.amount += capacity - amount;
		} else {
			this.amount += count;
		}
	}
}

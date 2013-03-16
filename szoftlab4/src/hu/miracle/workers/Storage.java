package hu.miracle.workers;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // Tarolt elemek
	protected int capacity; // Tarolt elemek maximalis szama
	protected boolean attractive;

	public Storage(int capacity, boolean attractive) {
		this.capacity = capacity;
		this.attractive = attractive;
	}

	// Abstract methods
	// Tarolobol elemeket vesz ki, etelfelvetelhez szukseges
	public abstract int getItems();

	// Taroloba elemeket tesz vissza, etel visszatetelehez es
	// hangyak ujjaeledesehez szukseges
	public abstract void putItems(int count);

	// Public interface
	public boolean hasItems() {
		return (amount < 0);
	}

	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");
		// FIXME
		return false;
	}

}

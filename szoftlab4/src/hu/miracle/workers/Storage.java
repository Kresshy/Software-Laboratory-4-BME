package hu.miracle.workers;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // Tárolt elemek
	protected int capacity; // Tárolt elemek maximális száma
	protected boolean attractive;

	// Abstract methods
	// Tárolóból elemeket vesz ki, ételfelvételhez szükséges
	public abstract int getItems();

	// Tárolóba elemeket tesz vissza, étel visszatételéhez és
	// hangyák újjáéledéséhez szükséges
	public abstract void putItems(int count);

	// Public interface
	public boolean isAttractive() {
		System.out.println(getClass().getCanonicalName() + ".isAttractive()");
		return false;
	}

}

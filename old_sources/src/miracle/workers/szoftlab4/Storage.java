package miracle.workers.szoftlab4;

public abstract class Storage extends BaseObject {
	// Members
    protected int amount; // Tárolt elemek
    protected int capacity; // Tárolt elemek maximális száma

    // Abstract methods
    public abstract int getItems(); // Tárolóból elemeket vesz ki, ételfelvételhez szükséges
    public abstract void putItems(int count); // Tárolóba elemeket tesz vissza, étel visszatételéhez és hangyák újjáéledéséhez szükséges
}

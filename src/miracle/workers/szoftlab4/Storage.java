package miracle.workers.szoftlab4;

public abstract class Storage extends BaseObject {
	// Members
    protected int amount; // T�rolt elemek
    protected int capacity; // T�rolt elemek maxim�lis sz�ma

    // Abstract methods
    public abstract int getItems(); // T�rol�b�l elemeket vesz ki, �telfelv�telhez sz�ks�ges
    public abstract void putItems(int count); // T�rol�ba elemeket tesz vissza, �tel visszat�tel�hez �s hangy�k �jj��led�s�hez sz�ks�ges
}

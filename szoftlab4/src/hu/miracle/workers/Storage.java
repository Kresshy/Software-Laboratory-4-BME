package hu.miracle.workers;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // T�rolt elemek
	protected int capacity; // T�rolt elemek maxim�lis sz�ma

	// Abstract methods
	// T�rol�b�l elemeket vesz ki, // �telfelv�telhez sz�ks�ges
	public abstract int getItems(); 
									
	// T�rol�ba elemeket tesz vissza, // �tel visszat�tel�hez �s 
	// hangy�k �jj��led�s�hez // sz�ks�ges
	public abstract void putItems(int count); 
												
												
												
}

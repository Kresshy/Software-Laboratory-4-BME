package hu.miracle.workers;

public abstract class Storage extends BaseObject {

	// Members
	protected int amount; // Tarolt elemek
	protected int capacity; // Tarolt elemek maximalis szama

	// Abstract methods
	// Tarolabal elemeket vesz ki, etelfelvetelhez szukseges
	public abstract int getItems(); 
									
	// Taroloba elemeket tesz vissza, etel visszatetelehez es 
	// hangyak ujjaeledesehez szukseges
	public abstract void putItems(int count); 
												
												
												
}

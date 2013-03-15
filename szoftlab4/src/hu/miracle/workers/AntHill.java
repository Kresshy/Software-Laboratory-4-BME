package hu.miracle.workers;

public class AntHill extends Storage {

	private static final String className = "AntHill";

	// Members
	// szukseges, hogy a hangyak ismerjek a scenet
	private Scene scene; 

	// Constructor
	public AntHill() {
	}

	// Protected methods
	// Itt visszaadjuk a tarolo elemeit, ebben az osztalyban a hangyak lesznek azok
	// remelem igy ki lehet takaritani - sajnos nem lehet !!!!!!!!!!!!
	public int getItems() { 
		System.out.println(className + " getItems");
		return 0;
	}

	// Public interface
	public void handleTick() {
		System.out.println(className + " handleTick");
	}

	// Hangyak halalakor uj hangya szulethessen
	public void putItems(int count) {
		System.out.println(className + " putItems");
	} 
}

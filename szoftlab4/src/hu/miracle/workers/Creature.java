package hu.miracle.workers;

public abstract class Creature extends BaseObject {

	private static String className = "Creature";

	// Members
	protected Scene scene;

	// Public interface
	public void setScene(Scene scene) {
		System.out.println(className + " setScene");
	}

	public void terminate() {
		System.out.println(className + " terminate");
	}
}

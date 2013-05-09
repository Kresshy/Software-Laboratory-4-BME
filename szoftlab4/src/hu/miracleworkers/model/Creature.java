package hu.miracleworkers.model;

public abstract class Creature extends BaseObject {

	protected Scene	scene;

	public Creature(Point position, int radius, Scene scene) {
		super(position, radius);
		this.scene = scene;
	}

	public void setScene(Scene scene) {

		// Pálya beállítása
		this.scene = scene;

	}

	public void terminate() {

		// Dummy default implementáció

	}

}

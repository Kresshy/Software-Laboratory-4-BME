package hu.miracleworkers.model;

public class AntSinker extends Obstacle {

	public AntSinker(Scene scene, Point position) {
		super(scene, position, 2, false, false);
	}

	@Override
	public void interact(Creature creature) {

		// Interakcióba lépő élőlény elpusztítása
		creature.terminate();

	}

	public String toString() {
		return String.format("AntSinker %%d < position = %s, radius = %d >", position, radius);
	}

}

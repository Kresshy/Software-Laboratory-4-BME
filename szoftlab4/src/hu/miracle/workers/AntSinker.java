package hu.miracle.workers;

public class AntSinker extends Obstacle {

	public AntSinker() {
		super(false);
	}

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");

		// Interakcióba lépő élőlény elpusztítása
		creature.terminate();
	}

}

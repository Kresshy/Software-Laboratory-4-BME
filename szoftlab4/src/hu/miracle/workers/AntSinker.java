package hu.miracle.workers;

public class AntSinker extends Obstacle {

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
		
		creature.terminate();
	}
}

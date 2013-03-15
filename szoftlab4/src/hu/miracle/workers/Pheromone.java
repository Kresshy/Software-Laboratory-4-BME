package hu.miracle.workers;

public class Pheromone extends Effect {

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}

}

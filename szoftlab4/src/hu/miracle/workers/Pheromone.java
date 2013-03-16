package hu.miracle.workers;

public class Pheromone extends Effect {

	public Pheromone(int timeout, boolean attractive) {
		super(timeout, attractive);
	}

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
	}

}

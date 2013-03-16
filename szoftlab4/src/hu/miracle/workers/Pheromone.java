package hu.miracle.workers;

public class Pheromone extends Effect {

	// FIXME
	public Pheromone(int timeout, boolean attractive) {
		super(timeout, attractive);
	}

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");
		
		if (timeout > 0){
	        timeout -= 1;
		}
	}

}

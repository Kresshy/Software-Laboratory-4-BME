package hu.miracle.workers;

public class Pheromone extends Effect {

	// FIXME
	public Pheromone() {
		// TODO: Elillanás idejének meghatározása
		super(10, true);
	}

	@Override
	public void interact(Creature creature) {
		System.out.println(getClass().getCanonicalName() + ".interact()");

		if (timeout > 0) {
			timeout -= 1;
		}
	}

}

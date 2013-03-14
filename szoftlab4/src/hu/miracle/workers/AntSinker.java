package hu.miracle.workers;

public class AntSinker extends Obstacle {

	private static final String className = "AntSinker";

	@Override
	public void interact(Creature creature) {
		System.out.println(className + " interact");
		
	}
}

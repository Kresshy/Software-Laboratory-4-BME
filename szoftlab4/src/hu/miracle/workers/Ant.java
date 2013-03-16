package hu.miracle.workers;

public class Ant extends Creature {

	// Members
	private Storage home;
	private Storage source;
	private boolean poisoned;
	private int health;
	private int cargo;

	// Constructor
	public Ant(Storage home, Storage source, boolean poisoned, int health) {
		this.home = home;
		this.source = source;
		this.poisoned = poisoned;
		this.health = health;
		this.cargo = 0;
	}

	// Protected methods
	protected void routeAndMove() {
		System.out.println(getClass().getCanonicalName() + ".routeAndMove()");
	}

	// Public interface
	public void setPoisoned(boolean poisoned) {
		System.out.println(getClass().getCanonicalName() + ".setPoisoned()");

		this.poisoned = poisoned;
	}

	public void handleTick() {
		System.out.println(getClass().getCanonicalName() + ".handleTick()");

		if (poisoned) {
			if (health > 0) {
				health--;
			}
		}

		routeAndMove();

		
		
	}

	@Override
	public void terminate() {
		System.out.println(getClass().getCanonicalName() + ".terminate()");
		
		health = 0;
	}

	public void setSource(Storage storage) {
		System.out.println(getClass().getCanonicalName() + ".setSource()");

	}

	public boolean isDead() {
		if (health > 0) {
			return false;
		} else {
			return true;
		}
	}

}

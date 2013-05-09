package hu.miracleworkers.model;

public class Poison extends Obstacle {

	private int	timeout;

	public Poison(Scene scene, Point position) {
		super(scene, position, 5, false, false);
		this.timeout = 5;
	}

	@Override
	public void handleTick() {

		// Ha még nem illant el
		if (timeout > 0) {
			// Hátralévő idő csökkentése
			timeout--;
		}

	}

	@Override
	public void interact(Creature creature) {

		// FIXME
		// Mérgezés beállítása
		((Ant) creature).setPoisoned(true);

	}

	@Override
	public boolean isDebris() {

		// Eltakaríthatóság visszaadása
		return (timeout <= 0);
	}

	public String toString() {
		return String.format("Poison %%d < position = %s, radius = %d, timeout = %d >", position,
				radius, timeout);
	}

}

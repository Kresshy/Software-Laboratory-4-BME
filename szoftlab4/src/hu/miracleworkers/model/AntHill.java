package hu.miracleworkers.model;

public class AntHill extends Storage {

	private Scene	scene;

	public AntHill(Point position, Scene scene, int capacity, int packet) {
		super(position, 3, capacity, packet, false);
		this.scene = scene;
	}

	@Override
	public void handleTick() {

		// Hangyák születése
		// Minden hangyára
		for (int i = getItems(); i > 0; i--) {
			// Létrehozás
			Ant ant = new Ant(getPosition(), scene, this);
			// Tárolás
			scene.getAnts().add(ant);
			// FIXME: Kimenet eltávolítása
			System.out.println(String.format("Ant %d spawned.", scene.getAnts().indexOf(ant)));
		}

	}

	public String toString() {
		return String.format(
				"AntHill %%d < position = %s, amount = %d, capacity = %d, packet = %d >", position,
				amount, capacity, packet);
	}

}

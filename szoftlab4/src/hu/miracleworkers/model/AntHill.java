/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Hangyaboly osztály.
 */
public class AntHill extends Storage {

	/** Pálya. */
	private Scene	scene;

	/**
	 * Példányosít egy új hangyabolyt.
	 * 
	 * @param position a hangyaboly pozíciója
	 * @param scene a pálya amihez a hangyaboly tartozik
	 * @param capacity a hangyabolyhoz tartozó hangyák maximális száma
	 * @param packet az óraütésenként született hangyák száma
	 */
	public AntHill(Point position, Scene scene, int capacity, int packet) {
		super(position, 3, capacity, packet, false);
		this.scene = scene;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.BaseObject#handleTick()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"AntHill %%d < position = %s, amount = %d, capacity = %d, packet = %d >", position,
				amount, capacity, packet);
	}

}

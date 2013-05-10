/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Hangyaleső osztály
 */
public class AntSinker extends Obstacle {

	/**
	 * Példányosít egy új hangyalesőt.
	 * 
	 * @param position a hangyaleső pozíciója
	 * @param scene a pálya amihez a hangyaleső tartozik
	 */
	public AntSinker(Point position, Scene scene) {
		super(position, scene, 2, false, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#interact(hu.miracleworkers.model.Creature )
	 */
	@Override
	public void interact(Creature creature) {

		// Interakcióba lépő élőlény elpusztítása
		creature.terminate();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Obstacle#toString()
	 */
	public String toString() {
		return String.format("AntSinker %%d < position = %s, radius = %d >", position, radius);
	}

}

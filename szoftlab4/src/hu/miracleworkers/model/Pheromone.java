/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Hangyaszag osztály.
 */
public class Pheromone extends Effect {

	/**
	 * Példányosít egy új hangyaszagot.
	 */
	public Pheromone() {
		// TODO: Elillanás idejének meghatározása
		super(50, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.Effect#interact(hu.miracleworkers.model.Creature)
	 */
	@Override
	public void interact(Creature creature) {

		// Dummy default implementáció

	}

}

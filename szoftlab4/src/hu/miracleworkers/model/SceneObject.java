/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Pályaelemek interfésze.
 */
public interface SceneObject {

	/**
	 * Óraütés kezelése.
	 */
	public void handleTick();

	/**
	 * Ellenőrzi, hogy a pályaelem eltakarítható-e.
	 * 
	 * @return true, ha a pályaelem eltakarítható
	 */
	public boolean isDebris();

}

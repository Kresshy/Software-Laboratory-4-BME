/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 * 
 */
package hu.miracleworkers.controller;

/**
 * Játékfigyelő interfész.
 *
 * @see GameEvent
 */
public interface GameListener {
	
	
	/**
	 * Game ended event.
	 */
	public void gameOver();

}

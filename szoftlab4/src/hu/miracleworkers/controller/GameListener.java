/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

/**
 * Játékfigyelő interfész.
 */
public interface GameListener {

	/**
	 * Nehézség változás esemény.
	 */
	public void difficultyChange(int new_difficulty);

	/**
	 * Játék vége esemény.
	 */
	public void gameOver();

	/**
	 * Pontszám változás esemény.
	 */
	public void scoreChange(long new_score);
}

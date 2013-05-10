/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

import hu.miracleworkers.model.HighScore;
import hu.miracleworkers.model.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Játék osztály.
 */
public class Game {

	/** Tárolt rekordok száma. */
	private static final int	highscoresize	= 10;

	/** Rekordok tárolására használt fájl. */
	private static final String	path			= "savegame.dat";

	/** Pálya. */
	private Scene				scene;

	/** Időzítő. */
	private Timer				timer;

	/** Nehézség. */
	private int					difficulty;

	/** Rekordok. */
	private List<HighScore>		highscores;

	/**
	 * Példányosít egy új játékot.
	 * 
	 * @param scene a játékhoz tartozó pálya
	 * @param timer a játékhoz tartozó időzítő
	 */
	public Game(Scene scene, Timer timer) {
		this.scene = scene;
		this.timer = timer;
		this.timer.setGame(this);
		this.highscores = new ArrayList<HighScore>();
	}

	/**
	 * Lekérdezi a játékhoz tartozó pályát.
	 * 
	 * @return a játékhoz tartozó pálya
	 */
	public Scene getScene() {

		// Pálya visszaadása
		return scene;
	}

	/**
	 * Lekérdezi a játékhoz tartozó időzítőt.
	 * 
	 * @return a játékhoz tartozó időzítő
	 */
	public Timer getTimer() {

		// Időzítő visszaadása
		return timer;
	}

	/**
	 * Beállítja a játékhoz tartozó pályát.
	 * 
	 * @param scene a játékhoz tartozó új pálya
	 */
	public void setScene(Scene scene) {

		// Pálya beállítása
		this.scene = scene;

	}

	/**
	 * Beállítja a játékhoz tartozó időzítőt.
	 * 
	 * @param timer a játékhoz tartozó új időzítő
	 */
	public void setTimer(Timer timer) {

		// Időzítő beállítása
		this.timer = timer;
		timer.setGame(this);

	}

	/**
	 * Lekérdezi a játék nehézségét.
	 * 
	 * @return a játék nehézsége
	 */
	public int getDifficulty() {

		return difficulty;
	}

	/**
	 * Beállítja a játék nehézségét.
	 * 
	 * @param difficulty a játék új nehézsége
	 */
	public void setDifficulty(int difficulty) {

		this.difficulty = difficulty;
	}

	/**
	 * Hozzáad egy új rekordot.
	 * 
	 * @param name a felhasználó neve
	 * @param score az elért eredmény
	 */
	public void addHighscore(String name, int score) {

		// Highscore hozzáadása
		highscores.add(new HighScore(name, score));
		// Rendezés és a legjobb elemek kiválasztása
		Collections.sort(highscores, Collections.reverseOrder());
		highscores = highscores.subList(0, (highscores.size() < highscoresize) ? highscores.size()
				: highscoresize);

	}

	/**
	 * Elmenti a rekordokat.
	 */
	public void saveHighscores() {

		// Dummy default implementáció

	}

}

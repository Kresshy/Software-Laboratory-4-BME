package hu.miracleworkers.controller;

import hu.miracleworkers.model.HighScore;
import hu.miracleworkers.model.Scene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

	private static final int	highscoresize	= 10;
	private static final String	path			= "savegame.dat";

	private Scene				scene;
	private Timer				timer;
	private int					difficulty;
	private List<HighScore>		highscores;

	public Game(Scene scene, Timer timer) {
		this.scene = scene;
		this.timer = timer;
		this.timer.setGame(this);
		this.highscores = new ArrayList<HighScore>();
	}

	public Scene getScene() {

		// Pálya visszaadása
		return scene;
	}

	public Timer getTimer() {

		// Időzítő visszaadása
		return timer;
	}

	public void setScene(Scene scene) {

		// Pálya beállítása
		this.scene = scene;

	}

	public void setTimer(Timer timer) {

		// Időzítő beállítása
		this.timer = timer;

	}

	public int getDifficulty() {

		return difficulty;
	}

	public void setDifficulty(int difficulty) {

		this.difficulty = difficulty;
	}

	public void addHighscore(String name, int score) {

		// Highscore hozzáadása
		highscores.add(new HighScore(name, score));
		// Rendezés és a legjobb elemek kiválasztása
		Collections.sort(highscores, Collections.reverseOrder());
		highscores = highscores.subList(0, (highscores.size() < highscoresize) ? highscores.size()
				: highscoresize);

	}

	public void saveHighscores() {

		// Dummy default implementáció

	}

}

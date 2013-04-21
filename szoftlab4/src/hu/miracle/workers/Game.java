package hu.miracle.workers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

	private static final int highscoresize = 10;
	private static final String path = "savegame.dat";

	private Scene scene;
	private Timer timer;
	private int difficulty;
	private List<HighScore> highscores;

	public Game(Scene scene, Timer timer) {
		this.scene = scene;
		this.timer = timer;
		this.timer.setGame(this);
		this.highscores = new ArrayList<HighScore>();
	}

	public Scene getScene() {
		CallLogger.getLogger().entering(this, "getScene");

		CallLogger.getLogger().exiting();

		// Pálya visszaadása
		return scene;
	}

	public Timer getTimer() {
		CallLogger.getLogger().entering(this, "getTimer");

		CallLogger.getLogger().exiting();

		// Időzítő visszaadása
		return timer;
	}

	public void setScene(Scene scene) {
		CallLogger.getLogger().entering(this, "setScene");

		// Pálya beállítása
		this.scene = scene;

		CallLogger.getLogger().exiting();
	}

	public void setTimer(Timer timer) {
		CallLogger.getLogger().entering(this, "setTimer");

		// Időzítő beállítása
		this.timer = timer;

		CallLogger.getLogger().exiting();
	}

	public int getDifficulty() {
		CallLogger.getLogger().entering(this, "getDifficulty");

		CallLogger.getLogger().exiting();

		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		CallLogger.getLogger().entering(this, "setDifficulty");

		CallLogger.getLogger().exiting();

		this.difficulty = difficulty;
	}

	public void addHighscore(String name, int score) {
		CallLogger.getLogger().entering(this, "addHighscore");

		// Highscore hozzáadása
		highscores.add(new HighScore(name, score));
		// Rendezés és a legjobb elemek kiválasztása
		Collections.sort(highscores, Collections.reverseOrder());
		highscores = highscores.subList(0, (highscores.size() < highscoresize) ? highscores.size() : highscoresize);

		CallLogger.getLogger().exiting();
	}

	public void saveHighscores() {
		CallLogger.getLogger().entering(this, "saveHighscores");

		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

import hu.miracleworkers.model.Ant;
import hu.miracleworkers.model.HighScore;
import hu.miracleworkers.model.Point;
import hu.miracleworkers.model.Poison;
import hu.miracleworkers.model.Scene;
import hu.miracleworkers.model.Storage;
import hu.miracleworkers.view.Perspective;

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
	private static final String	path			= "highscores.dat";

	/** Pálya. */
	private Scene				scene;

	/** Nézet. */
	private Perspective			perspective;

	/** Időzítő. */
	private Timer				timer;

	/** Eseményfigyelő. */
	private GameListener		listener;

	/** Nehézség. */
	private int					difficulty;

	/** Pontszám. */
	private long				score;

	/** Elérhető méregspray-k száma. */
	private int					poisons;

	/** Elérhető szagtalanítóspray-k száma. */
	private int					deodorizers;

	/** Rekordok. */
	private List<HighScore>		highscores;

	/**
	 * Példányosít egy új játékot.
	 * 
	 * @param scene a játékhoz tartozó pálya
	 * @param perspective the perspective
	 * @param timer a játékhoz tartozó időzítő
	 */
	public Game(/* Scene scene, */Perspective perspective, Timer timer) {
		this.scene = new Scene();
		setTimer(timer);
		setPerspective(perspective);
		this.highscores = new ArrayList<HighScore>();
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
		highscores = highscores.subList(0, Math.min(highscoresize, highscores.size()));

	}

	public void createNewScene(int difficulty) {
		XMLBuilder builder = new XMLBuilder();
		// Scene scene = new Scene();

		setDifficulty(difficulty);
		poisons = 5;
		deodorizers = 5;
		score = 0;

		try {
			switch (difficulty) {
			case 1:
				this.scene = builder.readXML("test/test_graphics.xml");
				break;
			case 2:
				this.scene = builder.readXML("test/test_graphics2.xml");
				break;
			case 3:
				this.scene = builder.readXML("test/test_graphics3.xml");
				break;
			default:
				this.scene = builder.readXML("test/test_graphics.xml");
				break;
			}

			perspective.refreshPanel();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Lekérdezi a szagtalanító spray-k számát.
	 * 
	 * @return a szagtalanító spray-k száma
	 */
	public int getDeodorizers() {
		return deodorizers;
	}

	/**
	 * Lekérdezi a játék nehézségét.
	 * 
	 * @return a játék nehézsége
	 */
	public int getDifficulty() {

		// Nehézség visszaadása
		return difficulty;
	}

	/**
	 * Lekérdezi a rekordokat.
	 * 
	 * @return a rekordok listája
	 */
	public List<HighScore> getHighscores() {
		return highscores;
	}

	/**
	 * Lekérdezi a játékhoz tartozó nézetet.
	 * 
	 * @return a játékhoz tartozó nézet
	 */
	public Perspective getPerspective() {

		// Nézet visszaadása
		return perspective;
	}

	/**
	 * Lekérdezi a méreg spray-k számát.
	 * 
	 * @return a méreg spray-k száma
	 */
	public int getPoisons() {
		return poisons;
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
	 * Lekérdezi a játékban elért pontszámot.
	 * 
	 * @return a játékban elért pontszám
	 */
	public long getScore() {
		return score;
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
	 * Óraütés kezelése.
	 */
	public void handleTick() {
		score += difficulty;
		listener.scoreChange(score);
		if (isOver() && listener != null) {
			listener.gameOver();
		}
	}

	/**
	 * Ellenőrzi, hogy véget ért-e a játék.
	 * 
	 * @return true, ha a játék véget ért
	 */
	public boolean isOver() {
		for (Storage storage : scene.getStorages()) {
			if (storage.isAttractive() && storage.hasItems())
				return false;
		}
		for (Ant ant : scene.getAnts()) {
			if (ant.hasCargo())
				return false;
		}
		return true;
	}

	/**
	 * Betölti a rekordokat.
	 */
	public void loadHighscores() {

		// TODO: Dummy default implementáció

	}

	/**
	 * Place deodorizer.
	 * 
	 * @param x the x
	 * @param y the y
	 */
	public void placeDeodorizer(int x, int y) {

		if (deodorizers > 0) {
			// Érvényes pozíció meghatározása
			for (int dx = 0; dx <= 3; dx++) {
				for (int dy = 0; dy <= 2; dy++) {
					// Próbálkozás amíg érvényes pontot nem találunk
					Point position = Point.fromCoords(x + dx, y + dy);
					if (position != null) {
						// Pálya szagtalanítása
						getScene().clearEffects(position);
						deodorizers--;
						return;
					}
				}
			}
		}

	}

	/**
	 * Letesz egy mérget a megadott helyre.
	 * 
	 * @param x az X koordináta
	 * @param y az Y koordináta
	 */
	public void placePoison(int x, int y) {

		if (poisons > 0) {
			// Érvényes pozíció meghatározása
			for (int dx = 0; dx <= 3; dx++) {
				for (int dy = 0; dy <= 2; dy++) {
					// Próbálkozás amíg érvényes pontot nem találunk
					Point position = Point.fromCoords(x + dx, y + dy);
					if (position != null) {
						// Méreg hozzáadása a pályához
						getScene().placeObstacle(new Poison(position, getScene()));
						poisons--;
						return;
					}
				}
			}
		}
	}

	/**
	 * Elmenti a rekordokat.
	 */
	public void saveHighscores() {

		// TODO: Dummy default implementáció

	}

	/**
	 * Beállítja a játék nehézségét.
	 * 
	 * @param difficulty a játék új nehézsége
	 */
	public void setDifficulty(int difficulty) {

		// Nehézség beállítása
		this.difficulty = difficulty;
		listener.difficultyChange(difficulty);

	}

	/**
	 * Beállítja a játékhoz tartozó eseményfigyelőt.
	 * 
	 * @param listener a játékhoz tartozó új eseményfigyelő
	 */
	public void setListener(GameListener listener) {
		this.listener = listener;
	}

	/**
	 * Beállítja a játékhoz tartozó nézetet.
	 * 
	 * @param perspective a játékhoz tartozó új nézet
	 */
	public void setPerspective(Perspective perspective) {

		// Nézet beállítása
		this.perspective = perspective;
		perspective.setGame(this);

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
}

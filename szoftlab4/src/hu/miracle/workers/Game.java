package hu.miracle.workers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Game {

	private Scene scene;
	private Timer timer;
	private int difficulty;
	private ArrayList<Integer> topList;
	private static final String path = "savegame.dat";

	public Game(Scene scene, Timer timer) {
		this.scene = scene;
		this.timer = timer;
		this.timer.setGame(this);
		this.topList = new ArrayList<Integer>();

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

	public void writeTopList(int score) {
		CallLogger.getLogger().entering(this, "writeTopList");

		if (topList.isEmpty()) {

			topList.add(new Integer(score));

		} else {

			if (topList.get(0) < score) {
				topList.remove(0);
				topList.add(new Integer(score));

			}
		}

		Collections.sort(topList);

		CallLogger.getLogger().exiting();
	}

	public void saveTopList() {
		CallLogger.getLogger().entering(this, "saveTopList");

		File file = new File(path);

		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(topList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CallLogger.getLogger().exiting();
	}

}

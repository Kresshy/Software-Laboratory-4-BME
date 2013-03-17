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

	public Game(Scene scene) {
		this.scene = scene;
//		this.timer = timer;
		this.topList = new ArrayList<Integer>();

	}

	public Scene getScene() {
		System.out.println(getClass().getCanonicalName() + ".getScene()");

		// Pálya visszaadása
		return scene;
	}

	public Timer getTimer() {
		System.out.println(getClass().getCanonicalName() + ".getTimer()");

		// Időzítő visszaadása
		return timer;
	}

	public void setScene(Scene scene) {
		System.out.println(getClass().getCanonicalName() + ".setScene()");

		// Pálya beállítása
		this.scene = scene;
	}

	public void setTimer(Timer timer) {
		System.out.println(getClass().getCanonicalName() + ".setTimer()");

		// Időzítő beállítása
		this.timer = timer;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void writeTopList(int score) {

		if (topList.isEmpty()) {

			topList.add(new Integer(score));

		} else {

			if (topList.get(0) < score) {
				topList.remove(0);
				topList.add(new Integer(score));

			}
		}

		Collections.sort(topList);

	}

	public void saveTopList() {
		File file = new File(path);

		try {
			ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file));
			ous.writeObject(topList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

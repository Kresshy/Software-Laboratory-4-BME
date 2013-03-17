package hu.miracle.workers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
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

		topList=new ArrayList<Integer>();
		
		File file = new File(path);
		if (file.exists()) {
			try {

				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				topList = (ArrayList<Integer>) ois.readObject();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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

}

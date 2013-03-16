package hu.miracle.workers;

public class Game {

	private Scene scene;
	private Timer timer;

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

}

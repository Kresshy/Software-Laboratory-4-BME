package hu.miracle.workers;

public class Game {

	// Members
	private Scene scene;
	private Timer timer;

	// Public interface
	public Scene getScene() {
		System.out.println(getClass().getCanonicalName() + ".getScene()");
		return scene;
	}

	public Timer getTimer() {
		System.out.println(getClass().getCanonicalName() + ".getTimer()");
		return timer;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

}

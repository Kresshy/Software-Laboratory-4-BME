package hu.miracle.workers;

public class Game {
	
	private static final String className = "Game";
	
	// Members
    private Scene scene;
    private Timer timer;

    // Public interface
    public Scene getScene() {
    	System.out.println(className + " getScene");
		return scene;
	}
    public Timer getTimer() {
    	System.out.println(className + " getTimer");
		return timer;
	}
}

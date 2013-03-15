package hu.miracle.workers;

public class Main {

	private static final String className = "Main";

	private static Game game;
	private static Scene scene;
	private static Timer timer;

	public static void main(String[] args) {
		System.out.println(className + " main");
		
		game = new Game();
		
		scene = new Scene();
		timer = new Timer(game);
		timer.start();
		
		game.setScene(scene);
		game.setTimer(timer);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.stopTimer();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.startTimer();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.exit(0);
		
	}
}

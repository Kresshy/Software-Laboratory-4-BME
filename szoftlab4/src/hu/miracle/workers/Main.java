package hu.miracle.workers;


public class Main {

	public static void main(String[] args) {
		CallLogger.getLogger().disable();

		// Inicializálás
		Scene scene = new Scene();
		Timer timer = new Timer(1);
		Game game = new Game(scene, timer);
		CommandParser parser = new CommandParser(game);

		// Időzítő indítása
		Thread timerThread = new Thread(timer);
		timerThread.start();

		while (parser.readAndRun()) {
		}
		
		timerThread.interrupt();
	}
}

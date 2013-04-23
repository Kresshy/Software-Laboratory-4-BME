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

		// Fejléc
		System.out.println("\nProto - MiracleWorkers (c) 2013\n"
				+ "-------------------------------\n" + "Irja be a parancsokat:\n\n");

		while (parser.readAndRun()) {
		}

		timerThread.interrupt();

		System.out.println();
	}
}

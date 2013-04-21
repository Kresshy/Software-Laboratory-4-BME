package hu.miracle.workers;

public class Timer implements Runnable{

	private int interval;
	private Game game;
	private boolean suspended;

	public Timer(int interval) {
		this.interval = interval;
		this.suspended = true;
	}
	
	@Override
	public void run() {
		try {

			while (true) {
				synchronized (this) {
					while (suspended) {
						System.out.println("stop");
						wait();
					}
				}
				Thread.sleep(interval);
				tick();
			}

		} catch (InterruptedException e) {
			System.out.println("Timer Interrupted");
		}
	}

	public Game getGame() {
		CallLogger.getLogger().entering(this, "getGame");

		CallLogger.getLogger().exiting();

		// Játék visszaadása
		return game;
	}

	public int getInterval() {
		CallLogger.getLogger().entering(this, "getInterval");

		CallLogger.getLogger().exiting();

		// Intervallum visszaadása
		return interval;
	}

	public void setGame(Game game) {
		CallLogger.getLogger().entering(this, "setGame");

		// Játék beállítása
		this.game = game;

		CallLogger.getLogger().exiting();
	}

	public void setInterval(int interval) {
		CallLogger.getLogger().entering(this, "setInterval");

		// Intervallum beállítása
		this.interval = interval;

		CallLogger.getLogger().exiting();
	}

	synchronized public void start() {
		CallLogger.getLogger().entering(this, "start");

		// Ha van játék ahova a tick-eket továbbítsuk
		if (game != null) {
			// Engedélyezés
			suspended = false;
			notify();
		}

		CallLogger.getLogger().exiting();
	}

	synchronized public void stop() {
		CallLogger.getLogger().entering(this, "stop");

		// Letiltás
		suspended = true;
		CallLogger.getLogger().exiting();
	}

	protected void tick() {
		CallLogger.getLogger().entering(this, "tick");

		// Tick delegálása
		game.getScene().delegateTick();
		System.out.println("tick");

		CallLogger.getLogger().exiting();
	}

}

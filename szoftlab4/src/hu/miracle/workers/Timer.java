package hu.miracle.workers;

public class Timer {

	private int interval;
	private Game game;
	private boolean enabled;

	public Timer(int interval) {
		this.interval = interval;
		this.enabled = true;
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
			enabled = true;
		}

		CallLogger.getLogger().exiting();
	}

	synchronized public void stop() {
		CallLogger.getLogger().entering(this, "stop");

		// Letiltás
		enabled = false;

		CallLogger.getLogger().exiting();
	}

	protected void tick() {
		CallLogger.getLogger().entering(this, "tick");

		// Tick delegálása
		game.getScene().delegateTick();

		CallLogger.getLogger().exiting();
	}
}

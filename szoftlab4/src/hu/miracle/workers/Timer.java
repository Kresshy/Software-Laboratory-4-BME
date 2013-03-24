package hu.miracle.workers;

public class Timer {

	private int interval;
	private Game game;
	private boolean enabled;

	public Timer(int interval) {
		this.interval = interval;
		this.enabled = true;
	}

	protected void tick() {
		CallLogger.getLogger().entering(this, "tick");

		game.getScene().delegateTick();

		CallLogger.getLogger().exiting();
	}

	public int getInterval() {
		CallLogger.getLogger().entering(this, "getInterval");

		CallLogger.getLogger().exiting();

		return interval;
	}

	synchronized public void start() {
		CallLogger.getLogger().entering(this, "start");

		if (game != null) {
			enabled = true;
			notify();
		}

		CallLogger.getLogger().exiting();
	}

	synchronized public void stop() {
		CallLogger.getLogger().entering(this, "stop");

		enabled = false;

		CallLogger.getLogger().exiting();
	}

	public Game getGame() {
		CallLogger.getLogger().entering(this, "getGame");

		CallLogger.getLogger().exiting();

		return game;
	}

	public void setGame(Game game) {
		CallLogger.getLogger().entering(this, "setGame");

		CallLogger.getLogger().exiting();

		this.game = game;
	}

	public void setInterval(int interval) {
		CallLogger.getLogger().entering(this, "setInterval");

		this.interval = interval;

		CallLogger.getLogger().exiting();
	}
}

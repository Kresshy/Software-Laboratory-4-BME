package hu.miracleworkers.controller;

public class Timer implements Runnable {

	private int		interval;
	private Game	game;
	private boolean	enabled;

	public Timer(int interval) {
		this.interval = interval;
		this.enabled = false;
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (this) {
					while (!enabled) {
						wait();
					}
				}
				tick();
				Thread.sleep(interval * 1000);
			}
		} catch (InterruptedException e) {
		}
	}

	public Game getGame() {

		// Játék visszaadása
		return game;
	}

	public int getInterval() {

		// Intervallum visszaadása
		return interval;
	}

	public void setGame(Game game) {

		// Játék beállítása
		this.game = game;

	}

	public void setInterval(int interval) {

		// Intervallum beállítása
		this.interval = interval;

	}

	synchronized public void start() {

		// Ha van játék ahova a tick-eket továbbítsuk
		if (game != null) {
			// Engedélyezés
			enabled = true;
			notify();
		}

	}

	synchronized public void stop() {

		// Letiltás
		enabled = false;

	}

	protected void tick() {

		// FIXME: Kimenet eltávolítása
		System.out.println("-------------------- Tick --------------------");
		// Tick delegálása
		game.getScene().delegateTick();

	}

}

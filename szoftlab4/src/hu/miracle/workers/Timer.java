package hu.miracle.workers;

public class Timer extends Thread {

	private static final String className = "Timer";

	// Members
	private int interval;
	private Game game;
	private boolean suspended;
	
	public Timer(Game game) {
		this.game = game;
		this.interval = 1000;
		this.suspended = false;
	}

	@Override
	public void run() {
		try {
			
			while (true) {
				sleep(interval);
				tick();
				synchronized (this) {
					while(suspended){
						wait();
					}
				}
			}
			
		} catch (InterruptedException e) {
			System.out.println("Timer Interrupted");
		}
	}

	// Protected methods
	// Nem biztos hogy protected lesz, implementaciotol fugg
	protected void tick() {
		System.out.println(className + " tick");
		game.getScene().delegateTick();				// EZ IGY ITT ELEGGE KAKIS 
	}

	// Public interface
	public int getInterval() {
		System.out.println(className + "  getInterval");
		return interval;
	}

	synchronized public void startTimer() {
		System.out.println(className + " startTimer");
		suspended = false;
		notify();
	}

	public void stopTimer() {
		System.out.println(className + "  stopTimer");
		suspended = true;
	}

	public Game getGame() {
		System.out.println(className + " getGame");
		return game;
	}

	public void setGame(Game game) {
		System.out.println(className + " setGame");
		this.game = game;
	}

	public void setInterval(int interval) {
		System.out.println(className + " setInterval");
		this.interval = interval;
	}
}

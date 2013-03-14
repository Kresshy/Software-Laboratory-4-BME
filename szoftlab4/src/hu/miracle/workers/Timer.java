package hu.miracle.workers;

public class Timer {

	private static final String className = "Timer";

	// Members
	private int interval;
	private Game game;

	// Protected methods
	// Nem biztos hogy protected lesz, implementációtól függ
	protected void tick() {
		System.out.println(className + " tick");
	} 

	// Public interface
	public void getInterval() {
		System.out.println(className + "  getInterval");
		
	}

	public void setInterval() {
		System.out.println(className + " setInterval");
	}

	public void startTimer() {
		System.out.println(className + " startTimer");
	}

	public void stopTimer() {
		System.out.println(className + "  stopTimer");
	}
}

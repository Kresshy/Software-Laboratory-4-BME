package miracle.workers.szoftlab4;

public class Timer {
	// Members
    private int interval;
    private Game game;

    // Protected methods
    protected void tick() {} // Nem biztos hogy protected lesz, implement�ci�t�l f�gg

    // Public interface
    public void getInterval() {}
    public void setInterval() {}
    public void startTimer() {}
    public void stopTimer() {}
}

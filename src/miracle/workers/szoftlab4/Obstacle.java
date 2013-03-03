package miracle.workers.szoftlab4;

public class Obstacle extends BaseObject {

	// Members
    protected boolean solid;

    // Constructor
    public Obstacle() {}

    // Public interface
    public boolean isSolid() {
		return solid;}
    public void interact() {}
	
	@Override
	public void handleTick() {
		// TODO Auto-generated method stub

	}

}

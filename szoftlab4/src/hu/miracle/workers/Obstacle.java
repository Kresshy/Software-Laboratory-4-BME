package hu.miracle.workers;

import java.awt.Color;
import java.awt.Point;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "obstacle")
public class Obstacle extends BaseObject {

	protected boolean solid;
	
	public Obstacle() {
		
	}

	public Obstacle(Point position, Color color, int radius, boolean solid) {
		super(position, color, radius);
		this.solid = solid;
	}

	public boolean isSolid() {
		CallLogger.getLogger().entering(this, "isSolid");

		CallLogger.getLogger().exiting();

		// Tömörség visszaadása
		return solid;
	}

	public boolean isDebris() {
		CallLogger.getLogger().entering(this, "isDebris");

		CallLogger.getLogger().exiting();

		// Eltávolíthatóság visszaadása
		return false;
	}

	public void handleTick() {
		CallLogger.getLogger().entering(this, "handleTick");
		
		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

	public void interact(Creature creature) {
		CallLogger.getLogger().entering(this, "interact");
		
		// Dummy default implementáció

		CallLogger.getLogger().exiting();
	}

}

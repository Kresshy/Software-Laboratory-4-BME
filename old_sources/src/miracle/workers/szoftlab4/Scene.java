package miracle.workers.szoftlab4;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.Map;

public class Scene {
	// Members
    private Dimension dimension;
    private List<Ant> ants;
    private List<Storage> storages;
    private List<Obstacle> obstacles;
    private List<Creature> creatures;
    private Map<Point, Effect> effects; // Ez elvileg nem lista lesz, de még nem tudom megmondani hogy mi

    // Protected methods
    protected void clearDebris() {} // Eltávolítja a szemetet a pályáról (lejárt akadályok és effektek)

    // Public interface
    public Dimension getDimension() {
		return dimension;
	}
    public List<Ant> getAnts() {
		return ants;
	}
    public List<Storage> getStorages() {
		return storages;
	}
    public List<Obstacle> getObstacles() {
		return obstacles;
	}
    public List<Creature> getCreatures() {
		return creatures;
	}
    public Map<Point, Effect> discoverEffects(Point point) {
		return effects;
	}
    public List<Obstacle> discoverObstacles(Point point) { // Egy pont környéki akadályokat adja vissza, a hangya útvonaltervezéséhez és a mérgezéshez kell
		return obstacles;
	}
    public void placeEffect(Point point, Effect effect) {} // Új effektet tárol el, szagnyom letételéhez szükséges
    public void clearEffects(Point point) {} // Egy pont körzetében eltünteti az effekteket, szagtalanító sprayhez szüksége
    public void placeObstacle(Obstacle obstacle) {} // Új akadályt tárol el, méreg sprayhez szükséges
    public void buildScene(String settings) {} // Ez itt csak placeholder, fogalmam sincs hogyan tároljuk a pályákat és milyen paraméterekre lesz szükség
    public void delegateTick() {}
}

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
    private Map<Point, Effect> effects; // Ez elvileg nem lista lesz, de m�g nem tudom megmondani hogy mi

    // Protected methods
    protected void clearDebris() {} // Elt�vol�tja a szemetet a p�ly�r�l (lej�rt akad�lyok �s effektek)

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
    public List<Obstacle> discoverObstacles(Point point) { // Egy pont k�rny�ki akad�lyokat adja vissza, a hangya �tvonaltervez�s�hez �s a m�rgez�shez kell
		return obstacles;
	}
    public void placeEffect(Point point, Effect effect) {} // �j effektet t�rol el, szagnyom let�tel�hez sz�ks�ges
    public void clearEffects(Point point) {} // Egy pont k�rzet�ben elt�nteti az effekteket, szagtalan�t� sprayhez sz�ks�ge
    public void placeObstacle(Obstacle obstacle) {} // �j akad�lyt t�rol el, m�reg sprayhez sz�ks�ges
    public void buildScene(String settings) {} // Ez itt csak placeholder, fogalmam sincs hogyan t�roljuk a p�ly�kat �s milyen param�terekre lesz sz�ks�g
    public void delegateTick() {}
}

package miracle.workers.szoftlab4;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

public class Scene {
	 // Members
    private Dimension dimension;
    private List<Ant> ants;
    private List<Storage> storages;
    private List<Obstacle> obstacles;
    private List<Creature> creatures;
    private List<Effect> effects; // Ez elvileg nem lista lesz, de még nem tudom megmondani hogy mi

    // Public interface
    public Dimension getDimension() {
		return dimension;}
    public List<Ant> getAnts() {
		return ants;}
    public List<Storage> getStorages() {
		return storages;}
    public List<Obstacle> getObstacles() {
		return obstacles;}
    public List<Creature> getCreatures() {
		return creatures;}
    public List<Effect> discoverNeighborhood(Point point) {
		return effects;}
    public boolean checkForObstacles(Point point) {
		return false;}
    public void placeEffect(Effect effect) {}
    public void buildScene(String settings) {} // Ez itt csak placeholder, fogalmam sincs hogyan tároljuk a pályákat és milyen paraméterekre lesz szükség
    public void delegateTick() {}

}

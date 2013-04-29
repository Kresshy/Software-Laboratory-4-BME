/*
 * Osztálydiagram változások
 */

public class ObjectPainter {
    // Members
    private Game game;
    private Graphics graphics;

    // Contructor
    public ObjectPainter(Game game, Graphics graphics);

    // Protected methods
    protected void paintImage(Point position, String imageFile, int radius);

    // Public interface
    public Graphics getGraphics();
    public void setGraphics(Graphics graphics);
    public void paintObjects();
}

public abstract class BaseObject {

    // Members
    // ...
    private String image; // A color helyett jön be, azt vegyétek ki

    // Public interface
    // ...
    public String getImage();

}

public class Game {

    // Members
    // ...
    private ObjectPainter painter;

    // Constuctor
    public Game(Scene scene, Timer timer, ObjectPainter painter);

    // Public interface
    // ...
    public ObjectPainter getPainter();
    public void setPainter(ObjectPainter painter);
}

/*
 * Szekvenciák
 */

Timer.tick() {
    // ...
    game.getPainter().paintObjects();
}

ObjectPainter.paintObjects() {
    // Inicializálás
    Scene scene = game.getScene();
    List<BaseObject> objects = new ArrayList<BaseObject>();
    // Objektumok összegyűjtése
    objects.addAll(scene.getStorages());
    objects.addAll(scene.getObstacles());
    objects.addAll(scene.getCreatures());
    objects.addAll(scene.getAnts());
    // Kirajzolás
    // Megj.: A fájlnevet majd a BaseObject-től kérjük el
    for (BaseObject obj : objects)
        paintImage(obj.getPosition(), obj.getImage(), obj.getRadius())
    // Maradék nem BaseObject kirajzolása
    for (Entry<Point, Effect> entry : scene.getEffects())
        // Kirajzolás
    // ...
}

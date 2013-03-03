/* Log:
 *  - Gazsi: 5+ óra
 */

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Canvas;

// Game

public class Game {
    // Members
    private Scene scene;
    private Timer timer;

    // Public interface
    public Scene getScene() {}
    public Timer getTimer() {}
}

// Scene

public class Scene {
    // Members
    private Dimension dimension;
    private List<Ant> ants;
    private List<Storage> storages;
    private List<Obstacle> obstacles;
    private List<Creature> creatures;
    private Map<Point, Effect> effects; // Ez elvileg nem lista lesz, de még nem tudom megmondani hogy mi

    // Public interface
    public Dimension getDimension() {}
    public List<Ant> getAnts() {}
    public List<Storage> getStorages() {}
    public List<Obstacle> getObstacles() {}
    public List<Creature> getCreatures() {}
    public Map<Point, Effect> discoverEffects(Point point) {}
    public List<Obstacle> discoverObstacles(Point point) {} // Egy pont környéki akadályokat adja vissza, a hangya útvonaltervezéséhez és a mérgezéshez kell
    public void placeEffect(Point point, Effect effect) {} // Új effektet tárol el, szagnyom letételéhez szükséges
    public void clearEffects(Point point) {} // Egy pont körzetében eltünteti az effekteket, szagtalanító sprayhez szüksége
    public void placeObstacle(Obstacle obstacle) {} // Új akadályt tárol el, méreg sprayhez szükséges
    public void buildScene(String settings) {} // Ez itt csak placeholder, fogalmam sincs hogyan tároljuk a pályákat és milyen paraméterekre lesz szükség
    public void delegateTick() {}
}

// Timer

public class Timer {
    // Members
    private int interval;
    private Game game;

    // Protected methods
    protected void tick() {} // Nem biztos hogy protected lesz, implementációtól függ

    // Public interface
    public void getInterval() {}
    public void setInterval() {}
    public void startTimer() {}
    public void stopTimer() {}
}

// BaseObject

public abstract class BaseObject {
    // Members
    protected int radius;
    protected Point position;
    protected Color color;

    // Abstract methods
    public abstract void handleTick();

    // Public interface
    public int getRadius() {}
    public void setRadius(int radius) {}
    public Point getPosition() {}
    public void setPosition(Point position) {}
    public Color getColor() {}
    public void setColor(Color color) {}
    public boolean pointInRange(Point point) {} // Megmondja, hogy egy pont az objektum sugarában van-e
    public void drawObject(Canvas canvas) {} // Kirajzoláshoz szükséges
}

// Storage and descendants

public abstract class Storage extends BaseObject {
    // Members
    protected int amount; // Tárolt elemek
    protected int capacity; // Tárolt elemek maximális száma

    // Abstract methods
    public int getItems() {} // Tárolóból elemeket vesz ki, ételfelvételhez szükséges
    public void putItems(int count) {} // Tárolóba elemeket tesz vissza, étel visszatételéhez és hangyák újjáéledéséhez szükséges
}

public class FoodStorage extends Storage {
    // Constructor
    public FoodStorage() {}

    // Public interface
    public void handleTick() {}
    public int getItems() {} // Ételfelvétel
    public void putItems(int count) {} // Ételvisszarakás
}

public class AntHill extends Storage {
    // Members
    private Scene scene; // Szükséges hogy a hangyák ismerhessék a scene-t

    // Constructor
    public AntHill() {}

    // Protected methods
    protected int getItems() {} // Remélem lehet így kitakarni

    // Public interface
    public void handleTick() {}
    public void putItems(int count) {} // Hangyák halálakor, hogy újabb hangya szülessen
}

// Obstacle and descendants

public class Obstacle extends BaseObject {
    // Members
    protected boolean solid; // Tömörség/áthatolhatatlanság

    // Constructor
    public Obstacle() {}

    // Public interface
    public boolean isSolid() {}
    public void handleTick() {}
    public void interact(Creature creature) {} // Interakció, pl mérgezéskor és hangyaleső táplálkozásakor
}

public class AntSinker extends Obstacle {
    // Public interface
    public void interact(Creature creature) {} // Override
}

public class Poison extends Obstacle {
    private int timeout;
    // Public interface
    public void handleTick() {}
    public void interact(Creature creature) {} // Override
}

// Creature and descendants

public abstract class Creature extends BaseObject {
    // Members
    protected Scene scene;

    // Public interface
    public void setScene(Scene scene) {}
    public void terminate() {}
}

public class Ant extends Creature {
    // Members
    private Storage home;
    private Storage source;
    private boolean poisoned;
    private int health;
    private int cargo;

    // Constructor
    public Ant() {}

    // Protected methods
    protected void routeAndMove() {}

    // Public interface
    public void setSource(Storage storage) {} // Ételfelvételkor használva, hogy tudja hova kell visszavinni halál esetén
    public void handleTick() {}
    public void terminate() {} // Override
}

public class AntEater extends Creature {
    // Members
    private boolean visible; // Jelen van-e
    private int hunger;
    private int wait;

    // Constructor
    public AntEater() {}

    // Public interface
    public boolean isVisible() {}
    public void handleTick() {}
}

// Effect and descendants

public abstract class Effect {
    // Members
    protected int timeout;
    protected boolean attractive;

    // Abstract methods
    public abstract void interact(Creature creature); // Nem tudom szükség van-e rá

    // Public interface
    public void handleTick() {}
}

public class Pheromone extends Effect {
    // Public interface
    public void interact(Creature creature) {} // Nem tudom szükség van-e rá
}

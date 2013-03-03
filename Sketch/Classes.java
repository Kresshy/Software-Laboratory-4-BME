/* Log:
 *  - Gazsi: 3-3,5 óra
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
    private List<Effect> effects; // Ez elvileg nem lista lesz, de még nem tudom megmondani hogy mi

    // Public interface
    public Dimension getDimension() {}
    public List<Ant> getAnts() {}
    public List<Storage> getStorages() {}
    public List<Obstacle> getObstacles() {}
    public List<Creature> getCreatures() {}
    public List<Effect> discoverNeighborhood(Point p) {}
    public boolean checkForObstacles(Point p) {}
    public void placeEffect(Effect e) {}
    public void buildScene(String settings) {}
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
    public void drawObject(Canvas canvas) {}
}

// Storage and descendants

public abstract class Storage extends BaseObject {
    // Members
    protected int amount;
    protected int capacity;
}

public class FoodStorage extends Storage {
    // Constructor
    public FoodStorage() {}

    // Public interface
    public void handleTick() {}
    public int getFood() {}
}

public class AntHill extends Storage {
    // Members
    private Scene scene;

    // Constructor
    public AntHill() {}

    // Protected methods
    protected void spawnAnts() {}

    // Public interface
    public void handleTick() {}
    public void replaceAnt() {}
}

// Obstacle and descendants

public class Obstacle extends BaseObject {
    // Members
    protected boolean solid;

    // Constructor
    public Obstacle() {}

    // Public interface
    public boolean isSolid() {}
    public void handleTick() {}
    public void interact() {}
}

public class AntSinker extends Obstacle {
    // Public interface
    public void interact() {}
}

// Creature and descendants

public abstract class Creature extends BaseObject {
    // Members
    protected Scene scene;

    // Public interface
    public void setScene(Scene scene) {}
}

public class Ant extends Creature {
    // Members
    private AntHill home;
    private FoodStorage source;
    private boolean poisoned;
    private boolean cargo;
    private int health;

    // Constructor
    public Ant() {}

    // Public interface
    public void setSource(FoodStorage source) {}
    public void handleTick() {}
    public void terminateAnt() {}
}

public class AntEater extends Creature {
    // Members
    public boolean visible;
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
}

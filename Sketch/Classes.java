import java.awt.Point;
import java.awt.Color;
import java.awt.Canvas;

// Game

public class Game {

}

// Scene

public class Scene {

}

// Timer

public class Timer {

}

// BaseObject

public abstract class BaseObject {
    // Members
    private int radius;
    private Point position;
    private Color color;

    // Abstract methods
    public void handleTick();

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
    private int amount;
    private int capacity;
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
    private boolean solid;

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
    private Scene scene;

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

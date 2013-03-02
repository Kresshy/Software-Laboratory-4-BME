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
    boolean solid;

    // Public interface
    public void handleTick() {}
    public void interact() {}
}

public class AntSinker extends Obstacle {

}

// Creature and descendants

public abstract class Creature extends BaseObject {

}

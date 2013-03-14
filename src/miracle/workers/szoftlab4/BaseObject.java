package miracle.workers.szoftlab4;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;

public abstract class BaseObject {
	// Members
    protected int radius;
    protected Point position;
    protected Color color;

    // Abstract methods
    public abstract void handleTick();

    // Public interface
    public int getRadius() {
		return radius;
	}
    public void setRadius(int radius) {}
    public Point getPosition() {
		return position;
	}
    public void setPosition(Point position) {}
    public Color getColor() {
		return color;
	}
    public void setColor(Color color) {}
    public boolean pointInRange(Point point) { // Megmondja, hogy egy pont az objektum sugarában van-e !!!!!!!!!!!!!!!
		return false;
	}
    public void drawObject(Canvas canvas) {} // Kirajzoláshoz szükséges
}

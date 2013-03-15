package hu.miracle.workers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.util.Collections;
import java.util.List;

public abstract class BaseObject {

	private static String className = "BaseObject";

	// Members
	protected int radius;
	protected Point position;
	protected Color color;

	// Abstract methods
	public abstract void handleTick();

	// Public interface
	public int getRadius() {
		System.out.println(className + " getRadius");
		return radius;
	}

	public void setRadius(int radius) {
		System.out.println(className + " setRadius");
	}

	public Point getPosition() {
		System.out.println(className + " getPosition");
		return position;
	}

	public void setPosition(Point position) {
		System.out.println(className + " setPosition");
	}

	public Color getColor() {
		System.out.println(className + " getColor");
		return color;
	}

	public void setColor(Color color) {
		System.out.println(className + " setColor");
	}

	// Megmondja, hogy egy pont az objektum sugaraban van-e !!!!!!!!!
	// Itt kotekedett, hogy ne booleant adjunk vissza, hanem a sugaraban levo
	// objektumokat
	public List pointInRange(Point point) {
		System.out.println(className + " pointInRange");

		return Collections.EMPTY_LIST;
	}

	// Kirajzolashoz szukseges
	public void drawObject(Canvas canvas) {
		System.out.println(className + " drawObject");

	}
}

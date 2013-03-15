package hu.miracle.workers;

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
		System.out.println(getClass().getCanonicalName() + ".getRadius()");
		return radius;
	}

	public void setRadius(int radius) {
		System.out.println(getClass().getCanonicalName() + ".setRadius()");
	}

	public Point getPosition() {
		System.out.println(getClass().getCanonicalName() + ".getPosition()");
		return position;
	}

	public void setPosition(Point position) {
		System.out.println(getClass().getCanonicalName() + ".setPosition()");
	}

	public Color getColor() {
		System.out.println(getClass().getCanonicalName() + ".getColor()");
		return color;
	}

	public void setColor(Color color) {
		System.out.println(getClass().getCanonicalName() + ".setColor()");
	}

	// Megmondja, hogy egy pont az objektum sugaraban van-e
	public boolean pointInRange(Point point) {
		System.out.println(getClass().getCanonicalName() + ".pointInRange()");
		return false;
	}

	// Kirajzolashoz szukseges
	public void drawObject(Canvas canvas) {
		System.out.println(getClass().getCanonicalName() + ".drawObject()");
	}

}

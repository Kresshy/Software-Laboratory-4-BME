package hu.miracle.workers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;

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

	public boolean pointInRange(Point point) { 				// Megmondja, hogy egy pont az
		System.out.println(className + " pointInRange"); 	// objektum sugarában
															// van-e
		// !!!!!!!!!!!!!!!
		return false;
	}

	public void drawObject(Canvas canvas) {
		System.out.println(className + " drawObject");
		
	} // Kirajzoláshoz szükséges
}

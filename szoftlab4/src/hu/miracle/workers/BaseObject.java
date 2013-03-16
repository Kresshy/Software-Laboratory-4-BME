package hu.miracle.workers;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;

public abstract class BaseObject {

	protected int radius;
	protected Point position;
	protected Color color;

	public BaseObject(Point position, Color color, int radius) {
		this.position = position;
		this.color = color;
		this.radius = radius;
	}

	public void drawObject(Canvas canvas) {
		System.out.println(getClass().getCanonicalName() + ".drawObject()");

		// TODO: Algoritmus kidolgozása
	}

	public Color getColor() {
		System.out.println(getClass().getCanonicalName() + ".getColor()");

		// Szín visszaadása
		return color;
	}

	public Point getPosition() {
		System.out.println(getClass().getCanonicalName() + ".getPosition()");

		// Pozíció visszaadása
		return position;
	}

	// Public interface
	public int getRadius() {
		System.out.println(getClass().getCanonicalName() + ".getRadius()");

		// Sugár visszaadása
		return radius;
	}

	public abstract void handleTick();

	public boolean pointInRange(Point point) {
		System.out.println(getClass().getCanonicalName() + ".pointInRange()");

		// A pont az objektum hatókörében van-e
		// TODO: Hatókör meghatározása
		return (getPosition().distance(point) < radius);
	}

	public void setColor(Color color) {
		System.out.println(getClass().getCanonicalName() + ".setColor()");

		// Szín beállítása
		this.color = color;
	}

	public void setPosition(Point position) {
		System.out.println(getClass().getCanonicalName() + ".setPosition()");

		// Pozíció beállítása
		this.position = position;
	}

	public void setRadius(int radius) {
		System.out.println(getClass().getCanonicalName() + ".setRadius()");

		// Sugár beállítása
		this.radius = radius;
	}

}

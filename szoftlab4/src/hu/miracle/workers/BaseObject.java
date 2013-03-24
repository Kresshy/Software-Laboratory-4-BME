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
		CallLogger.getLogger().entering(this, "drawObject");

		// TODO: Algoritmus kidolgozása

		CallLogger.getLogger().exiting();
	}

	public Color getColor() {
		CallLogger.getLogger().entering(this, "getColor");

		CallLogger.getLogger().exiting();

		// Szín visszaadása
		return color;
	}

	public Point getPosition() {
		CallLogger.getLogger().entering(this, "getPosition");

		CallLogger.getLogger().exiting();

		// Pozíció visszaadása
		return position;
	}

	// Public interface
	public int getRadius() {
		CallLogger.getLogger().entering(this, "getRadius");

		CallLogger.getLogger().exiting();

		// Sugár visszaadása
		return radius;
	}

	public abstract void handleTick();

	public boolean pointInRange(Point point) {
		CallLogger.getLogger().entering(this, "pointInRange");

		double distance = getPosition().distance(point);

		CallLogger.getLogger().exiting();

		// A pont az objektum hatókörében van-e
		// TODO: Hatókör meghatározása
		return (distance < radius);
	}

	public void setColor(Color color) {
		CallLogger.getLogger().entering(this, "setColor");

		// Szín beállítása
		this.color = color;

		CallLogger.getLogger().exiting();
	}

	public void setPosition(Point position) {
		CallLogger.getLogger().entering(this, "setPosition");

		// Pozíció beállítása
		this.position = position;

		CallLogger.getLogger().exiting();
	}

	public void setRadius(int radius) {
		CallLogger.getLogger().entering(this, "setRadius");

		// Sugár beállítása
		this.radius = radius;

		CallLogger.getLogger().exiting();
	}

}

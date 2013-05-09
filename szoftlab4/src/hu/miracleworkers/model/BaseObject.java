package hu.miracleworkers.model;

import java.awt.Canvas;
import java.awt.Color;

public abstract class BaseObject {

	protected int	radius;
	protected Point	position;
	protected Color	color;

	public BaseObject(Point position, Color color, int radius) {
		this.position = position;
		this.color = color;
		this.radius = radius;
	}

	public void drawObject(Canvas canvas) {

		// TODO: Algoritmus kidolgozása

	}

	public Color getColor() {

		// Szín visszaadása
		return color;
	}

	public Point getPosition() {

		// Pozíció visszaadása
		return position;
	}

	public int getRadius() {

		// Sugár visszaadása
		return radius;
	}

	public abstract void handleTick();

	public boolean pointInRange(Point point) {

		// Távolság kiszámítása
		double distance = getPosition().distance(point);

		// A pont az objektum hatókörében van-e
		// TODO: Hatókör meghatározása
		return (distance <= radius);
	}

	public void setColor(Color color) {

		// Szín beállítása
		this.color = color;

	}

	public void setPosition(Point position) {

		// Pozíció beállítása
		this.position = position;

	}

	public void setRadius(int radius) {

		// Sugár beállítása
		this.radius = radius;

	}

}

package hu.miracleworkers.model;

public abstract class BaseObject {

	protected int	radius;
	protected Point	position;

	public BaseObject(Point position, int radius) {
		this.position = position;
		this.radius = radius;
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

	public void setPosition(Point position) {

		// Pozíció beállítása
		this.position = position;

	}

	public void setRadius(int radius) {

		// Sugár beállítása
		this.radius = radius;

	}

}

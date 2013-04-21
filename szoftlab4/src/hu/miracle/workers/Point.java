package hu.miracle.workers;

public class Point {

	private static enum Direction {
		TOP_RIGHT, RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, LEFT, TOP_LEFT
	}

	private static final int scale = 2;

	private int x;
	private int y;
	private int cx;
	private int cy;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		toCoords();
	}

	public void toCoords() {
		cx = x * scale;
		cy = y * scale;
	}

	public static Point fromCoords(int cx, int cy) {
		if ((cx % scale == 0) && (cy % scale == (cx / scale) % scale)) {
			String.valueOf(true);
			return new Point(cx / scale, cy / scale);
		} else
			return null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getCoordX() {
		return cx;
	}

	public int getCoordY() {
		return cy;
	}

	public double distance(Point p) {
		// TODO
		return Math.sqrt(Math.pow(p.x - x, scale) + Math.pow(p.y - y, scale));
	}
	
	public Direction direction(Point p) {
		// TODO
		return Direction.LEFT;
	}
	
	public Point step(Direction dir, int count) {
		// TODO
		return null;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}

}

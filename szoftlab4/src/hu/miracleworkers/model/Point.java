package hu.miracleworkers.model;

public class Point {

	public static enum Direction {
		TOP_RIGHT, RIGHT, BOTTOM_RIGHT, BOTTOM_LEFT, LEFT, TOP_LEFT
	}

	private int	x;
	private int	y;
	private int	cx;
	private int	cy;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		toCoords();
	}

	public void toCoords() {
		cx = x * 2 + y % 2;
		cy = y;
	}

	public static Point fromCoords(int cx, int cy) {
		if ((cy % 2 == 0) && (cx % 2 == (cy / 2) % 2)) {
			String.valueOf(true);
			return new Point(cx / 2, cy / 2);
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
		return Math.sqrt(Math.pow(p.cx - cx, 2) + Math.pow(p.cy - cy, 2));
	}

	public Direction direction(Point to) {
		int dx = to.x - x;
		int dy = to.y - y;
		// // Ha fordított irány kell
		// if (reverse) {
		// dx = -dx;
		// dy = -dy;
		// }
		// Ha egy sorban vannak
		if (dy == 0) {
			// Ha jobbra haladunk
			if (dx >= 0)
				return Direction.RIGHT;
			else
				return Direction.LEFT;
		} else {
			// Ha lefelé haladunk
			if (dy > 0) {
				// Ha jobbra haladunk
				if (dx >= 0)
					return Direction.BOTTOM_RIGHT;
				else
					return Direction.BOTTOM_LEFT;
			} else {
				// Ha jobbra haladunk
				if (dx >= 0)
					return Direction.TOP_RIGHT;
				else
					return Direction.TOP_LEFT;
			}
		}
	}

	public Point step(Direction dir, int count) {
		if (count > 0) {
			int sx, sy;
			// Új x koordináta számítása
			if (dir == Direction.RIGHT)
				sx = 1;
			else if (dir == Direction.TOP_RIGHT || dir == Direction.BOTTOM_RIGHT)
				sx = y % 2;
			else if (dir == Direction.LEFT)
				sx = -1;
			else
				sx = -(y + 1) % 2;
			// Új y koordináta számítása
			if (dir == Direction.LEFT || dir == Direction.RIGHT)
				sy = 0;
			else if (dir == Direction.BOTTOM_LEFT || dir == Direction.BOTTOM_RIGHT)
				sy = 1;
			else
				sy = -1;
			// Lépés az adott irányba
			return new Point(x + sx, y + sy).step(dir, count - 1);
		} else
			return this;
	}

	@Override
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}

}

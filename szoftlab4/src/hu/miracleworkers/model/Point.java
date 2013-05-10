/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

/**
 * Pont osztály.
 */
public class Point {

	/**
	 * Irány enum.
	 */
	public static enum Direction {

		/** Jobbra fel. */
		TOP_RIGHT,
		/** Jobbra. */
		RIGHT,
		/** Jobbra le. */
		BOTTOM_RIGHT,
		/** Balra le. */
		BOTTOM_LEFT,
		/** Balra. */
		LEFT,
		/** Balra fel. */
		TOP_LEFT
	}

	/** X koordináta. */
	private int	x;

	/** Y koordináta. */
	private int	y;

	/** Valós X koordináta. */
	private int	cx;

	/** Valós Y koordináta. */
	private int	cy;

	/**
	 * Példányosít egy új pontot.
	 */
	public Point() {
	}

	/**
	 * Példányosít egy új pontot.
	 * 
	 * @param x az X koordináta
	 * @param y az Y koordináta
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		toCoords();
	}

	/**
	 * Saját koordináták valós koordinátákká számolása.
	 */
	public void toCoords() {
		cx = x * 2 + y % 2;
		cy = y;
	}

	/**
	 * Valós koordináták saját koordinátákká számolása.
	 * 
	 * @param cx a valós X koordináta
	 * @param cy a valós Y koordináta
	 * @return egy Pont példány, ha a valós koordináták egy érvényes pontot jelölnek, egyébként null
	 */
	public static Point fromCoords(int cx, int cy) {
		if ((cy % 2 == 0) && (cx % 2 == (cy / 2) % 2)) {
			return new Point(cx / 2, cy / 2);
		} else
			return null;
	}

	/**
	 * Lekérdezi az X koordinátát.
	 * 
	 * @return az X koordináta
	 */
	public int getX() {
		return x;
	}

	/**
	 * Lekérdezi az Y koordinátát.
	 * 
	 * @return az Y koordináta
	 */
	public int getY() {
		return y;
	}

	/**
	 * Lekérdezi a valós X koordinátát.
	 * 
	 * @return a valós X koordináta
	 */
	public int getCoordX() {
		return cx;
	}

	/**
	 * Lekérdezi a valós Y koordinátát.
	 * 
	 * @return a valós Y koordináta
	 */
	public int getCoordY() {
		return cy;
	}

	/**
	 * Távolságszámítás.
	 * 
	 * @param p a másik pont
	 * @return a két pont távolsága
	 */
	public double distance(Point p) {
		// TODO
		return Math.sqrt(Math.pow(p.cx - cx, 2) + Math.pow(p.cy - cy, 2));
	}

	/**
	 * Irányszámítás.
	 * 
	 * @param to a cél pont
	 * @return az aktuális pontból a cél pont felé mutató távolság
	 */
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

	/**
	 * Léptetés egy adott irányba.
	 * 
	 * @param dir az irány
	 * @param count a lépések száma
	 * @return a lépések után kapott Pont
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("(%d,%d)", x, y);
	}

}

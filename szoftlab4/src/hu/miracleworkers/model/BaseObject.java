/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import hu.miracleworkers.view.GraphicsBase;

/**
 * Pályaelemek ősosztálya.
 */
public abstract class BaseObject implements SceneObject {

	/** Pozíció. */
	protected Point	position;
	/** Hatókör. */
	protected int	radius;

	/**
	 * Példányosít egy új pályaelemet.
	 * 
	 * @param position a pályaelem pozíciója
	 * @param radius a pályaelem hatóköre
	 */
	public BaseObject(Point position, int radius) {
		this.position = position;
		this.radius = radius;
	}

	/**
	 * Lekérdezi a pályaelem grafikus példányát.
	 * 
	 * @return a pályaelem grafikus példánya
	 */
	public abstract GraphicsBase getGraphicsWrapper();

	/**
	 * Lekérdezi a pályaelem pozícióját.
	 * 
	 * @return a pályaelem pozíciója
	 */
	public Point getPosition() {

		// Pozíció visszaadása
		return position;
	}

	/**
	 * Lekérdezi a pályaelem hatókörét.
	 * 
	 * @return a pályaelem hatóköre
	 */
	public int getRadius() {

		// Sugár visszaadása
		return radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hu.miracleworkers.model.SceneObject#isDebris()
	 */
	@Override
	public boolean isDebris() {

		// Eltávolíthatóság visszaadása
		return false;
	}

	/**
	 * Hatókörbe tartozás ellenőrzése.
	 * 
	 * @param point az ellenőrizendő pont
	 * @return true, ha a pont a pályaelem hatókörében van
	 */
	public boolean pointInRange(Point point) {

		// Távolság kiszámítása
		double distance = getPosition().distance(point);

		// A pont az objektum hatókörében van-e
		// TODO: Hatókör meghatározása
		return (distance <= radius);
	}

	/**
	 * Beállítja a pályaelem pozícióját.
	 * 
	 * @param position a pályaelem új pozíciója
	 */
	public void setPosition(Point position) {

		// Pozíció beállítása
		this.position = position;

	}

	/**
	 * Beállítja a pályaelem hatókörét.
	 * 
	 * @param radius a pályaelem új hatóköre
	 */
	public void setRadius(int radius) {

		// Sugár beállítása
		this.radius = radius;

	}

}

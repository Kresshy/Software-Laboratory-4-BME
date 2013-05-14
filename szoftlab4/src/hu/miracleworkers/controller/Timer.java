/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

/**
 * Időzítő osztály.
 */
public class Timer implements Runnable {

	/** Óraütések között eltelt idő. */
	private int		interval;

	/** Játék */
	private Game	game;

	/** Engedélyezés. */
	private boolean	enabled;

	/**
	 * Példányosít egy új időzítőt.
	 * 
	 * @param interval az óraütések között eltelt idő másodpercben
	 */
	public Timer(int interval) {
		this.interval = interval;
		this.enabled = false;
	}

	/**
	 * Lekérdezi a játékot amihez az időzítő tartozik.
	 * 
	 * @return a játék amihez az időzítő tartozik
	 */
	public Game getGame() {

		// Játék visszaadása
		return game;
	}

	/**
	 * Lekérdezi az óraütések között eltelt időt.
	 * 
	 * @return az óraütések között eltelt idő másodpercben
	 */
	public int getInterval() {

		// Intervallum visszaadása
		return interval;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			while (true) {
				synchronized (this) {
					while (!enabled) {
						wait();
					}
				}
				tick();
				Thread.sleep(interval * 25);
			}
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Beállítja a játékot amihez az időzítő tartozik.
	 * 
	 * @param game az új játék amihez az időzítő tartozik
	 */
	public void setGame(Game game) {

		// Játék beállítása
		this.game = game;

	}

	/**
	 * Beállítja az óraütések között eltelt időt.
	 * 
	 * @param interval az óraütések között eltelt új idő másodpercben
	 */
	public void setInterval(int interval) {

		// Intervallum beállítása
		this.interval = interval;

	}

	/**
	 * Időzítő indítása.
	 */
	synchronized public void start() {

		// Ha van játék ahova a tick-eket továbbítsuk
		if (game != null) {
			// Engedélyezés
			enabled = true;
			notify();
		}

	}

	/**
	 * Időzítő megálítása.
	 */
	synchronized public void stop() {

		// Letiltás
		enabled = false;

	}

	/**
	 * Óraütés.
	 */
	protected void tick() {

		// Tick delegálása
		game.getScene().delegateTick();
		game.getPerspective().handleTick();
		game.handleTick();

	}
	
	// TODO változás a Timer implementációban DOKUMENTÁLNI!
	// vizsgálhatjuk hogy futásban van-e az óra
	public boolean isEnabled() {
		return enabled;
	}

}

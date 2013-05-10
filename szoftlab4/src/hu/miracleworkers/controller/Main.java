/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

import hu.miracleworkers.model.Scene;

/**
 * Main osztály.
 */
public class Main {

	/**
	 * A program belépési pontja.
	 * 
	 * @param args a parancssori argumentumok
	 */
	public static void main(String[] args) {

		// Inicializálás
		Scene scene = new Scene();
		Timer timer = new Timer(1);
		Game game = new Game(scene, timer);

		// Időzítő indítása
		Thread timerThread = new Thread(timer);
		timerThread.start();

		// Fejléc
		System.out.println("\nProto - MiracleWorkers (c) 2013\n"
				+ "-------------------------------\n" + "Irja be a parancsokat:\n\n");

		timerThread.interrupt();

		System.out.println();
	}
}

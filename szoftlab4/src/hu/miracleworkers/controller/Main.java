/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

import hu.miracleworkers.model.Scene;
import hu.miracleworkers.swing.ScenePanel;
import hu.miracleworkers.view.Perspective;

import javax.swing.JFrame;

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
		Perspective perspective = new Perspective();
		Timer timer = new Timer(1);
		Game game = new Game(scene, perspective, timer);

		// Időzítő indítása
		Thread timerThread = new Thread(timer);
		timerThread.start();

		JFrame frame = new JFrame("Ant Farm");
		frame.add(new ScenePanel(perspective));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Fejléc
		System.out.println("\nProto - MiracleWorkers (c) 2013\n"
				+ "-------------------------------\n" + "Irja be a parancsokat:\n\n");

		timerThread.interrupt();

		System.out.println();
	}
}

/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.controller;

import hu.miracleworkers.model.Scene;
import hu.miracleworkers.swing.GUI;
import hu.miracleworkers.swing.PerspectivePanel;
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
		XMLBuilder builder = new XMLBuilder();
		Scene scene = new Scene();

		try {

			scene = builder.readXML("test/test_graphics.xml");

		} catch (Exception e) {
		}

		Perspective perspective = new Perspective();
		Timer timer = new Timer(1);
		Game game = new Game(scene, perspective, timer);
		PerspectivePanel sPanel = new PerspectivePanel(perspective);
		// Időzítő indítása
		Thread timerThread = new Thread(timer);
		timerThread.start();
//		timer.start();

		GUI window = new GUI(perspective);
		window.setVisible(true);
		
		System.out.println();
	}
}

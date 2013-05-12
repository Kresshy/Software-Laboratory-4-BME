/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.view;

import hu.miracleworkers.controller.Game;
import hu.miracleworkers.model.BaseObject;
import hu.miracleworkers.model.Scene;
import hu.miracleworkers.swing.PerspectivePanel;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Nézet osztály.
 */
public class Perspective {

	/** Játék. */
	private Game				game;

	/** Effektek. */
	private GEffects			effects;

	/** Panel. */
	private PerspectivePanel	panel;

	/**
	 * Példányosít egy új nézetet.
	 * 
	 * @param game a játék amihez a nézet tartozik
	 */
	public Perspective() {
		this.effects = new GEffects();
	}

	/**
	 * Lekérdezi a játékot amihez a nézet tartozik.
	 * 
	 * @return a játék amihez a nézet tartozik
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Óraütés kezelése.
	 */
	public void handleTick() {
		this.effects.setEffects(game.getScene().getEffects());
		panel.repaint();
	}

	/**
	 * Pályaelemek kirajzolása.
	 * 
	 * @param graphics a kirajzoláshoz használt "vászon"
	 */
	public void paintObjects(Graphics graphics) {
		Scene scene = game.getScene();
		List<BaseObject> objects = new ArrayList<BaseObject>();

		// Tárolók és akadályok kirajzolása
		objects.addAll(scene.getStorages());
		objects.addAll(scene.getObstacles());
		for (BaseObject obj : objects) {
			obj.getGraphicsWrapper().paintObject(graphics);
		}

		// Effektek kirajzolása
		effects.paintObject(graphics);

		// Élőlények kirajzolása
		objects.clear();
		objects.addAll(scene.getCreatures());
		objects.addAll(scene.getAnts());
		for (BaseObject obj : objects) {
			obj.getGraphicsWrapper().paintObject(graphics);
		}
	}

	/**
	 * Beállítja a játékot amihez a nézet tartozik.
	 * 
	 * @param game az új játék amihez a nézet tartozik
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Beállítja a panelt amihez a nézet tartozik.
	 * 
	 * @param panel az új panel amihez a nézet tartozik
	 */
	public void setPanel(PerspectivePanel panel) {
		this.panel = panel;
	}

}

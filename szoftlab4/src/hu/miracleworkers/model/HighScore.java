/*
 * Szoftver labor 4 - Hangyafarm
 * 
 * Copyright (c) 2013 - Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs
 */
package hu.miracleworkers.model;

import java.io.Serializable;

/**
 * Rekord osztály.
 */
public class HighScore implements Comparable<HighScore>, Serializable {

	private static final long	serialVersionUID	= 4019851086530768705L;

	/** Elért eredmény. */
	public int					score;

	/** Felhasználó neve. */
	public String				name;

	/**
	 * Példányosít egy új rekordot.
	 * 
	 * @param name a felhasználó neve
	 * @param score az elért eredmény
	 */
	public HighScore(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(HighScore o) {
		if (score == o.score)
			return 0;
		else if (score > o.score)
			return 1;
		else
			return -1;
	}

}

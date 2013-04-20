package hu.miracle.workers;

public class HighScore implements Comparable<HighScore> {

	public int score;
	public String name;

	public HighScore(String name, int score) {
		this.name = name;
		this.score = score;
	}

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

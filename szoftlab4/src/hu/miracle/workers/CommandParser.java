package hu.miracle.workers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class CommandParser {

	private Game game;

	public CommandParser(Game game) {
		this.game = game;
	}

	public boolean readAndRun() {
		// Be- és kimenet inicializálása
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out, true);

		// Parancsbeolvasás
		String line = "";
		try {
			// out.print("> ");
			// out.flush();
			line = in.readLine();
			if (line == null)
				return false;
		} catch (IOException e) {
			// Sikertelen beolvasásnál kilépés
			return false;
		}

		// Parancs tokenekké alakítása
		String[] tokens = tokenize(line);
		String cmd = extractCommand(tokens);
		String[] args = extractArgs(tokens);

		// Parancsfuttatás
		if (cmd.equals("init"))
			init(args);
		else if (cmd.equals("status"))
			status(args);
		else if (cmd.equals("move"))
			move(args);
		else if (cmd.equals("status"))
			status(args);
		else if (cmd.equals("tick"))
			tick(args);
		else if (cmd.equals("poison"))
			poison(args);
		else if (cmd.equals("deodorize"))
			deodorize(args);
		else if (cmd.equals("start"))
			start(args);
		else if (cmd.equals("stop"))
			stop(args);
		else if (cmd.equals("toplist"))
			toplist(args);
		else if (cmd.equals("difficulty"))
			difficulty(args);
		else if (cmd.equals("exit"))
			return false;
		else if (cmd.length() > 0)
			out.println("Ervenytelen parancs!");

		return true;
	}

	public static String[] tokenize(String line) {
		// Bemenet takarítása, kisbetűssé alakítása és feldarabolása
		return line.trim().toLowerCase().split(" ");
	}

	public static String extractCommand(String[] tokens) {
		// Ha van elem a tömbben
		if (tokens.length > 0)
			// Első elem visszaadása
			return tokens[0];
		else
			// Üres parancs
			return "";
	}

	public static String[] extractArgs(String[] tokens) {
		// Ha van elem a tömbben
		if (tokens.length > 0)
			// Tokenek visszaadása az első elem kivételével
			return Arrays.copyOfRange(tokens, 1, tokens.length);
		else
			// Kapott üres tömb visszaadása
			return tokens;
	}

	public void init(String[] args) {

		try {
			Scene scene = new Scene();
			if (args.length > 0) {
				String filename = args[0];
				XMLBuilder builder = new XMLBuilder();
				scene = builder.readXML(filename);
			}
			game.setScene(scene);
			status(null);
		} catch (IOException e) {
			System.out.println("Fajl nem olvashato!");
		} catch (Exception e) {
			System.out.println("Hibas XML fajl!");
		}
	}

	public void status(String[] args) {
		for (int i = 0; i < game.getScene().getAnts().size(); i++) {
			Ant ant = game.getScene().getAnts().get(i);
			System.out.println(String.format(ant.toString(), i));
		}
		for (int i = 0; i < game.getScene().getCreatures().size(); i++) {
			Creature creature = game.getScene().getCreatures().get(i);
			System.out.println(String.format(creature.toString(), i));
		}
		for (int i = 0; i < game.getScene().getStorages().size(); i++) {
			Storage storage = game.getScene().getStorages().get(i);
			System.out.println(String.format(storage.toString(), i));
		}
		for (int i = 0; i < game.getScene().getObstacles().size(); i++) {
			Obstacle obstacle = game.getScene().getObstacles().get(i);
			System.out.println(String.format(obstacle.toString(), i));
		}
	}

	public void move(String[] args) {
		try {
			String type = args[0];
			int id = Integer.parseInt(args[1]);
			int x = Integer.parseInt(args[2]);
			int y = Integer.parseInt(args[3]);
			Point point = new Point(x, y);
			if (type.equals("ant"))
				game.getScene().getAnts().get(id).setPosition(point);
			else if (type.equals("anteater"))
				game.getScene().getCreatures().get(id).setPosition(point);
			else
				System.out.println("Hibas eloleny tipus!");
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Nem letezo eloleny!");
		}
	}

	public void tick(String[] args) {
		try {
			int count = 1;
			if (args.length > 0)
				count = Integer.parseInt(args[0]);
			for (; count > 0; --count) {
				game.getTimer().tick();
				status(null);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

	public void poison(String[] args) {
		try {
			if(args.length >= 2){
				int x = Integer.parseInt(args[0]);
				int y = Integer.parseInt(args[1]);
				Point point = new Point(x, y);
				Poison poison = new Poison(point);
				game.getScene().placeObstacle(poison);
				int idx = game.getScene().getObstacles().indexOf(poison);
				System.out.println(String.format("Poison %d deployed.", idx));
				// System.out.println(String.format(poison.toString(), idx));
			}
			else System.out.println("Hianyzo parameter(ek)!");
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

	public void deodorize(String[] args) {
		try {
			if(args.length >= 2){
				int x = Integer.parseInt(args[0]);
				int y = Integer.parseInt(args[1]);
				Point point = new Point(x, y);
				game.getScene().clearEffects(point);
				System.out.println("Deodorizer deployed.");
			}
			else System.out.println("Hianyzo parameter(ek)!");
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

	public void start(String[] args) {
		try {
			int interval = 1;
			if (args.length > 0)
				interval = Integer.parseInt(args[0]);
			game.getTimer().setInterval(interval);
			game.getTimer().start();
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

	public void stop(String[] args) {
		game.getTimer().stop();
	}

	public void toplist(String[] args) {
		try {
			if (args.length >= 2){
			String name = args[0];
				int score = Integer.parseInt(args[1]);
				game.addHighscore(name, score);
				System.out.println("Highscore added.");
			}
			else System.out.println("Hianyzo parameter(ek)!");
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

	public void difficulty(String[] args) {
		try {
			int difficulty = Integer.parseInt(args[0]);
			game.setDifficulty(difficulty);
		} catch (NumberFormatException e) {
			System.out.println("Hibas parameter!");
		}
	}

}

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
			line = in.readLine();
		} catch (IOException e) {
			// Sikertelen beolvasásnál kilépés
			return false;
		}

		// Parancs tokenekké alakítása
		String[] tokens = tokenize(line);
		String cmd = extractCommand(tokens);
		String[] args = extractArgs(tokens);

		// Parancsfuttatás
		if (cmd == "init")
			init(args);
		else if (cmd == "status")
			status(args);
		else if (cmd == "move")
			move(args);
		else if (cmd == "status")
			status(args);
		else if (cmd == "tick")
			tick(args);
		else if (cmd == "poison")
			poison(args);
		else if (cmd == "deodorize")
			deodorize(args);
		else if (cmd == "start")
			start(args);
		else if (cmd == "stop")
			stop(args);
		else if (cmd == "toplist")
			toplist(args);
		else if (cmd == "difficulty")
			difficulty(args);
		else if (cmd == "exit")
			return false;
		else
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

	}

	public void status(String[] args) {

	}

	public void move(String[] args) {

	}

	public void tick(String[] args) {

	}

	public void poison(String[] args) {

	}

	public void deodorize(String[] args) {

	}

	public void start(String[] args) {

	}

	public void stop(String[] args) {

	}

	public void toplist(String[] args) {

	}

	public void difficulty(String[] args) {

	}

}

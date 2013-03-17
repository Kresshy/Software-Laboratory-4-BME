package hu.miracle.workers;

import java.io.DataInputStream;
import java.io.IOException;

public class Main {

	private static Game game;
	private static Scene scene;
	private static Timer timer;

	public static int showMenu() {
		DataInputStream in = new DataInputStream(System.in);
		System.out.println("Válasszon az alábbi menüpontok közül!");
		System.out.println("Játék szimulálása:");
		System.out.println("\t1: Egy hangya útnak indítása");
		System.out.println("\t2: Hangya ételt vesz fel");
		System.out.println("\t3: Hangya elpusztulása (méreg miatt)");
		System.out.println("\t4: Hangyászsün elindítása");
		System.out.println("\t5: Méreg spray fújása");
		System.out.println("\t6: Szagtalanító spray fújása");
		System.out.println("\t7: Egy Timer tick");
		System.out.println("\t8: Hangya egy akadályt kerül ki");
		System.out.println("\t9: Hangya a hangyalesőbe lép");
		System.out.println("10: Játék szüneteltetése");
		System.out.println("11: Játék folytatása");
		System.out.println("12: Játék nehézségének beállítása");
		System.out.println("13: Toplista mentése");
		System.out.println("14: Kilépés");

		int result = 0;
		try {
			result = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			System.out
					.println("Nem megfelelő értéket adott meg! Kérem egy egész számot adjon meg!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Main.class.getCanonicalName() + ".main()");

		int menuresult = showMenu();

		game = new Game();
		scene = new Scene();
		timer = new Timer(game, 1000);

		game.setScene(scene);
		game.setTimer(timer);

		switch (menuresult) {
		case 1:
			// TODO: hangya utnak inditasa
			break;

		case 2:
			// TODO: hangya etelfelvetele
			break;

		case 3:
			// TODO: hangya mereg miatt elpusztul
			break;

		case 4:
			// TODO: hangyaszsun elinditasa
			break;

		case 5:
			// TODO: mereg spray fujas
			break;

		case 6:
			// TODO: szagtalanito spray fujas
			break;

		case 7:
			// TODO: egy timer tick
			break;

		case 8:
			// TODO: hangya kikeruli az akadalyt
			break;

		case 9:
			// TODO: hangya a hangyalesobe lep
			break;

		case 10:
			// TODO: game pause
			break;

		case 11:
			// TODO: game resume
			break;

		case 12:
			// TODO: nehezseg beallitasa
			break;

		case 13:
			// TODO: toplista mentese
			break;

		case 14:
			System.exit(0);
			break;

		default:
			System.out.println("Nincs ilyen menüpont!");
			break;
		}

		System.exit(0);

	}

}

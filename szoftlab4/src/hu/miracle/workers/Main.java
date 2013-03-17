package hu.miracle.workers;

import java.awt.Point;
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
		System.out.println("\t2: Hangyászsün elindítása");
		System.out.println("\t3: Spray fújás a játéktérre");
		System.out.println("4: Kilépés");

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
			AntHill anthill1=new AntHill(new Point(5,5),scene,5,5);
			timer.start();

			break;

		case 4:
			System.exit(0);
			break;

		default:
			System.out.println("Nincs ilyen menüpont!");
			break;
		}

		System.exit(0);

	}

}

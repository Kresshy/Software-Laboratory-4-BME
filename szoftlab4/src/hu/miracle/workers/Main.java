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
		System.out.println("1: Játék indítása");
		System.out.println("2: Kilépés");

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

		switch (menuresult) {
		case 1:
			game = new Game();

			scene = new Scene();
			timer = new Timer(game);
			timer.start();

			game.setScene(scene);
			game.setTimer(timer);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timer.stopTimer();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timer.startTimer();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			break;

		case 2:
			System.exit(0);
			break;

		default:
			System.out.println("Nincs ilyen menüpont!");
			break;
		}

		System.exit(0);

	}

}

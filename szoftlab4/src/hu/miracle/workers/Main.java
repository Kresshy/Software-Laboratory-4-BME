package hu.miracle.workers;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static Game game;
	private static Scene scene;
	private static Timer timer;

	public static int showMenu() {
		int result = 0;
		boolean success = false;
		String menu[] = { "Hangya szuletese", "Hangya etelfelvetele",
				"Hangya mereg altali pusztulasa", "Hangyaszsun szuletese",
				"Hangyairto spray fujasa", "Szagtalanito spray fujasa", "Idozito tick",
				"Hangya akadalyelkerulese", "Hangya hangyalesobe lepese", "Jatek szuneteltetese",
				"Jatek folytatasa", "Jatek nehezsegenek beallitasa", "Toplista mentese", "Kilepes" };
		BufferedReader bfread = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Jatek szimulalasa\nValasszon az alabbi menupontok kozul:\n");
		for (int i = 0; i < menu.length; i++) {
			String scenario = menu[i];
			System.out.println(String.format("%2d. %s", i + 1, scenario));
		}

		while (!success) {
			try {
				System.out.print("\nValasztott menupont: ");
				result = Integer.parseInt(bfread.readLine().trim());
				if (0 < result && result <= menu.length) {
					success = true;
				} else {
					System.out.println("Nem megfelelo ertek! Kerem a menupontok kozul valasszon!");
				}
			} catch (NumberFormatException e) {
				System.out.println("Nem megfelelo ertek! Kerem egy egesz szamot adjon meg!");
			} catch (IOException e) {
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Main.class.getCanonicalName() + ".main()");

		scene = new Scene();
		timer = new Timer(1000);
		game = new Game(scene, timer);
		timer.start();

		while (true) {

			int menuresult = showMenu();

			switch (menuresult) {
			case 1:
				// hangya utnak inditasa
				Point pos = new Point(0, 0);
				AntHill hill = new AntHill(pos, scene, 1, 1);
				Ant ant = new Ant(pos, scene, hill);
				scene.getAnts().add(ant);
				// Tick
				System.out.println("<START>");
				ant.handleTick();
				System.out.println("<END>");
				break;

			case 2:
				// hangya etelfelvetele
				Point pos1 = new Point(0, 0);
				AntHill hill1 = new AntHill(pos1, scene, 1, 1);
				FoodStorage fs1 = new FoodStorage(pos1, 50, 50);
				Ant ant1 = new Ant(pos1, scene, hill1);
				scene.getStorages().add(fs1);
				scene.getAnts().add(ant1);
				// Tick
				System.out.println("<START>");
				ant1.handleTick();
				System.out.println("<END>");
				break;

			case 3:
				// hangya mereg miatt elpusztul
				Point pos2 = new Point(0, 0);
				AntHill hill2 = new AntHill(pos2, scene, 1, 1);
				Ant ant2 = new Ant(pos2, scene, hill2);
				ant2.setPoisoned(true);
				scene.getAnts().add(ant2);				
				// Tick
				System.out.println("<START>");
				ant2.handleTick();
				ant2.handleTick();
				ant2.handleTick();
				System.out.println("<END>");
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
				// egy tick eldobasa
				timer.tick();
				break;

			case 8:
				// TODO: hangya kikeruli az akadalyt
				
				break;

			case 9:
				// hangya belelep a hangyalesobe
				// Inicializálás
				Point c9pos = new Point(0, 0);
				AntHill c9hill = new AntHill(c9pos, scene, 1, 1);
				AntSinker c9sink = new AntSinker(c9pos);
				Ant c9ant = new Ant(c9pos, scene, c9hill);
				scene.getObstacles().add(c9sink);
				scene.getAnts().add(c9ant);
				// Tick
				System.out.println("<START>");
				c9ant.handleTick();
				System.out.println("<END>");
				break;

			case 10:
				// egy tick eldobasa
				System.out.println("<START>");
				timer.pause();
				System.out.println("<END>");

				break;

			case 11:
				// jatek folytatasa
				System.out.println("<START>");
				System.out.println("Az óra elindul majd automatikusan megáll 10sec múlva!");
				timer.pause();
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				timer.pause();
				System.out.println("<END>");
				break;

			case 12:
				// jatek nehezsegenek beallitasa
				try {
					System.out.println("<START>");
					System.out.println("Kérem adjon meg egy nehézségi szintet (1-3):");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					game.setDifficulty(Integer.parseInt(br.readLine()));
					System.out.println("<END>");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 13:
				// toplista mentes
				try {
					System.out.println("<START>");
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					int score;
					score = Integer.parseInt(br.readLine());
					game.writeTopList(score);
					System.out.println("<END>");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case 14:
				// kilepes
				System.exit(0);
				break;

			default:
				break;
			}

		}

	}

}

package hu.miracleworkers.swing;

import hu.miracleworkers.controller.Game;
import hu.miracleworkers.controller.GameListener;
import hu.miracleworkers.model.HighScore;
import hu.miracleworkers.view.Perspective;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class GUI implements ActionListener, MouseListener, GameListener {

	private JFrame		frame;
	private Perspective	p;
	private JLabel		lblElteltId;
	private Game		game;
	private int			difficulty;
	private long		score;
	private JTextField	name;

	/**
	 * Create the application.
	 */
	public GUI(Perspective p, Game game) {
		// Beállítjuk neki a perspektívát
		this.p = p;
		game.setListener(this);
		// Inicializáljuk az ablakot
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Egy új frame létrehozása a következő méretekkel
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menubar hozzáadása a framehez
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		// Menupont hozzáadása
		JMenu mnNewMenu = new JMenu("J\u00E1t\u00E9k");
		menuBar.add(mnNewMenu);

		// Menuponthoz elemek hozzáadása
		// Minden menüpontnak beállítjuk az ActionListenert
		// Minden menüpontnak beállítjuk az ActionCommandot
		JMenuItem mntmNewMenuItem = new JMenuItem("Ind\u00EDt\u00E1s");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setActionCommand("start");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Kil\u00E9p\u00E9s");
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setActionCommand("exit");
		mnNewMenu.add(mntmNewMenuItem_1);

		// Menupont hozzáadása
		JMenu mnNewMenu_1 = new JMenu("S\u00FAg\u00F3");
		menuBar.add(mnNewMenu_1);

		// Menuponthoz elemek hozzáadása
		// Minden menüpontnak beállítjuk az ActionListenert
		// Minden menüpontnak beállítjuk az ActionCommandot
		JMenuItem mntmToplista = new JMenuItem("Toplista");
		mntmToplista.addActionListener(this);
		mntmToplista.setActionCommand("highscore");
		mnNewMenu_1.add(mntmToplista);

		JMenuItem mntmSegtsg = new JMenuItem("Seg\u00EDts\u00E9g");
		mntmSegtsg.addActionListener(this);
		mntmSegtsg.setActionCommand("help");
		mnNewMenu_1.add(mntmSegtsg);

		JMenuItem mntmCredits = new JMenuItem("Credits");
		mntmCredits.addActionListener(this);
		mntmCredits.setActionCommand("credits");
		mnNewMenu_1.add(mntmCredits);

		// Spring layout beállítása
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		// A felső panel hozzáadása
		JPanel panel = new JPanel();

		// spring layout megkötések beállítása
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 884, SpringLayout.WEST,
				frame.getContentPane());
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);

		// Pause gomb hozzáadása a panelhez
		JButton btnNewButton = new JButton("||");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("pause");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);

		// Label hozzáadása
		// TODO pontszámés nehézségi szint számítása és kiírása
		lblElteltId = new JLabel("Pontszám: XXXX  Nehézségi szint: XX");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup().addGap(28).addComponent(lblElteltId)
						.addPreferredGap(ComponentPlacement.RELATED, 309, Short.MAX_VALUE)
						.addComponent(btnNewButton).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 23,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblElteltId)).addContainerGap()));
		panel.setLayout(gl_panel);
		// Ide jön a játéktér
		// Ez a panelünk lesz a perspektívát megjelenítő nézet
		JPanel panel_1 = new PerspectivePanel(p);
		panel_1.addMouseListener(this);

		// A panel hozzáadása a layouthoz
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 482, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_1);
	}

	public void setVisible(boolean b) {
		// Beállítjuk láthatóként a framet
		frame.setVisible(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Az egyes Actionok kezelése a megfelelő if részben
		// Pause a gomb lenyomásakor, állapottól függően ujraindítja a jatekot
		if (e.getActionCommand().equals("pause")) {
			if (p.getGame().getTimer().isEnabled()) {
				p.getGame().getTimer().stop();
			} else {
				p.getGame().getTimer().start();
			}

			// Jatek indítása
		} else if (e.getActionCommand().equals("start")) {
			StartGame frame = new StartGame(p);
			frame.setVisible(true);

			// kilépés a játékból
		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0);

			// highcsore megjenelítése
		} else if (e.getActionCommand().equals("highscore")) {

			JFrame frame = new JFrame("Highscore");
			JPanel hPanel = new JPanel();
			JTable hTable = new JTable();
			hTable.setPreferredScrollableViewportSize(new Dimension(280, 160));

			// AbstractTableModel amibe kiírjuk a Toplista tartalmát
			TableModel dataModel = new AbstractTableModel() {

				// Oszlopok nevei
				String[]	columnNames	= new String[] { "Név", "Pontszám" };

				// Megfelelő cella értékének visszaadása
				@Override
				public Object getValueAt(int arg0, int arg1) {

					List<HighScore> list = p.getGame().getHighscores();
					if (!list.isEmpty() && arg1 <= list.size()) {
						if (arg0 < columnNames.length - 1)
							return list.get(arg1).name;
						else
							return list.get(arg1).score;
					}
					return null;
				}

				// Sorok száma
				@Override
				public int getRowCount() {
					return 10;
				}

				// Oszlopok száma
				@Override
				public int getColumnCount() {
					return columnNames.length;
				}

				// Oszlop nevének megjelenítése
				@Override
				public String getColumnName(int column) {
					return columnNames[column];
				}

				// Oszlop osztályának típusa
				@Override
				public Class<?> getColumnClass(int columnIndex) {
					return String.class;
				}

				// A cellák ne legyenek módosíthatók
				@Override
				public boolean isCellEditable(int rowIndex, int columnIndex) {
					return false;
				}

			};

			// Beállítjuk a table modelt az JTablenek
			hTable.setModel(dataModel);

			// Elemek hozzaadasa a framehez
			hPanel.add(new JScrollPane(hTable));
			frame.add(hPanel);
			frame.setBounds(60, 30, 300, 250);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setResizable(false);
			frame.setVisible(true);

			// segítség megjelenítése
		} else if (e.getActionCommand().equals("help")) {

			JFrame frame = new JFrame("Help");

			JPanel hPanel = new JPanel() {

				private static final long	serialVersionUID	= 1L;

				@Override
				protected void paintComponent(Graphics g) {

					String helpString = "Segítség a játékmenethez. A játék célja, hogy a játékos minél több ideig "
							+ "megvédje az élelmet a hangyák elől."
							+ "Ehhez két eszköz áll a segítségére: Bal egérgombbal helyezhető el méreg a pályán, mely"
							+ "rövid időn belül megöli a belelépő hangyákat, jobb egérgombbal helyezhető le hangyaszag"
							+ "semlegesítő, mellyel a hangyákat összezavarhatja, és eltérítheti az élelem felől."
							+ "A pályán találhatók hangyalesők, melyek a beléjük tévedő hangyákat megeszik,továbbá"
							+ "bizonyos időnként áthalad a pályán egy hangyászsün, mely addig eszi a vele találkozó hangyákat"
							+ "amíg jól nem lakott. ";

					drawString(g, helpString, 10, 20, 380);
				}

				public void drawString(Graphics g, String s, int x, int y, int width) {
					// FontMetrics gives us information about the width,
					// height, etc. of the current Graphics object's Font.
					FontMetrics fm = g.getFontMetrics();

					int lineHeight = fm.getHeight();

					int curX = x;
					int curY = y;

					String[] words = s.split(" ");

					for (String word : words) {
						// Find out thw width of the word.
						int wordWidth = fm.stringWidth(word + " ");

						// If text exceeds the width, then move to next line.
						if (curX + wordWidth >= x + width) {
							curY += lineHeight;
							curX = x;
						}

						g.drawString(word, curX, curY);

						// Move over to the right for next word.
						curX += wordWidth;
					}
				}
			};

			frame.add(hPanel);
			frame.setVisible(true);
			frame.setBounds(100, 100, 400, 300);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

			// creditek megjelenítése
		} else if (e.getActionCommand().equals("credits")) {

			JFrame frame = new JFrame("Credits");

			JPanel hPanel = new JPanel() {

				private static final long	serialVersionUID	= 1L;

				@Override
				protected void paintComponent(Graphics g) {

					drawString(g, "Az alkalmazást készítette:", 120, 20, 380);
					drawString(
							g,
							"Cseh Gábor, Gazsi István, Tímár Dávid Patrik, Turcsán Csaba, Váradi Szabolcs -- 2013 a Szoftver laboratórium 4. című tárgy keretein belül.",
							10, 40, 380);
				}

				public void drawString(Graphics g, String s, int x, int y, int width) {
					// FontMetrics gives us information about the width,
					// height, etc. of the current Graphics object's Font.
					FontMetrics fm = g.getFontMetrics();

					int lineHeight = fm.getHeight();

					int curX = x;
					int curY = y;

					String[] words = s.split(" ");

					for (String word : words) {
						// Find out thw width of the word.
						int wordWidth = fm.stringWidth(word + " ");

						// If text exceeds the width, then move to next line.
						if (curX + wordWidth >= x + width) {
							curY += lineHeight;
							curX = x;
						}

						g.drawString(word, curX, curY);

						// Move over to the right for next word.
						curX += wordWidth;
					}
				}
			};

			frame.add(hPanel);
			frame.setVisible(true);
			frame.setBounds(100, 100, 400, 150);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		} else if (e.getActionCommand().equals("mentes")) {
			p.getGame().addHighscore(name.getText(), (int) score);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Az egérkattintás kezelése az egér megfelelő gombjának lenyomására
		// Bal egérgomb lenyomása
		if (e.getButton() == e.BUTTON1) {
			System.out.println("left button clicked");

			p.getGame().placePoison(e.getX(), e.getY());
			System.out.println("X: " + e.getX() + " Y: " + e.getY());

			// Görgő vagy középső gomb lenyomása
		} else if (e.getButton() == e.BUTTON2) {
			System.out.println("middle button clicked");

			// jobb egérgomb lenyomása
		} else if (e.getButton() == e.BUTTON3) {
			System.out.println("right button clicked");
			p.getGame().placeDeodorizer(e.getX(), e.getY());
		}
	}

	// Ezekre a metódusokra nincs szükségünk viszont a MouseListener interface
	// miatt muszáj itt legyenek implementálva
	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void difficultyChange(int new_difficulty) {
		this.difficulty = new_difficulty;
		lblElteltId.setText("Pontszám: " + score + "  Nehézségi szint: " + difficulty);
	}

	@Override
	public void gameOver() {
		p.getGame().getTimer().stop();

		JFrame frame = new JFrame("Game Over");

		JPanel hPanel = new JPanel() {

			private static final long	serialVersionUID	= 1L;

			@Override
			protected void paintComponent(Graphics g) {

				drawString(g, "Game Over", 120, 20, 380);
				drawString(g, "Zárd be ezt az ablakot és indíts egy új játékot!", 10, 40, 380);
			}

			public void drawString(Graphics g, String s, int x, int y, int width) {
				// FontMetrics gives us information about the width,
				// height, etc. of the current Graphics object's Font.
				FontMetrics fm = g.getFontMetrics();

				int lineHeight = fm.getHeight();

				int curX = x;
				int curY = y;

				String[] words = s.split(" ");

				for (String word : words) {
					// Find out thw width of the word.
					int wordWidth = fm.stringWidth(word + " ");

					// If text exceeds the width, then move to next line.
					if (curX + wordWidth >= x + width) {
						curY += lineHeight;
						curX = x;
					}

					g.drawString(word, curX, curY);

					// Move over to the right for next word.
					curX += wordWidth;
				}
			}
		};

		name = new JTextField();
		JButton button = new JButton("Mentés");
		button.setActionCommand("mentes");
		button.addActionListener(this);

		frame.add(hPanel);
		frame.add(name);
		frame.add(button);
		frame.setVisible(true);
		frame.setBounds(100, 100, 400, 150);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	@Override
	public void scoreChange(long new_score) {
		this.score = new_score;
		lblElteltId.setText("Pontszám: " + score + "  Nehézségi szint: " + difficulty);
	}
}

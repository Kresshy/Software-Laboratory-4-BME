package hu.miracleworkers.swing;

import hu.miracleworkers.model.HighScore;
import hu.miracleworkers.view.Perspective;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class GUI implements ActionListener, MouseListener {

	JFrame		frame;
	Perspective	p;

	/**
	 * Create the application.
	 */
	public GUI(Perspective p) {
		// Beállítjuk neki a perspektívát
		this.p = p;
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
		JLabel lblElteltId = new JLabel("Pontszám: XXXX  Nehézségi szint: XX");
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
			p.getGame().getTimer().start();

			// kilépés a játékból
		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0);

			// highcsore megjenelítése
		} else if (e.getActionCommand().equals("highscore")) {
			// TODO Kell egy Frame amire ezt ki lehet rajzolni
			JFrame frame = new JFrame("Highscore");
			JPanel hPanel = new JPanel();
			JTable hTable = new JTable();
			hTable.setBounds(66, 35, 303, 160);
			
			String[] columnNames = {"Név","Pontszám"};
			DefaultTableModel model = new DefaultTableModel();
			
		    hTable.setModel(model);
		    model.setColumnIdentifiers(columnNames);
				
			//Feltoltes	
			for(HighScore list : p.getGame().getHighscores()) {
				((DefaultTableModel) hTable.getModel()).addRow(new Object[]{list.name, Long.toString(list.score)}); 
			}
			//Elemek hozzaadasa a framehez
			frame.setVisible(true);
			frame.setBounds(66, 35, 303, 210);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setResizable(false);
			hPanel.add(hTable);
			frame.add(hPanel);

			// segítség megjelenítése
		} else if (e.getActionCommand().equals("help")) {
			String helpString = "Segítség a játékmenethez.\nA játék célja, hogy a játékos minél több ideig \n" +
					"megvédje az élelmet a hangyák elől.\n" +
					"Ehhez két eszköz áll a segítségére: \nBal egérgombbal helyezhető el méreg a pályán, mely\n" +
					"rövid időn belül megöli a belelépő hangyákat ;\njobb egérgombbal helyezhető el hangyaszag\n" +
					"semlegesítő, mellyel a hangyákat összezavarhatja,\nés eltérítheti az élelem felől.\n" +
					"A pályán találhatók hangyalesők, melyek a beléjük\ntévedő hangyákat megeszik,továbbá\n" +
					"bizonyos időnként áthalad a pályán egy hangyászsün,\nmely addig eszi a vele találkozó hangyákat\n" +
					"amíg jól nem lakott. ";
			JFrame frame = new JFrame("Help");
			JPanel hPanel = new JPanel();
			JTextArea hArea = new JTextArea();
			hArea.setText(helpString);
			hArea.setBounds(100,100,300,500);
			hPanel.add(hArea);
			frame.add(hPanel);
			frame.setVisible(true);
			frame.setBounds(100, 100, 400, 300);
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			

			// creditek megjelenítése
		} else if (e.getActionCommand().equals("credits")) {
			// TODO Kell egy Frame amire ezt ki lehet rajzolni
			JFrame frame = new JFrame("Credits");
			frame.setVisible(true);
			frame.setBounds(100, 100, 600, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
}

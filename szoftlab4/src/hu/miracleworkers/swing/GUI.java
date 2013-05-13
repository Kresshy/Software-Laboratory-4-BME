package hu.miracleworkers.swing;

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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class GUI implements ActionListener, MouseListener {

	JFrame		frame;
	Perspective	p;

	/**
	 * Create the application.
	 */
	public GUI(Perspective p) {
		this.p = p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("J\u00E1t\u00E9k");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Ind\u00EDt\u00E1s");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setActionCommand("start");
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Kil\u00E9p\u00E9s");
		mntmNewMenuItem_1.addActionListener(this);
		mntmNewMenuItem_1.setActionCommand("exit");
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("S\u00FAg\u00F3");
		menuBar.add(mnNewMenu_1);

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

		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, panel, 884, SpringLayout.WEST,
				frame.getContentPane());
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel);

		JButton btnNewButton = new JButton("||");
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("pause");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);

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
		// JPanel panel_1 = new JPanel();
		JPanel panel_1 = new PerspectivePanel(p);
		panel_1.addMouseListener(this);

		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 6, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 10, SpringLayout.WEST,
				frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, 482, SpringLayout.SOUTH, panel);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -10, SpringLayout.EAST, panel);
		frame.getContentPane().add(panel_1);
	}

	public void setVisible(boolean b) {
		frame.setVisible(b);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("pause")) {
			if (p.getGame().getTimer().isEnabled()) {
				p.getGame().getTimer().stop();
			} else {
				p.getGame().getTimer().start();
			}

		} else if (e.getActionCommand().equals("start")) {
			p.getGame().getTimer().start();

		} else if (e.getActionCommand().equals("exit")) {
			System.exit(0);

		} else if (e.getActionCommand().equals("highscore")) {
			// TODO Kell egy Frame amire ezt ki lehet rajzolni
			JFrame frame = new JFrame("Highscore");
			frame.setVisible(true);
			frame.setBounds(100, 100, 600, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		} else if (e.getActionCommand().equals("help")) {
			// TODO Kell egy Frame amire ezt ki lehet rajzolni
			JFrame frame = new JFrame("Help");
			frame.setVisible(true);
			frame.setBounds(100, 100, 600, 600);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
		if (e.getButton() == e.BUTTON1) {
			System.out.println("left button clicked");

			p.getGame().placePoison(e.getX(), e.getY());
			System.out.println("X: " + e.getX() + " Y: " + e.getY());
			
		} else if (e.getButton() == e.BUTTON2) {
			System.out.println("middle button clicked");
		} else if (e.getButton() == e.BUTTON3) {
			System.out.println("right button clicked");
		}
	}

	// Ezekre a metódusokra nincs szükségünk viszont a MouseListener interface
	// miatt muszáj itt legyenek
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

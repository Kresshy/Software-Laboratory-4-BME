package hu.miracleworkers.swing;

import hu.miracleworkers.view.Perspective;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;

public class StartGame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	private JPanel				contentPane;
	private Perspective			p;
	private ButtonGroup			group;

	public StartGame(Perspective p) {

		this.p = p;

		setTitle("Ind\u00EDt\u00E1s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setActionCommand("2");
		sl_panel_1
				.putConstraint(SpringLayout.EAST, radioButton_1, -129, SpringLayout.EAST, panel_1);
		panel_1.add(radioButton_1);

		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setActionCommand("1");
		sl_panel_1.putConstraint(SpringLayout.SOUTH, radioButton, -9, SpringLayout.NORTH,
				radioButton_1);
		panel_1.add(radioButton);

		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setActionCommand("3");
		sl_panel_1.putConstraint(SpringLayout.NORTH, radioButton_2, 6, SpringLayout.SOUTH,
				radioButton_1);
		sl_panel_1
				.putConstraint(SpringLayout.EAST, radioButton_2, -101, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, radioButton, 0, SpringLayout.EAST,
				radioButton_2);
		panel_1.add(radioButton_2);

		group = new ButtonGroup();
		radioButton_1.setSelected(true);
		group.add(radioButton);
		group.add(radioButton_1);
		group.add(radioButton_2);

		JButton btnOk = new JButton("OK");
		sl_panel_1.putConstraint(SpringLayout.WEST, btnOk, 278, SpringLayout.WEST, panel_1);
		btnOk.setActionCommand("ok");
		btnOk.addActionListener(this);
		panel_1.add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setActionCommand("cancel");
		btnCancel.addActionListener(this);
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnOk, 0, SpringLayout.NORTH, btnCancel);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnOk, -6, SpringLayout.WEST, btnCancel);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, btnCancel, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btnCancel, -10, SpringLayout.EAST, panel_1);
		panel_1.add(btnCancel);

		JLabel lblKnny = new JLabel("K\u00F6nny\u0171");
		sl_panel_1.putConstraint(SpringLayout.WEST, radioButton, 51, SpringLayout.EAST, lblKnny);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblKnny, -226, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblKnny, 151, SpringLayout.WEST, panel_1);
		panel_1.add(lblKnny);

		JLabel lblKzepes = new JLabel("K\u00F6zepes");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblKzepes, 110, SpringLayout.NORTH, panel_1);
		sl_panel_1
				.putConstraint(SpringLayout.WEST, radioButton_1, 23, SpringLayout.EAST, lblKzepes);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblKnny, -18, SpringLayout.NORTH, lblKzepes);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblKzepes, 0, SpringLayout.WEST, lblKnny);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblKzepes, 27, SpringLayout.EAST, lblKnny);
		panel_1.add(lblKzepes);

		JLabel lblNehz = new JLabel("Neh\u00E9z");
		sl_panel_1.putConstraint(SpringLayout.EAST, lblNehz, -226, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, radioButton_2, 50, SpringLayout.EAST, lblNehz);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNehz, 15, SpringLayout.SOUTH, lblKzepes);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNehz, 151, SpringLayout.WEST, panel_1);
		panel_1.add(lblNehz);

		JLabel lblVlasszonNehzsgiSzintet = new JLabel("V\u00E1lasszon neh\u00E9zs\u00E9gi szintet!");
		sl_panel_1.putConstraint(SpringLayout.NORTH, radioButton, 18, SpringLayout.SOUTH,
				lblVlasszonNehzsgiSzintet);
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblVlasszonNehzsgiSzintet, 42,
				SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblVlasszonNehzsgiSzintet, 141,
				SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, lblVlasszonNehzsgiSzintet, -196,
				SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, lblVlasszonNehzsgiSzintet, -71,
				SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, radioButton_1, 50, SpringLayout.SOUTH,
				lblVlasszonNehzsgiSzintet);
		panel_1.add(lblVlasszonNehzsgiSzintet);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ok")) {
			String selected = group.getSelection().getActionCommand();
			switch (Integer.parseInt(selected)) {
			case 1:
				p.getGame().createNewScene(1);
				break;
			case 2:
				p.getGame().createNewScene(2);
				break;
			case 3:
				p.getGame().createNewScene(3);
				break;
			default:
				break;
			}

			this.dispose();
		}
		if (e.getActionCommand().equals("cancel")) {
			this.dispose();
		}

	}

}

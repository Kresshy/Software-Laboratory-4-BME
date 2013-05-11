package hu.example.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BufferedImage background, foodstorage, ant, anthill, antsinker, puddle, anteater, pebble;
	Dimension size;

	public Main() {
		try {
			
			size = new Dimension();

			background = ImageIO.read(new File("palya.png"));
			foodstorage = ImageIO.read(new File("foodstorage.png"));
			ant = ImageIO.read(new File("hangya.png"));
			anthill = ImageIO.read(new File("hangyaboly.png"));
			pebble = ImageIO.read(new File("kavics.png"));
			puddle = ImageIO.read(new File("pocsolya.png"));
			antsinker = ImageIO.read(new File("hangyanyelõ.png"));
			anteater = ImageIO.read(new File("sün.png"));

			size.width = background.getWidth(null);
			size.height = background.getHeight(null);
			setPreferredSize(size);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void paint(Graphics g) {

		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(background, 0, 0, null);
		g2d.drawImage(foodstorage, 650, 100, null);
		g2d.drawImage(ant, 200, 200, null);
		g2d.drawImage(anthill, 100, 100, null);
		g2d.drawImage(pebble, 440, 100, null);
		g2d.drawImage(puddle, 600, 400, null);
		g2d.drawImage(antsinker, 300, 300, null);
		g2d.drawImage(anteater, 250, 360, null);

	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("Red Rock");
		frame.add(new Main());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

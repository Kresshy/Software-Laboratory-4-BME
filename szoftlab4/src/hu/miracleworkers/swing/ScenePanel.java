package hu.miracleworkers.swing;

import hu.miracleworkers.view.Perspective;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ScenePanel extends JPanel {

	BufferedImage	background;
	Dimension		size;
	Perspective		perspective;

	public ScenePanel(Perspective p) {
		try {

			this.perspective = p;
			size = new Dimension();
			p.setPanel(this);

			background = ImageIO.read(new File("graphics\\palya.png"));

			size.width = background.getWidth(null);
			size.height = background.getHeight(null);
			setPreferredSize(size);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {

		g.drawImage(background, 0, 0, null);
		perspective.paintObjects(g);

	}

}

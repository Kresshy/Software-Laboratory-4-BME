package hu.miracleworkers.swing;

import hu.miracleworkers.view.Perspective;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PerspectivePanel extends JPanel {

	protected BufferedImage	background;
	protected Dimension		size;
	protected Perspective	perspective;

	public PerspectivePanel(Perspective perspective) {
		try {
			setPerspective(perspective);

			background = ImageIO.read(new File("graphics/background.png"));

			size = new Dimension();
			size.width = background.getWidth(null);
			size.height = background.getHeight(null);

			setPreferredSize(size);
		} catch (IOException e) {
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null);
		perspective.paintObjects(g);
	}

	protected void setPerspective(Perspective perspective) {
		this.perspective = perspective;
		perspective.setPanel(this);
	}

}

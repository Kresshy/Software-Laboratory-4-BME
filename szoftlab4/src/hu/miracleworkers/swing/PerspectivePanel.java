package hu.miracleworkers.swing;

import hu.miracleworkers.view.Perspective;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PerspectivePanel extends JPanel {

	protected Dimension		size;
	protected Perspective	perspective;

	public PerspectivePanel(Perspective perspective) {
		setPerspective(perspective);
		size = new Dimension(800, 400);
		setPreferredSize(size);
	}

	@Override
	protected void paintComponent(Graphics graphics) {
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, size.width, size.height);
		perspective.paintObjects(graphics);
	}

	protected void setPerspective(Perspective perspective) {
		this.perspective = perspective;
		perspective.setPanel(this);
	}

}

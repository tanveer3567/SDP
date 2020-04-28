package model;

import java.awt.Graphics;

//Composite Pattern
public class Rectangle implements Shape {

	private Dimensions dim;

	public Rectangle() {
		this.dim = new Dimensions();
	}

	// Expert Pattern
	@Override
	public void draw(Graphics g) {

		g.drawRect(dim.getX(), dim.getY(), dim.getWidth(), dim.getHeight());
	}

	// Expert Pattern
	@Override
	public void setup(int x, int y, int width, int height) {

		dim.setup(x, y, width, height);
	}
}

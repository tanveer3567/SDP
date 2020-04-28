package model;

import java.awt.Graphics;

//Composite Pattern
public class Line implements Shape {

	private Dimensions dim;

	public Line() {
		this.dim = new Dimensions();
	}
	
	//Expert Pattern
	@Override
	public void draw(Graphics g) {

		g.drawLine(dim.getX(), dim.getY(), dim.getWidth(), dim.getHeight());
	}
	
	//Expert Pattern
	@Override
	public void setup(int x, int y, int width, int height) {
		
		dim.setup(x, y, width, height);
	}
}

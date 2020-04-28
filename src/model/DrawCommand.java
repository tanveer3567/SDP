package model;

import java.awt.Graphics;

//Command Pattern
public class DrawCommand implements Command{

	private Shape shape;
	
	public DrawCommand(Shape shape) {
		
		this.shape = shape;
	}
	
	//Command Pattern
	@Override
	public void execute(Graphics g) {
		
		shape.draw(g);
	}

}

package model;

import java.awt.Graphics;

//Composite Pattern
public interface Shape {

	//Expert Pattern
	void draw(Graphics g);
	
	void setup(int x, int y, int width, int hieght);
	
}

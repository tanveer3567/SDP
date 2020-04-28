package contoller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Service.DrawingService;
import gui.GUI;
import model.Circle;
import model.Line;
import model.Rectangle;
import model.Shape;

//Controller Pattern
public class DrawingController implements MouseListener{

	
	private GUI gui;
	private DrawingService service;
	
	public DrawingController(GUI gui, DrawingService service) {
		
		this.gui = gui;
		this.service = service;
	}
	
	public void start() {
		
		this.gui.btnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setShape(new Circle());
			}
		});
		
		this.gui.btnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setShape(new Line());
			}
		});
		
		this.gui.btnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.setShape(new Rectangle());
			}
		});
		
		this.gui.btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.undo(gui.panel);
			}
		});
		
		this.gui.btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service.redo(gui.panel);
			}
		});
		
		gui.panel.addMouseListener(this);
	}
	
	
	public void mouseClicked(MouseEvent e) {

		service.doo(gui.panel, e, false);
	}
	
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}

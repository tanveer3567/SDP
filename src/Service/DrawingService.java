package Service;

import java.awt.event.MouseEvent;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

import gui.GUI.DrawingPanel;
import model.DrawCommand;
import model.Shape;

public class DrawingService {

	private Stack<Shape> stack1;
	private Stack<Shape> stack2;
	private DrawCommand draw;
	//State Pattern
	private Shape shape;

	public DrawingService() {

		this.stack1 = new Stack<Shape>();
		this.stack2 = new Stack<Shape>();
	}

	public void doo(DrawingPanel panel, MouseEvent e, boolean isRedo) {

		if (!isRedo) {
			shape.setup(e.getX(), e.getY(), 200, 200);
			stack2.removeAllElements();
		}
		panel.paint(panel.getGraphics());
		draw = new DrawCommand(shape);
		draw.execute(panel.getGraphics());
		stack1.add(shape);
	}

	public void undo(DrawingPanel panel) {
		if (!stack1.isEmpty()) {
			Shape shape = stack1.pop();
			stack2.push(shape);
			Iterator<Shape> shapes = getIterator(stack1);
			panel.setCount(0);
			panel.removeAll();
			panel.revalidate();
			panel.paint(panel.getGraphics());
			while (shapes.hasNext()) {
				Shape nextShape = shapes.next();
				new DrawCommand(nextShape).execute(panel.getGraphics());
			}
		}
	}

	public void redo(DrawingPanel panel) {

		if (!stack2.isEmpty()) {
			Shape shape = stack2.pop();
			setShape(shape);
			stack1.push(shape);
			doo(panel, null, true);
		}
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	//IteratorPatern
	public Iterator<Shape> getIterator(Collection<Shape> collection) {

		return collection.iterator();
	}
}

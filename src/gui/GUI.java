package gui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI{

	public JButton btnCircle;
	public JButton btnLine;
	public JButton btnRectangle;
	public JButton btnUndo;
	public JButton btnRedo;
	public DrawingPanel panel;

	public class DrawingPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public int count = 0;
		
		public DrawingPanel() {
			setBackground(Color.WHITE);
		}
		
		public void paintComponent(Graphics g) {

			if (count == 0)
				super.paintComponent(g);
			count++;
		}
		
		public void setCount(int count) {
			this.count = count;
		}

	}

	public void constructGUI() {
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		panel = new DrawingPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(150, 0, 613, 528);
		btnCircle = new JButton("circle");
		btnCircle.setBounds(15, 33, 115, 29);
		f.getContentPane().add(btnCircle);
		btnLine = new JButton("line");
		btnLine.setBounds(15, 92, 115, 29);
		f.getContentPane().add(btnLine);
		btnRectangle = new JButton("box");
		btnRectangle.setBounds(15, 155, 115, 29);
		f.getContentPane().add(btnRectangle);
		btnUndo = new JButton("undo");
		btnUndo.setBounds(15, 216, 115, 29);
		f.getContentPane().add(btnUndo);
		btnRedo = new JButton("redo");
		btnRedo.setBounds(15, 276, 115, 29);
		f.getContentPane().add(btnRedo);
		f.getContentPane().add(panel);
	}
}

package Main;

import Service.DrawingService;
import contoller.DrawingController;
import gui.GUI;

public class RunApplication {

	public static void main(String args[]) {
		
		GUI gui = new GUI();
		gui.constructGUI();
		DrawingService service = new DrawingService();
		DrawingController controller = new DrawingController(gui, service);
		controller.start();
	}
}

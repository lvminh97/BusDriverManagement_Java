package app;

import controller.HomeController;
import handler.DatabaseHandler;

public class Application {

	public static void main(String[] args) {
		DatabaseHandler.initialize();
//		new LoginController();
		new HomeController();
	}
	
}

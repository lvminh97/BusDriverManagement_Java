package app;

import controller.LoginController;
import handler.DatabaseHandler;

public class Application {

	public static void main(String[] args) {
		DatabaseHandler.initialize();
		new LoginController();
	}
	
}

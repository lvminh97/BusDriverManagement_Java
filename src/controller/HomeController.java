package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.driver.DriverManageController;
import view.HomeView;

public class HomeController implements ActionListener {

	public static HomeView view;
	
	public HomeController() {
		view = new HomeView();
		view.getDriverManageButton().addActionListener(this);
		view.getRouteManageButton().addActionListener(this);
		view.getStopStationManageButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getDriverManageButton()) {
			view.dispose();
			new DriverManageController();
		}
		else if(e.getSource() == view.getRouteManageButton()) {
			
		}
		else if(e.getSource() == view.getStopStationManageButton()) {
			
		}
	}
	
}

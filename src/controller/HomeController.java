package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.driver.DriverManageController;
import controller.license.LicenseManageController;
import controller.route.RouteManageController;
import controller.stopstation.StopStationManageController;
import view.HomeView;

public class HomeController implements ActionListener {

	public static HomeView view;
	
	public HomeController() {
		view = new HomeView();
		view.getDriverManageButton().addActionListener(this);
		view.getRouteManageButton().addActionListener(this);
		view.getStopStationManageButton().addActionListener(this);
		view.getLicenseManageButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getDriverManageButton()) {
			view.dispose();
			new DriverManageController();
		}
		else if(e.getSource() == view.getRouteManageButton()) {
			view.dispose();
			new RouteManageController();
		}
		else if(e.getSource() == view.getStopStationManageButton()) {
			view.dispose();
			new StopStationManageController();
		}
		else if(e.getSource() == view.getLicenseManageButton()) {
			view.dispose();
			new LicenseManageController();
		}
	}
	
}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.DriverHandler;
import handler.LicenseHandler;
import handler.RouteHandler;
import model.Driver;
import view.EditDriverView;

public class EditDriverController implements ActionListener {

	private static EditDriverView view;
	private Driver driver;
	
	public EditDriverController(Driver driver) {
		view = new EditDriverView();
		this.driver = driver;
		view.getNameTf().setText(driver.getName());
		view.getPhoneTf().setText(driver.getPhone());
		view.getRouteCb().setSelectedIndex(RouteHandler.getList().stream().map(x -> x.getId()).toList().indexOf(driver.getRouteId()));
		view.getLicenseCb().setSelectedIndex(LicenseHandler.getList().stream().map(x -> x.getId()).toList().indexOf(driver.getLicenseId()));
		view.getupdateBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getupdateBtn()) {
			this.driver.setName(view.getNameTf().getText());
			this.driver.setPhone(view.getPhoneTf().getText());
			this.driver.setRouteId(RouteHandler.getList().get(view.getRouteCb().getSelectedIndex()).getId());
			this.driver.setLicense(LicenseHandler.getList().get(view.getLicenseCb().getSelectedIndex()).getId());
			if(DriverHandler.update(this.driver)) {
				view.dispose();
				DriverManageController.updateTable();
			}
		}
	}
	
}

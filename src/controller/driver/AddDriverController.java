package controller.driver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.DriverHandler;
import handler.LicenseHandler;
import model.Driver;
import view.driver.AddDriverView;

public class AddDriverController implements ActionListener {

	public static AddDriverView view;
	
	public AddDriverController() {
		view = new AddDriverView();
		view.getAddBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			Driver driver = new Driver(0,
					view.getNameTf().getText(),
					view.getPhoneTf().getText(),
					LicenseHandler.getList().get(view.getLicenseCb().getSelectedIndex()).getId());
			if(DriverHandler.add(driver)) {
				view.dispose();
				DriverManageController.updateTable();
			}
		}
	}
	
}

package controller.license;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.LicenseHandler;
import model.License;
import view.license.AddLicenseView;

public class AddLicenseController implements ActionListener {

	public static AddLicenseView view;
	
	public AddLicenseController() {
		view = new AddLicenseView();
		view.getAddBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			License license = new License(0,
					view.getNameTf().getText(), 
					(int) view.getLevelSpn().getValue());
			if(LicenseHandler.add(license)) {
				view.dispose();
				LicenseManageController.updateTable();
			}
		}
	}
	
}

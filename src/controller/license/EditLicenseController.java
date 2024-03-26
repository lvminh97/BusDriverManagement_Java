package controller.license;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.LicenseHandler;
import model.License;
import view.license.EditLicenseView;

public class EditLicenseController implements ActionListener {

	private static EditLicenseView view;
	private License license;
	
	public EditLicenseController(License license) {
		view = new EditLicenseView();
		this.license = license;
		view.getNameTf().setText(license.getName());
		view.getLevelSpn().setValue(license.getLevel());
		view.getupdateBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getupdateBtn()) {
			this.license.setName(view.getNameTf().getText());
			this.license.setLevel((int) view.getLevelSpn().getValue());
			if(LicenseHandler.update(this.license)) {
				view.dispose();
				LicenseManageController.updateTable();
			}
		}
	}
	
}

package controller.stopstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.StopStationHandler;
import model.StopStation;
import view.stopstation.EditStopStationView;

public class EditStopStationController implements ActionListener {

	private static EditStopStationView view;
	private StopStation station;
	
	public EditStopStationController(StopStation station) {
		view = new EditStopStationView();
		this.station = station;
		view.getNameTf().setText(station.getName());
		view.getAddressTA().setText(station.getAddress());
		view.getupdateBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getupdateBtn()) {
			this.station.setName(view.getNameTf().getText());
			this.station.setAddress(view.getAddressTA().getText());
			if(StopStationHandler.update(this.station)) {
				view.dispose();
				StopStationManageController.updateTable();
			}
		}
	}
	
}

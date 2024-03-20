package controller.stopstation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.StopStationHandler;
import model.StopStation;
import view.stopstation.AddStopStationView;

public class AddStopStationController implements ActionListener {

	public static AddStopStationView view;
	
	public AddStopStationController() {
		view = new AddStopStationView();
		view.getAddBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			StopStation station = new StopStation(0,
					view.getNameTf().getText(), 
					view.getAddressTA().getText());
			if(StopStationHandler.add(station)) {
				view.dispose();
				StopStationManageController.updateTable();
			}
		}
	}
	
}

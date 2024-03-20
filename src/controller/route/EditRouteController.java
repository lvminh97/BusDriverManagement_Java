package controller.route;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.RouteHandler;
import model.Route;
import view.route.EditRouteView;

public class EditRouteController implements ActionListener {

	private static EditRouteView view;
	private Route route;
	
	public EditRouteController(Route route) {
		view = new EditRouteView();
		this.route = route;
		view.getNameTf().setText(route.getName());
		view.getDescriptionTA().setText(route.getDescription());
		view.getupdateBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getupdateBtn()) {
			this.route.setName(view.getNameTf().getText());
			this.route.setDescription(view.getDescriptionTA().getText());
			if(RouteHandler.update(this.route)) {
				view.dispose();
				RouteManageController.updateTable();
			}
		}
	}
	
}

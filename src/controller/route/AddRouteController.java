package controller.route;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import handler.RouteHandler;
import model.Route;
import view.route.AddRouteView;

public class AddRouteController implements ActionListener {

	public static AddRouteView view;
	
	public AddRouteController() {
		view = new AddRouteView();
		view.getAddBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			Route route = new Route(0,
					view.getNameTf().getText(), 
					view.getDescriptionTA().getText());
			if(RouteHandler.add(route)) {
				view.dispose();
				RouteManageController.updateTable();
			}
		}
	}
	
}

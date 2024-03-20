package controller.route;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controller.HomeController;
import handler.RouteHandler;
import model.Route;
import view.route.RouteManageView;

public class RouteManageController implements ActionListener, PopupMenuListener {

	private static RouteManageView view;
	private static ArrayList<Route> routeList;
	private int rowAtPoint = 0;
	
	public RouteManageController() {
		view = new RouteManageView();
		updateTable();
		view.getAddRouteBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getEditMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
		view.getBackBtn().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddRouteBtn()) {
			new AddRouteController();
		}
		else if(e.getSource() == view.getEditMenuItem()) {
			new EditRouteController(routeList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa tuyến xe này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(RouteHandler.delete(routeList.get(rowAtPoint).getId())) {
					routeList = RouteHandler.getList();
					view.update(routeList);
				}
			}
		}
		else if(e.getSource() == view.getBackBtn()) {
			view.dispose();
			new HomeController();
		}
	}

	public static void updateTable() {
		routeList = RouteHandler.getList();
		view.update(routeList);
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rowAtPoint = view.getRouteListTable().rowAtPoint(SwingUtilities.convertPoint(
						view.getPopup(), new Point(0, 0), view.getRouteListTable()));
				if(rowAtPoint > -1) {
					view.getRouteListTable().setRowSelectionInterval(rowAtPoint, rowAtPoint);
				}
			}
		});
	}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

package controller.driver;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import handler.DriverHandler;
import handler.RouteHandler;
import handler.StopStationHandler;
import model.Driver;
import model.Route;
import model.StopStation;
import view.driver.RouteByDriverManageView;
import view.route.StationByRouteManageView;

public class RouteByDriverManageController implements ActionListener, PopupMenuListener{

	private static RouteByDriverManageView view;
	private Driver driver;
	private static ArrayList<Route> routeList;
	private int rowAtPoint = 0;
	
	public RouteByDriverManageController(Driver driver) {
		this.driver = driver;
		view = new RouteByDriverManageView(driver);
		updateTable(driver);
		view.getAddBtn().addActionListener(this);
		view.getBackBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getDeleteMenuItem().addActionListener(this);
	}
	
	public static void updateTable(Driver driver) {
		routeList = RouteHandler.getListByDriver(driver.getId());
		view.update(routeList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			if(DriverHandler.addRoute(this.driver.getId(), 
					RouteHandler.getList().get(view.getRouteCb().getSelectedIndex()).getId(), (int) view.getTurnNumberSpn().getValue())
			) {
				routeList = RouteHandler.getListByDriver(this.driver.getId());
				view.update(routeList);
			}
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa tuyến này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(DriverHandler.deleteRoute(this.driver.getId(), routeList.get(rowAtPoint).getId())) {
					routeList = RouteHandler.getListByDriver(this.driver.getId());
					view.update(routeList);
				}
			}
		}
		else if(e.getSource() == view.getBackBtn()) {
			view.dispose();
		}
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

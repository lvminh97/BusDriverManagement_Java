package controller.driver;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controller.HomeController;
import handler.DriverHandler;
import handler.LicenseHandler;
import handler.RouteHandler;
import model.Driver;
import view.driver.DriverManageView;

public class DriverManageController implements ActionListener, PopupMenuListener {

	private static DriverManageView view;
	private static ArrayList<Driver> driverList;
	private int rowAtPoint = 0;
	
	public DriverManageController() {
		view = new DriverManageView();
		updateTable();
		view.getAddDriverBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getEditMenuItem().addActionListener(this);
		view.getRouteMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
		view.getBackBtn().addActionListener(this);
		view.getSearchBtn().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddDriverBtn()) {
			new AddDriverController();
		}
		else if(e.getSource() == view.getEditMenuItem()) {
			new EditDriverController(driverList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getRouteMenuItem()) {
			new RouteByDriverManageController(driverList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa tài xế này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(DriverHandler.delete(driverList.get(rowAtPoint).getId())) {
					driverList = DriverHandler.getList();
					view.update(driverList, RouteHandler.getMap(), LicenseHandler.getMap());
				}
			}
		}
		else if(e.getSource() == view.getSearchBtn()) {
			driverList = DriverHandler.search(view.getSearchTf().getText());
			view.update(driverList, RouteHandler.getMap(), LicenseHandler.getMap());
		}
		else if(e.getSource() == view.getBackBtn()) {
			view.dispose();
			new HomeController();
		}
	}

	public static void updateTable() {
		driverList = DriverHandler.getList();
		view.update(driverList, RouteHandler.getMap(), LicenseHandler.getMap());
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rowAtPoint = view.getDriverListTable().rowAtPoint(SwingUtilities.convertPoint(
						view.getPopup(), new Point(0, 0), view.getDriverListTable()));
				if(rowAtPoint > -1) {
					view.getDriverListTable().setRowSelectionInterval(rowAtPoint, rowAtPoint);
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

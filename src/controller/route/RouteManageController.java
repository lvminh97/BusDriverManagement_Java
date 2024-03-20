package controller.route;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import handler.RouteHandler;
import model.Route;
import view.route.RouteManageView;

public class RouteManageController implements ActionListener, PopupMenuListener {

	private static RouteManageView view;
	private static ArrayList<Route> licenseList;
	private int rowAtPoint = 0;
	
	public RouteManageController() {
		view = new RouteManageView();
		updateTable();
		view.getAddRouteBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getEditMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddRouteBtn()) {
			new AddRouteController();
		}
		else if(e.getSource() == view.getEditMenuItem()) {
			new EditRouteController(licenseList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa bằng này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(RouteHandler.delete(licenseList.get(rowAtPoint).getId())) {
					licenseList = RouteHandler.getList();
					view.update(RouteHandler.getList());
				}
			}
		}
	}

	public static void updateTable() {
		licenseList = RouteHandler.getList();
		view.update(RouteHandler.getList());
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

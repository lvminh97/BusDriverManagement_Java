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
import handler.StopStationHandler;
import model.Route;
import model.StopStation;
import view.route.StationByRouteManageView;

public class StationByRouteManageController implements ActionListener, PopupMenuListener{

	private static StationByRouteManageView view;
	private Route route;
	private static ArrayList<StopStation> stationList;
	private int rowAtPoint = 0;
	
	public StationByRouteManageController(Route route) {
		this.route = route;
		view = new StationByRouteManageView(route);
		updateTable(route);
		view.getAddBtn().addActionListener(this);
		view.getBackBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getDeleteMenuItem().addActionListener(this);
	}
	
	public static void updateTable(Route route) {
		stationList = StopStationHandler.getListByRoute(route.getId());
		view.update(stationList);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddBtn()) {
			if(RouteHandler.addStation(this.route.getId(), 
					StopStationHandler.getList().get(view.getStationCb().getSelectedIndex()).getId())
			) {
				stationList = StopStationHandler.getListByRoute(this.route.getId());
				view.update(stationList);
			}
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc chắn muốn xóa điểm dừng này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(RouteHandler.deleteStation(this.route.getId(), stationList.get(rowAtPoint).getId())) {
					stationList = StopStationHandler.getListByRoute(this.route.getId());
					view.update(stationList);
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
				rowAtPoint = view.getStationListTable().rowAtPoint(SwingUtilities.convertPoint(
						view.getPopup(), new Point(0, 0), view.getStationListTable()));
				if(rowAtPoint > -1) {
					view.getStationListTable().setRowSelectionInterval(rowAtPoint, rowAtPoint);
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

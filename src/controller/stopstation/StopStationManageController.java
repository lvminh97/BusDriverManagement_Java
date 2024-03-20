package controller.stopstation;

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
import handler.StopStationHandler;
import model.StopStation;
import view.stopstation.StopStationManageView;

public class StopStationManageController implements ActionListener, PopupMenuListener {

	private static StopStationManageView view;
	private static ArrayList<StopStation> stationList;
	private int rowAtPoint = 0;
	
	public StopStationManageController() {
		view = new StopStationManageView();
		updateTable();
		view.getAddStopStationBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getEditMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
		view.getBackBtn().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddStopStationBtn()) {
			new AddStopStationController();
		}
		else if(e.getSource() == view.getEditMenuItem()) {
			new EditStopStationController(stationList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa điểm dừng này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(RouteHandler.delete(stationList.get(rowAtPoint).getId())) {
					stationList = StopStationHandler.getList();
					view.update(stationList);
				}
			}
		}
		else if(e.getSource() == view.getBackBtn()) {
			view.dispose();
			new HomeController();
		}
	}

	public static void updateTable() {
		stationList = StopStationHandler.getList();
		view.update(stationList);
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rowAtPoint = view.getstopStationListTable().rowAtPoint(SwingUtilities.convertPoint(
						view.getPopup(), new Point(0, 0), view.getstopStationListTable()));
				if(rowAtPoint > -1) {
					view.getstopStationListTable().setRowSelectionInterval(rowAtPoint, rowAtPoint);
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

package controller.license;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import controller.HomeController;
import handler.LicenseHandler;
import model.License;
import view.license.LicenseManageView;

public class LicenseManageController implements ActionListener, PopupMenuListener {

	private static LicenseManageView view;
	private static ArrayList<License> licenseList;
	private int rowAtPoint = 0;
	
	public LicenseManageController() {
		view = new LicenseManageView();
		updateTable();
		view.getAddLicenseBtn().addActionListener(this);
		view.getPopup().addPopupMenuListener(this);
		view.getEditMenuItem().addActionListener(this);
		view.getDeleteMenuItem().addActionListener(this);
		view.getBackBtn().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getAddLicenseBtn()) {
			new AddLicenseController();
		}
		else if(e.getSource() == view.getEditMenuItem()) {
			new EditLicenseController(licenseList.get(rowAtPoint));
		}
		else if(e.getSource() == view.getDeleteMenuItem()) {
			int cf = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn xóa bằng này?", "Cảnh báo",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			if(cf == JOptionPane.YES_OPTION) {
				if(LicenseHandler.delete(licenseList.get(rowAtPoint).getId())) {
					licenseList = LicenseHandler.getList();
					view.update(licenseList);
				}
			}
		}
		else if(e.getSource() == view.getBackBtn()) {
			view.dispose();
			new HomeController();
		}
	}

	public static void updateTable() {
		licenseList = LicenseHandler.getList();
		view.update(licenseList);
	}

	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				rowAtPoint = view.getLicenseListTable().rowAtPoint(SwingUtilities.convertPoint(
						view.getPopup(), new Point(0, 0), view.getLicenseListTable()));
				if(rowAtPoint > -1) {
					view.getLicenseListTable().setRowSelectionInterval(rowAtPoint, rowAtPoint);
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

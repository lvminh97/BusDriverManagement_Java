package view.driver;

import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Driver;
import model.License;
import model.Route;

public class DriverManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField searchTf;
	private JButton searchBtn, addDriverBtn, backBtn;
	private JTable driverListTable;
	private DefaultTableModel driverListModel;
	private JPopupMenu popup;
	private JMenuItem editMenuItem, deleteMenuItem;
	
	public DriverManageView() {
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH TÀI XẾ");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		
		this.backBtn = new JButton("Quay lại");
		this.backBtn.setSize(100, 30);
		this.backBtn.setLocation(760, 30);
		this.add(this.backBtn);
		
		this.searchTf = new JTextField();
		this.searchTf.setSize(500, 30);
		this.searchTf.setLocation(60, 120);
		this.add(this.searchTf);
		
		this.searchBtn = new JButton("Tìm kiếm");
		this.searchBtn.setSize(100, 30);
		this.searchBtn.setLocation(580, 120);
		this.add(this.searchBtn);
		
		this.addDriverBtn = new JButton("Thêm tài xế");
		this.addDriverBtn.setSize(150, 30);
		this.addDriverBtn.setLocation(710, 120);
		this.add(this.addDriverBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 520);
		scrollPane.setLocation(60, 200);
		this.add(scrollPane);
		
		this.driverListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.driverListTable.setSize(800, 520);
		this.driverListTable.setLocation(60, 230);
		this.driverListTable.setModel(driverListModel);
		this.driverListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.driverListTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.driverListTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.driverListTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		this.driverListTable.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPane.setViewportView(this.driverListTable);
		
		this.popup = new JPopupMenu();
		this.editMenuItem = new JMenuItem("Chỉnh sửa");
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.editMenuItem);
		this.popup.add(this.deleteMenuItem);
		this.driverListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Họ tên", "Số điện thoại", "Tuyến xe", "Bằng lái xe"	
		};
		driverListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<Driver> driverList, HashMap<Integer, Route> routeMap, HashMap<Integer, License> licenseMap) {
		driverListModel.setRowCount(0);
		
		for(Driver item: driverList) {
			driverListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(), 
				item.getPhone(), 
				routeMap.get(item.getRouteId()).getName(), 
				licenseMap.get(item.getLicenseId()).getName()
			});
		}
	}
	
	public JTable getDriverListTable() {
		return driverListTable;
	}

	public DefaultTableModel getDriverListModel() {
		return driverListModel;
	}

	public void setDriverListModel(DefaultTableModel driverListModel) {
		this.driverListModel = driverListModel;
	}
	
	public JTextField getSearchTf() {
		return searchTf;
	}

	public JButton getAddDriverBtn() {
		return addDriverBtn;
	}
	
	public JButton getSearchBtn() {
		return searchBtn;
	}

	public JButton getBackBtn() {
		return backBtn;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public JMenuItem getEditMenuItem() {
		return editMenuItem;
	}

	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}
	
}

package view.route;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import handler.StopStationHandler;
import model.Route;
import model.StopStation;

public class StationByRouteManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JComboBox<String> stationCb;
	private JButton addBtn, backBtn;
	private JTable StationListTable;
	private DefaultTableModel StationListModel;
	private JPopupMenu popup;
	private JMenuItem deleteMenuItem;
	
	private Route route;
	
	public StationByRouteManageView(Route route) {
		this.route = route;
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH ĐIỂM DỪNG THEO TUYẾN");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 50);
		this.add(lbl1);
		
		this.backBtn = new JButton("Đóng");
		this.backBtn.setSize(100, 30);
		this.backBtn.setLocation(760, 30);
		this.add(this.backBtn);
		
		JLabel lbl2 = new JLabel("Tuyến: " + this.route.getName());
		lbl2.setFont(new Font(lbl2.getFont().getName(), Font.PLAIN, 15));
		lbl2.setLocation(60, 80);
		lbl2.setSize(100, 30);
		this.add(lbl2);
		
		this.stationCb = new JComboBox<String>();
		this.stationCb.setSize(500, 30);
		this.stationCb.setLocation(60, 150);
		this.add(this.stationCb);
		for(StopStation station: StopStationHandler.getList()) {
			this.stationCb.addItem(station.getName());
		}
		
		this.addBtn = new JButton("Thêm");
		this.addBtn.setSize(150, 30);
		this.addBtn.setLocation(600, 150);
		this.add(this.addBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 500);
		scrollPane.setLocation(60, 230);
		this.add(scrollPane);
		
		this.StationListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.StationListTable.setSize(800, 500);
		this.StationListTable.setLocation(60, 230);
		this.StationListTable.setModel(StationListModel);
		this.StationListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.StationListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.StationListTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		scrollPane.setViewportView(this.StationListTable);
		
		this.popup = new JPopupMenu();
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.deleteMenuItem);
		this.StationListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Điểm dừng", "Địa chỉ",	
		};
		StationListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<StopStation> stations) {
		StationListModel.setRowCount(0);
		
		for(StopStation item: stations) {
			StationListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(),
				item.getAddress()
			});
		}
	}
	
	public JTable getStationListTable() {
		return StationListTable;
	}

	public DefaultTableModel getStationListModel() {
		return StationListModel;
	}

	public void setStationListModel(DefaultTableModel StationListModel) {
		this.StationListModel = StationListModel;
	}
	
	public JComboBox<String> getStationCb() {
		return stationCb;
	}

	public JButton getAddBtn() {
		return addBtn;
	}
	
	public JButton getBackBtn() {
		return backBtn;
	}

	public JPopupMenu getPopup() {
		return popup;
	}

	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}
	
}

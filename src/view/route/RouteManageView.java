package view.route;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Route;

public class RouteManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField searchTf;
	private JButton searchBtn, addRouteBtn, backBtn;
	private JTable RouteListTable;
	private DefaultTableModel RouteListModel;
	private JPopupMenu popup;
	private JMenuItem editMenuItem, stationMenuItem, deleteMenuItem;
	
	public RouteManageView() {
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH TUYẾN XE");
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
		
		this.addRouteBtn = new JButton("Thêm tuyến");
		this.addRouteBtn.setSize(150, 30);
		this.addRouteBtn.setLocation(710, 120);
		this.add(this.addRouteBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 520);
		scrollPane.setLocation(60, 200);
		this.add(scrollPane);
		
		this.RouteListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.RouteListTable.setSize(800, 520);
		this.RouteListTable.setLocation(60, 230);
		this.RouteListTable.setModel(RouteListModel);
		this.RouteListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.RouteListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.RouteListTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		scrollPane.setViewportView(this.RouteListTable);
		
		this.popup = new JPopupMenu();
		this.editMenuItem = new JMenuItem("Chỉnh sửa");
		this.stationMenuItem = new JMenuItem("Các điểm dừng");
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.editMenuItem);
		this.popup.add(this.stationMenuItem);
		this.popup.add(this.deleteMenuItem);
		this.RouteListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Tên tuyến", "Mô tả",	
		};
		RouteListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<Route> routeList) {
		RouteListModel.setRowCount(0);
		
		for(Route item: routeList) {
			RouteListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(),
				item.getDescription()
			});
		}
	}
	
	public JTable getRouteListTable() {
		return RouteListTable;
	}

	public DefaultTableModel getRouteListModel() {
		return RouteListModel;
	}

	public void setRouteListModel(DefaultTableModel RouteListModel) {
		this.RouteListModel = RouteListModel;
	}

	public JButton getAddRouteBtn() {
		return addRouteBtn;
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
	
	public JMenuItem getStationMenuItem() {
		return stationMenuItem;
	}

	public JMenuItem getDeleteMenuItem() {
		return deleteMenuItem;
	}
	
}

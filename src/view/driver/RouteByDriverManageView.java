package view.driver;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import handler.RouteHandler;
import model.Driver;
import model.Route;

public class RouteByDriverManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JComboBox<String> routeCb;
	private JSpinner turnNumberSpn;
	private JButton addBtn, backBtn;
	private JTable routeListTable;
	private DefaultTableModel routeListModel;
	private JPopupMenu popup;
	private JMenuItem deleteMenuItem;
	
	private Driver driver;
	
	public RouteByDriverManageView(Driver driver) {
		this.driver = driver;
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH TUYẾN XE THEO TÀI XẾ");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 50);
		this.add(lbl1);
		
		this.backBtn = new JButton("Đóng");
		this.backBtn.setSize(100, 30);
		this.backBtn.setLocation(760, 30);
		this.add(this.backBtn);
		
		JLabel lbl2 = new JLabel("Tài xế: " + this.driver.getName());
		lbl2.setFont(new Font(lbl2.getFont().getName(), Font.PLAIN, 15));
		lbl2.setLocation(60, 80);
		lbl2.setSize(400, 30);
		this.add(lbl2);
		
		this.routeCb = new JComboBox<String>();
		this.routeCb.setSize(450, 30);
		this.routeCb.setLocation(60, 150);
		this.add(this.routeCb);
		for(Route route: RouteHandler.getList()) {
			this.routeCb.addItem(route.getName() + " - " + route.getDescription());
		}
		
		JLabel lbl3 = new JLabel("Số lượt");
		lbl3.setSize(100, 30);
		lbl3.setLocation(540, 150);
		this.add(lbl3);
		
		this.turnNumberSpn = new JSpinner(new SpinnerNumberModel(1, 1, 17, 1));
		this.turnNumberSpn.setSize(70, 30);
		this.turnNumberSpn.setLocation(600, 150);
		this.add(this.turnNumberSpn);
		
		this.addBtn = new JButton("Thêm");
		this.addBtn.setSize(150, 30);
		this.addBtn.setLocation(710, 150);
		this.add(this.addBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 500);
		scrollPane.setLocation(60, 230);
		this.add(scrollPane);
		
		this.routeListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.routeListTable.setSize(800, 500);
		this.routeListTable.setLocation(60, 230);
		this.routeListTable.setModel(routeListModel);
		this.routeListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.routeListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.routeListTable.getColumnModel().getColumn(2).setPreferredWidth(200);
		scrollPane.setViewportView(this.routeListTable);
		
		this.popup = new JPopupMenu();
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.deleteMenuItem);
		this.routeListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Tuyến xe", "Số lượt",	
		};
		routeListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<Route> routes) {
		routeListModel.setRowCount(0);
		
		for(Route item: routes) {
			routeListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(),
				item.getTurnNumber()
			});
		}
	}
	
	public JTable getRouteListTable() {
		return routeListTable;
	}

	public DefaultTableModel getRouteListModel() {
		return routeListModel;
	}

	public void setrouteListModel(DefaultTableModel routeListModel) {
		this.routeListModel = routeListModel;
	}
	
	public JComboBox<String> getRouteCb() {
		return routeCb;
	}
	
	public JSpinner getTurnNumberSpn() {
		return turnNumberSpn;
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

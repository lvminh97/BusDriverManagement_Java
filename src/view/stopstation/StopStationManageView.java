package view.stopstation;

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

import model.StopStation;

public class StopStationManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField searchTf;
	private JButton searchBtn, addStopStationBtn;
	private JTable stopStationListTable;
	private DefaultTableModel stopStationListModel;
	private JPopupMenu popup;
	private JMenuItem editMenuItem, deleteMenuItem;
	
	public StopStationManageView() {
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH ĐIỂM DỪNG");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		
		this.searchTf = new JTextField();
		this.searchTf.setSize(500, 30);
		this.searchTf.setLocation(60, 120);
		this.add(this.searchTf);
		
		this.searchBtn = new JButton("Tìm kiếm");
		this.searchBtn.setSize(100, 30);
		this.searchBtn.setLocation(580, 120);
		this.add(this.searchBtn);
		
		this.addStopStationBtn = new JButton("Thêm điểm dừng");
		this.addStopStationBtn.setSize(150, 30);
		this.addStopStationBtn.setLocation(710, 120);
		this.add(this.addStopStationBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 520);
		scrollPane.setLocation(60, 200);
		this.add(scrollPane);
		
		this.stopStationListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.stopStationListTable.setSize(800, 520);
		this.stopStationListTable.setLocation(60, 230);
		this.stopStationListTable.setModel(stopStationListModel);
		this.stopStationListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.stopStationListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.stopStationListTable.getColumnModel().getColumn(2).setPreferredWidth(300);
		scrollPane.setViewportView(this.stopStationListTable);
		
		this.popup = new JPopupMenu();
		this.editMenuItem = new JMenuItem("Chỉnh sửa");
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.editMenuItem);
		this.popup.add(this.deleteMenuItem);
		this.stopStationListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Điểm dừng", "Địa chỉ"	
		};
		stopStationListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<StopStation> routeList) {
		stopStationListModel.setRowCount(0);
		
		for(StopStation item: routeList) {
			stopStationListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(),
				item.getAddress()
			});
		}
	}
	
	public JTable getstopStationListTable() {
		return stopStationListTable;
	}

	public DefaultTableModel getstopStationListModel() {
		return stopStationListModel;
	}

	public void setstopStationListModel(DefaultTableModel stopStationListModel) {
		this.stopStationListModel = stopStationListModel;
	}

	public JButton getAddStopStationBtn() {
		return addStopStationBtn;
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

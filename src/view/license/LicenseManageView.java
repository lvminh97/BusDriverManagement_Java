package view.license;

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

import model.License;

public class LicenseManageView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField searchTf;
	private JButton searchBtn, addLicenseBtn;
	private JTable LicenseListTable;
	private DefaultTableModel LicenseListModel;
	private JPopupMenu popup;
	private JMenuItem editMenuItem, deleteMenuItem;
	
	public LicenseManageView() {
		initTableModel();
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(950, 800);
		this.setLocation(100, 100);
		
		JLabel lbl1 = new JLabel("QUẢN LÝ DANH SÁCH BẰNG");
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
		
		this.addLicenseBtn = new JButton("Thêm bằng");
		this.addLicenseBtn.setSize(150, 30);
		this.addLicenseBtn.setLocation(710, 120);
		this.add(this.addLicenseBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(800, 520);
		scrollPane.setLocation(60, 200);
		this.add(scrollPane);
		
		this.LicenseListTable = new JTable() {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		this.LicenseListTable.setSize(800, 520);
		this.LicenseListTable.setLocation(60, 230);
		this.LicenseListTable.setModel(LicenseListModel);
		this.LicenseListTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		this.LicenseListTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.LicenseListTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.LicenseListTable.getColumnModel().getColumn(3).setPreferredWidth(50);
		this.LicenseListTable.getColumnModel().getColumn(4).setPreferredWidth(50);
		scrollPane.setViewportView(this.LicenseListTable);
		
		this.popup = new JPopupMenu();
		this.editMenuItem = new JMenuItem("Chỉnh sửa");
		this.deleteMenuItem = new JMenuItem("Xóa");
		this.popup.add(this.editMenuItem);
		this.popup.add(this.deleteMenuItem);
		this.LicenseListTable.setComponentPopupMenu(this.popup);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	private void initTableModel() {
		String[] columns = {
			"ID", "Họ tên", "Số điện thoại", "Tuyến xe", "Bằng lái xe"	
		};
		LicenseListModel = new DefaultTableModel(columns, 0);
	}
	
	public void update(ArrayList<License> LicenseList) {
		LicenseListModel.setRowCount(0);
		
		for(License item: LicenseList) {
			LicenseListModel.addRow(new Object[] {
				item.getId(), 
				item.getName(),
				item.getLevel()
			});
		}
	}
	
	public JTable getLicenseListTable() {
		return LicenseListTable;
	}

	public DefaultTableModel getLicenseListModel() {
		return LicenseListModel;
	}

	public void setLicenseListModel(DefaultTableModel LicenseListModel) {
		this.LicenseListModel = LicenseListModel;
	}

	public JButton getAddLicenseBtn() {
		return addLicenseBtn;
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

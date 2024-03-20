package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import handler.LicenseHandler;
import handler.RouteHandler;
import model.License;
import model.Route;

public class EditDriverView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField nameTf, phoneTf;
	private JComboBox<String> routeCb, licenseCb;
	private JButton updateBtn;
	
	public EditDriverView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(600, 450);
		this.setLocation(400, 200);
		
		JLabel lbl1 = new JLabel("CẬP NHẬT THÔNG TIN TÀI XẾ");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		
		JLabel lbl2 = new JLabel("Họ tên");
		lbl2.setSize(100, 30);
		lbl2.setLocation(60, 120);
		this.add(lbl2);
		
		this.nameTf = new JTextField();
		this.nameTf.setSize(250, 30);
		this.nameTf.setLocation(180, 120);
		this.add(this.nameTf);
		
		JLabel lbl3 = new JLabel("Số điện thoại");
		lbl3.setSize(100, 30);
		lbl3.setLocation(60, 160);
		this.add(lbl3);
		
		this.phoneTf = new JTextField();
		this.phoneTf.setSize(250, 30);
		this.phoneTf.setLocation(180, 160);
		this.add(this.phoneTf);
		
		JLabel lbl4 = new JLabel("Tuyến xe");
		lbl4.setSize(100, 30);
		lbl4.setLocation(60, 200);
		this.add(lbl4);
		
		this.routeCb = new JComboBox<String>();
		for(Route x: RouteHandler.getList()) {
			this.routeCb.addItem(x.getName());
		}
		this.routeCb.setSize(250, 30);
		this.routeCb.setLocation(180, 200);
		this.add(this.routeCb);
		
		JLabel lbl5 = new JLabel("Bằng lái xe");
		lbl5.setSize(100, 30);
		lbl5.setLocation(60, 240);
		this.add(lbl5);
		
		this.licenseCb = new JComboBox<String>();
		for(License x: LicenseHandler.getList()) {
			this.licenseCb.addItem(x.getName());
		}
		this.licenseCb.setSize(250, 30);
		this.licenseCb.setLocation(180, 240);
		this.add(this.licenseCb);
		
		this.updateBtn = new JButton("Cập nhật");
		this.updateBtn.setSize(120, 40);
		this.updateBtn.setLocation(240, 300);
		this.add(this.updateBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public JTextField getNameTf() {
		return nameTf;
	}

	public JTextField getPhoneTf() {
		return phoneTf;
	}

	public JComboBox<String> getRouteCb() {
		return routeCb;
	}

	public JComboBox<String> getLicenseCb() {
		return licenseCb;
	}

	public JButton getupdateBtn() {
		return updateBtn;
	}

}

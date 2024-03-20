package view.route;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditRouteView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField nameTf;
	private JTextArea descriptionTA;
	private JButton updateBtn;
	
	
	public EditRouteView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(600, 450);
		this.setLocation(400, 200);
		
		JLabel lbl1 = new JLabel("CẬP NHẬT TUYẾN ĐƯỜNG");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		
		JLabel lbl2 = new JLabel("Tên tuyến");
		lbl2.setSize(100, 30);
		lbl2.setLocation(60, 120);
		this.add(lbl2);
		
		this.nameTf = new JTextField();
		this.nameTf.setSize(250, 30);
		this.nameTf.setLocation(180, 120);
		this.add(this.nameTf);
		
		JLabel lbl3 = new JLabel("Mô tả");
		lbl3.setSize(100, 30);
		lbl3.setLocation(60, 160);
		this.add(lbl3);
		
		this.descriptionTA = new JTextArea();
		this.descriptionTA.setSize(250, 100);
		this.descriptionTA.setLocation(180, 160);
		this.add(this.descriptionTA);
		
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
	
	public JTextArea getDescriptionTA() {
		return descriptionTA;
	}

	public JButton getupdateBtn() {
		return updateBtn;
	}

}

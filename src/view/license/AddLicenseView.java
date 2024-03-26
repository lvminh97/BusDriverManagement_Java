package view.license;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class AddLicenseView extends JFrame{
	
	private static final long serialVersionUID = -6961589024995658110L;
	
	private JTextField nameTf;
	private JSpinner levelSpn;
	private JButton addBtn;
	
	public AddLicenseView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(600, 450);
		this.setLocation(400, 200);
		
		JLabel lbl1 = new JLabel("THÊM BẰNG");
		lbl1.setFont(new Font(lbl1.getFont().getName(), Font.BOLD, 20));
		lbl1.setLocation(60, 10);
		lbl1.setSize(600, 80);
		this.add(lbl1);
		
		JLabel lbl2 = new JLabel("Tên bằng");
		lbl2.setSize(100, 30);
		lbl2.setLocation(60, 120);
		this.add(lbl2);
		
		this.nameTf = new JTextField();
		this.nameTf.setSize(250, 30);
		this.nameTf.setLocation(180, 120);
		this.add(this.nameTf);
		
		JLabel lbl3 = new JLabel("Trình độ");
		lbl3.setSize(100, 30);
		lbl3.setLocation(60, 160);
		this.add(lbl3);
		
		this.levelSpn = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		this.levelSpn.setSize(50, 30);
		this.levelSpn.setLocation(180, 160);
		this.add(this.levelSpn);
		
		this.addBtn = new JButton("Thêm");
		this.addBtn.setSize(120, 40);
		this.addBtn.setLocation(240, 300);
		this.add(this.addBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public JTextField getNameTf() {
		return nameTf;
	}

	public JSpinner getLevelSpn() {
		return levelSpn;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

}

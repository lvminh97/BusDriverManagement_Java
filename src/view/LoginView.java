package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 2970892591861497918L;
	
	private JLabel usernameLbl, passwordLbl;
	private JTextField usernameTf;
	private JPasswordField passwordTf;
	private JButton loginBtn;
	
	public LoginView() {
		this.initialize();
	}
	
	private void initialize() {
		this.setTitle("Phần mềm quản lý lái xe bus");
		this.setSize(600, 400);
		this.setLocation(400, 200);
		
		this.usernameLbl = new JLabel("Tên đăng nhập");
		this.usernameLbl.setSize(100, 30);
		this.usernameLbl.setLocation(100, 100);
		this.add(this.usernameLbl);
		
		this.passwordLbl = new JLabel("Mật khẩu");
		this.passwordLbl.setSize(100, 30);
		this.passwordLbl.setLocation(100, 160);
		this.add(this.passwordLbl);
		
		this.usernameTf = new JTextField();
		this.usernameTf.setSize(250, 30);
		this.usernameTf.setLocation(200, 100);
		this.add(this.usernameTf);
		
		this.passwordTf = new JPasswordField();
		this.passwordTf.setSize(250, 30);
		this.passwordTf.setLocation(200, 160);
		this.add(this.passwordTf);
		
		this.loginBtn = new JButton("Đăng nhập");
		this.loginBtn.setSize(120, 40);
		this.loginBtn.setLocation(250, 230);
		this.add(this.loginBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JTextField getUsernameTf() {
		return usernameTf;
	}

	public JPasswordField getPasswordTf() {
		return passwordTf;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

}

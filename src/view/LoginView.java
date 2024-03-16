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
		this.setSize(800, 600);
		this.setLocation(400, 200);
		
		this.usernameLbl = new JLabel("Tên đăng nhập");
		this.usernameLbl.setSize(100, 30);
		this.usernameLbl.setLocation(200, 150);
		this.add(this.usernameLbl);
		
		this.passwordLbl = new JLabel("Mật khẩu");
		this.passwordLbl.setSize(100, 30);
		this.passwordLbl.setLocation(200, 210);
		this.add(this.passwordLbl);
		
		this.usernameTf = new JTextField();
		this.usernameTf.setSize(250, 30);
		this.usernameTf.setLocation(300, 150);
		this.add(this.usernameTf);
		
		this.passwordTf = new JPasswordField();
		this.passwordTf.setSize(250, 30);
		this.passwordTf.setLocation(300, 210);
		this.add(this.passwordTf);
		
		this.loginBtn = new JButton("Đăng nhập");
		this.loginBtn.setSize(120, 40);
		this.loginBtn.setLocation(350, 280);
		this.add(this.loginBtn);
		
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	public JLabel getUsernameLbl() {
		return usernameLbl;
	}

	public void setUsernameLbl(JLabel usernameLbl) {
		this.usernameLbl = usernameLbl;
	}

	public JLabel getPasswordLbl() {
		return passwordLbl;
	}

	public void setPasswordLbl(JLabel passwordLbl) {
		this.passwordLbl = passwordLbl;
	}

	public JTextField getUsernameTf() {
		return usernameTf;
	}

	public void setUsernameTf(JTextField usernameTf) {
		this.usernameTf = usernameTf;
	}

	public JPasswordField getPasswordTf() {
		return passwordTf;
	}

	public void setPasswordTf(JPasswordField passwordTf) {
		this.passwordTf = passwordTf;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}
	
}

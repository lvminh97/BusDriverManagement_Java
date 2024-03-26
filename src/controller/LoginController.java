package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import handler.AuthHandler;
import model.Auth;
import view.LoginView;

public class LoginController implements ActionListener {

	public static LoginView view;

	public LoginController() {
		view = new LoginView();
		view.getLoginBtn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == view.getLoginBtn()) {
			Auth auth = new Auth(view.getUsernameTf().getText().toString(),
					new String(view.getPasswordTf().getPassword()));
			
			if(AuthHandler.login(auth)) {
//				JOptionPane.showMessageDialog(view, "Đăng nhập thành công!");
				view.dispose();
				new HomeController();
			}
			else {
				JOptionPane.showMessageDialog(view, "Sai tên đăng nhập hoặc mật khẩu!");
			}
		}
	}
	
}

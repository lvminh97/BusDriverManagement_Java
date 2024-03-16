package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
			if(view.getUsernameTf().getText().toString().equals("admin")
					&& view.getPasswordTf().getText().toString().equals("admin")
			) 
			{
				JOptionPane.showMessageDialog(view, "Đăng nhập thành công!");
			}
			else {
				JOptionPane.showMessageDialog(view, "Sai tên đăng nhập hoặc mật khẩu!");
			}
		}
	}
	
}

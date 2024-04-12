package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import view.LoginView;

public class LoginController implements ActionListener{
	private LoginView loginView;
	
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginView.jbuttonLogin) {
            loginView.dangNhap();
        } else if (e.getSource() == loginView.tglbtnNewToggleButton) {
            loginView.hienThiMatKhau(); // Gọi phương thức hiển thị mật khẩu khi nhấn nút "Show"
        } else if (e.getSource() == loginView.jbtForgetPass) {
        	loginView.quenMatKhau();
        }
    }
}

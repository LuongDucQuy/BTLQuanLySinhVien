package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.LoginView;
import view.MenuView;

public class MenuController implements Action{
	private MenuView menuView;
	
	public MenuController(MenuView menuView) {
		this.menuView = menuView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, "Bạn vừa nhấn vào: "+cm);
		if(cm.equals("Quản lý thông tin sinh viên")) {
//			this.menuView.quanLySinhVien();
		}else if(cm.equals("Quản lý điểm sinh viên")) {
//			this.menuView.quanLyDiem();
		}else if(cm.equals("Quản lý thư viện")) {
			this.menuView.quanLyThuVien();
		}else if(cm.equals("Exit")) {
			this.menuView.thoatKhoiChuongTrinh();
		}else if(cm.equals("Log out")) {
			this.menuView.dangXuat();
		}
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

}

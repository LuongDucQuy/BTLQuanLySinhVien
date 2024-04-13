package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;

import view.QuanLyThuVienView;

public class QuanLyMuonTraController implements Action{
	QuanLyThuVienView quanLyThuVienView;
	
	public QuanLyMuonTraController(QuanLyThuVienView quanLyThuVienView) {
		this.quanLyThuVienView = quanLyThuVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Mượn Sách")) {
			try {
				this.quanLyThuVienView.thucHienMuonSach();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(cm.equals("Cập Nhật")) {
			this.quanLyThuVienView.capNhatThongTinMuonTra();
		}
		else if(cm.equals("Sửa Thông Tin")) {
			this.quanLyThuVienView.thucHienSuaThongTinMuonTra();
		}
		else if(cm.equals("Trả Sách")) {
			
		}
		else if(cm.equals("Xóa")) {
			
		}
		else if(cm.equals("Làm Mới")) {
			this.quanLyThuVienView.xoaForm1();
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

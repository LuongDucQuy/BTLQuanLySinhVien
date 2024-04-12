package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JOptionPane;

import view.QuanLyThuVienView;

public class QuanLySachController implements Action{
	
	private QuanLyThuVienView quanLyThuVienView;
	
	
	public QuanLySachController(QuanLyThuVienView quanLyThuVienView) {
		this.quanLyThuVienView = quanLyThuVienView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cm = e.getActionCommand();
		if(cm.equals("Thêm")) {
			this.quanLyThuVienView.xoaForm();
			this.quanLyThuVienView.QLSachModel.setLuaChon("Thêm");
		}
		else if(cm.equals("Lưu")) {
			try {
				this.quanLyThuVienView.thucHienThemSach();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}
		else if(cm.equals("Cập Nhật")) {
			try {
				this.quanLyThuVienView.hienThiSachDaChon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(cm.equals("Xóa")) {
			this.quanLyThuVienView.thucHienXoa();
		}
		else if(cm.equals("Làm Mới")) {
			this.quanLyThuVienView.xoaForm();
		}
		else if(cm.equals("Tìm Kiếm")) {
			this.quanLyThuVienView.thucHienTim();
		}
		else if(cm.equals("Hủy Tìm")) {
			this.quanLyThuVienView.thucHienHuyTim();
		}
		else if(cm.equals("Đóng")) {
			this.quanLyThuVienView.thucHienDong();
		}
		else if(cm.equals("Thoát")) {
			this.quanLyThuVienView.thucHienThoat();
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

package model;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.swing.JOptionPane;

public class SachModel {
	private String maSach;
	private String tenSach;
	private String theLoai;
	private String nhaXB;
	private LocalDate ngayXB;
	private String maTacGia;
	private int soLuong;
	private double giaTien;
	private QuanLySachModel quanLySachModel;
	
	public SachModel() {
		quanLySachModel = new QuanLySachModel();
	}

	public SachModel(String maSach, String tenSach, String theLoai, String nhaXB, LocalDate namXB, String maTacGia, int soLuong, double giaTien) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.theLoai = theLoai;
		this.nhaXB = nhaXB;
		this.ngayXB = namXB;
		this.maTacGia = maTacGia;
		this.soLuong = soLuong;
		this.giaTien = giaTien;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTheLoai() {
		return theLoai;
	}

	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}

	public String getNhaXB() {
		return nhaXB;
	}

	public void setNhaXB(String nhaXB) {
		this.nhaXB = nhaXB;
	}

	public LocalDate getNamXB() {
		return ngayXB;
	}

	public void setNamXB(LocalDate namXB) {
		this.ngayXB = namXB;
	}

	public String getMaTacGia() {
		return maTacGia;
	}

	public void setMaTacGia(String maTacGia) {
		this.maTacGia = maTacGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(double giaTien) {
		this.giaTien = giaTien;
	}

	@Override
	public String toString() {
		return "QuanLySachModel [maSach=" + maSach + ", tenSach=" + tenSach + ", theLoai=" + theLoai + ", nhaXB="
				+ nhaXB + ", namXB=" + ngayXB + ", maTacGia=" + maTacGia + ", soLuong=" + soLuong + ", giaTien="
				+ giaTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(giaTien, maSach, maTacGia, ngayXB, nhaXB, soLuong, tenSach, theLoai);
	}

	@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        SachModel sach = (SachModel) obj;
        return Objects.equals(maSach, sach.maSach);
    }
	
	public SachModel timSachTheoMa(String maSach) {
	    if (this.quanLySachModel == null) {
	        JOptionPane.showMessageDialog(null, "quanLySachModel chưa được khởi tạo.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	    for (SachModel sach : quanLySachModel.getDsSach()) {
	        if (sach.getMaSach().equals(maSach)) {
	            return sach;
	        }
	    }
	    return null;
	}
	
	public void capNhatSach(SachModel sachCapNhat) {
	    for (int i = 0; i < quanLySachModel.getDsSach().size(); i++) {
	        if (quanLySachModel.getDsSach().get(i).getMaSach().equals(sachCapNhat.getMaSach())) {
	            quanLySachModel.getDsSach().set(i, sachCapNhat);
	            break;
	        }
	    }
	}
	
}

package model;

import java.util.Date;

public class SinhVien {
	private String maSV;
	private String tenSV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String diaChi;

	public SinhVien(String maSV, String tenSV) {
		this.maSV=maSV;
		this.tenSV=tenSV;
	}
	
	public SinhVien(String maSV, String tenSV, Date ngaySinh, boolean gioiTinh, String diaChi) {
		this.maSV = maSV;
		this.tenSV = tenSV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
	}
	public SinhVien() {
	}

	public String getMaSV() {
		return maSV;
	}
	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
}

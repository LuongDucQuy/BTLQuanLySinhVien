package model;

import java.time.LocalDate;
import java.util.Objects;

public class MuonTraModel {
	private String maSinhVien;
	private String maSach;
	private int soLuong;
	private LocalDate ngayHenTra;
	private String trangThai;
	
	public MuonTraModel() {}

	public MuonTraModel(String maSinhVien, String maSach, int soLuong, LocalDate ngayHenTra) {
		this.maSinhVien = maSinhVien;
		this.maSach = maSach;
		this.soLuong = soLuong;
		this.ngayHenTra = ngayHenTra;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public LocalDate getNgayHenTra() {
		return ngayHenTra;
	}

	public void setNgayHenTra(LocalDate ngayHenTra) {
		this.ngayHenTra = ngayHenTra;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "QuanLyMuonTraController [maSinhVien=" + maSinhVien + ", maSach=" + maSach + ", soLuong=" + soLuong
				+ ", ngayHenTra=" + ngayHenTra + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maSach, maSinhVien, ngayHenTra, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MuonTraModel other = (MuonTraModel) obj;
		return Objects.equals(maSach, other.maSach) && Objects.equals(maSinhVien, other.maSinhVien)
				&& Objects.equals(ngayHenTra, other.ngayHenTra) && soLuong == other.soLuong;
	}
	
	
}

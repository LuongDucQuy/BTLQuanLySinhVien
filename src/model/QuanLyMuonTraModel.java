package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLyMuonTraModel {
	private ArrayList<MuonTraModel> dsMuonTra;
	private QuanLySachModel QLSachModel;
	private SachModel sachModel;
	
	public QuanLyMuonTraModel() {
		this.dsMuonTra = new ArrayList<MuonTraModel>();
//        this.QLSachModel = new QuanLySachModel();
        sachModel = new SachModel();
	}
	
	public QuanLyMuonTraModel(ArrayList<MuonTraModel> dsMuonTra, SachModel sachModel) {
        this.dsMuonTra = dsMuonTra;
        this.sachModel = sachModel;
    }

	public QuanLyMuonTraModel(ArrayList<MuonTraModel> dsMuonTra) {
		this.dsMuonTra = dsMuonTra;
	}
	
	public void setSachModel(SachModel sachModel) {
        this.sachModel = sachModel;
    }

	public ArrayList<MuonTraModel> getDsMuonTra() {
		return dsMuonTra;
	}

	public void setDsMuonTra(ArrayList<MuonTraModel> dsMuonTra) {
		this.dsMuonTra = dsMuonTra;
	}
	
	public void insert(MuonTraModel muonTraModel) {
		this.dsMuonTra.add(muonTraModel);
	}
	
	public void delete(MuonTraModel muonTraModel) {
		this.dsMuonTra.remove(muonTraModel);
	}
	
	public void update(MuonTraModel muonTraModel) {
		this.dsMuonTra.remove(muonTraModel);
		this.dsMuonTra.add(muonTraModel);
	}
	
	public void themMuonTra(MuonTraModel muonTra) {
        dsMuonTra.add(muonTra);
    }
	
	public boolean kiemTraTonTai(MuonTraModel muonTraModel) {
        for(MuonTraModel sachTrongDS : dsMuonTra) {
            if(sachTrongDS.getMaSinhVien().equals(muonTraModel.getMaSinhVien())) {
                return true;
            }
        }
        return false;
    }
	public void capNhatSoLuongSach(String maSach, int soLuongMuon) {
		if (this.sachModel == null) {
	        JOptionPane.showMessageDialog(null, "sachModel chưa được khởi tạo.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    SachModel sach = this.sachModel.timSachTheoMa(maSach);
	    if (sach != null) {
	        int soLuongHienTai = sach.getSoLuong();
	        if (soLuongHienTai >= soLuongMuon) {
	            sach.setSoLuong(soLuongHienTai - soLuongMuon);
	            this.sachModel.capNhatSach(sach);
	        } else {
	            JOptionPane.showMessageDialog(null, "Không đủ sách để mượn.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	    } else {
	        JOptionPane.showMessageDialog(null, "Không tìm thấy sách.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	    }
	}
}

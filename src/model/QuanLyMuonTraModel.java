package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import view.QuanLyThuVienView;

public class QuanLyMuonTraModel {
	private ArrayList<MuonTraModel> dsMuonTra;
	private QuanLySachModel QLSachModel;
	private SachModel sachModel;
	private QuanLyThuVienView quanLyThuVienView;
	
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
	    if (this.QLSachModel == null) {
	        this.QLSachModel = new QuanLySachModel(); // Khởi tạo QLSachModel nếu chưa được khởi tạo
	        // Bạn cũng có thể xử lý việc khởi tạo QLSachModel ở constructor của QuanLyMuonTraModel để tránh tình trạng này
	    }
	    SachModel sach = this.QLSachModel.timSachTheoMa(maSach);
	    if (sach != null) {
	        int soLuongHienTai = sach.getSoLuong();
	        if (soLuongHienTai >= soLuongMuon) {
	            sach.setSoLuong(soLuongHienTai - soLuongMuon);
	            this.QLSachModel.capNhatSach(sach);

	            // Cập nhật dữ liệu lên bảng hiển thị
	            DefaultTableModel modelTable = (DefaultTableModel) quanLyThuVienView.table.getModel();
	            for (int i = 0; i < modelTable.getRowCount(); i++) {
	                if (modelTable.getValueAt(i, 1).equals(maSach)) {
	                    modelTable.setValueAt(soLuongHienTai - soLuongMuon, i, 5);
	                    break;
	                }
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Không đủ sách để mượn.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}

}

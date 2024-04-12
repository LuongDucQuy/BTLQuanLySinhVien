package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QuanLySachModel {
	private ArrayList<SachModel> dsSach;
	private String luaChon;
	private SachModel sachModel;

	public QuanLySachModel() {
		this.dsSach = new ArrayList<SachModel>();
		this.luaChon = "";
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public QuanLySachModel(ArrayList<SachModel> dsSach) {
		this.dsSach = dsSach;
	}

	public ArrayList<SachModel> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<SachModel> dsSach) {
		this.dsSach = dsSach;
	}
	
	public void insert(SachModel sachModel) {
		this.dsSach.add(sachModel);
	}
	
	public void delete(SachModel sachModel) {
		this.dsSach.remove(sachModel);
	}
	
	public void update(SachModel sachModel) {
		this.dsSach.remove(sachModel);
		this.dsSach.add(sachModel);
	}
	
	

	public boolean kiemTraTonTai(SachModel sach) {
        for(SachModel sachTrongDS : dsSach) {
            if(sachTrongDS.getMaSach().equals(sach.getMaSach())) {
                return true;
            }
        }
        return false;
    }
	
	public SachModel timSachTheoMa(String maSach) {
	    if (this.getDsSach() == null) {
	        JOptionPane.showMessageDialog(null, "Danh sách sách chưa được khởi tạo.", "Thông báo", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	    for (SachModel sach : this.getDsSach()) {
	        if (sach.getMaSach().equals(maSach)) {
	            return sach;
	        }
	    }
	    return null;
	}
	
	public void capNhatSach(SachModel sachCapNhat) {
	    for (int i = 0; i < this.getDsSach().size(); i++) {
	        if (this.getDsSach().get(i).getMaSach().equals(sachCapNhat.getMaSach())) {
	            this.getDsSach().set(i, sachCapNhat);
	            break;
	        }
	    }
	}
}



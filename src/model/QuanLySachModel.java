package model;

import java.util.ArrayList;

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
	
}



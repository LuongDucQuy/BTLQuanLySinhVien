package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.protocol.Resultset;
import java.text.DateFormat;
import database.JDBCUtil;
public class SinhVienDAO {
	
	public static List<SinhVien> ls = new ArrayList<>();
	
//	public int add(SinhVien sv) {
//		ls.add(sv);
//		return 1;
//	}
	public int add(SinhVien sv) {
		DateFormat date_format=new SimpleDateFormat("yyyy/mm/dd");
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="INSERT INTO ontap.SinhVien (MaSV, TenSV, NgaySinh, GioiTinh, DiaChi) VALUES (?, ?, ?, ?, ?);";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,sv.getMaSV());
			sttm.setString(2,sv.getTenSV());
			sttm.setString(3,date_format.format(sv.getNgaySinh()));
			sttm.setBoolean(4,sv.isGioiTinh());
			sttm.setString(5,sv.getDiaChi());
			if(sttm.executeUpdate()>0) {
				System.out.println("add thành công");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				sttm.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return -1;
		
		
	}
	public SinhVienDAO() {
		ls= new ArrayList<SinhVien>();
	};
	
	public static List<SinhVien> addSinhVien(SinhVien sv){
		ls.add(sv);
		return ls;
	}
	
//	public List<SinhVien> getAllSinhVien(){
//		return ls;
//	}
	
	public List<SinhVien> getAllSinhVien(){
		List<SinhVien> ls=new ArrayList<>();
		Connection conn=null;
		Statement sttm=null;
		ResultSet rs=null;
		try {
			String sSQL="SELECT * FROM ontap.SinhVien";
			conn=JDBCUtil.getConnection();
			sttm=conn.createStatement();
			rs=sttm.executeQuery(sSQL);
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMaSV(rs.getString(1));
				sv.setTenSV(rs.getString(2));
				sv.setNgaySinh(rs.getDate(3));
				sv.setGioiTinh(rs.getBoolean(4));
				sv.setDiaChi(rs.getString(5));
				ls.add(sv);
			}
				
		} catch (Exception e) {
			System.out.println("Hiển thị không thành công");
		} finally {
			try {
				rs.close();
				conn.close();
				sttm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
				
			}
		}
		
		
		return ls;
	}
	
	public void delete(SinhVien sv) {
		ls.remove(sv);
	}
	public void insert(SinhVien sv) {
		ls.add(sv);
	}
	public void update(SinhVien sv) {
		ls.remove(sv);
		ls.add(sv);
	}
	
	
//	public int delSinhVienByID(String ma) {
//		for (SinhVien sv : ls) {
//			if(sv.getMaSV().equalsIgnoreCase(ma)) {
//				ls.remove(sv);
//				return 1;
//			}
//			
//		}
//		return -1;
//	}
	
	//Xóa sinh viên trong db
	public int delSinhVienByID(String MaSV) {
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="delete FROM ontap.SinhVien where MaSV=?";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1, MaSV);
			if(sttm.executeUpdate()>0) {
				System.out.println("Xóa Thành công");
				return 1;
			}	
		} catch (Exception e) {
			System.out.println("xóa không thành công");
			e.printStackTrace();
			return 0;
		} finally{
			try {
				conn.close();
				sttm.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		return -1;
	}	
	
	
//	public SinhVien getSinhVienByID(String id) {
//		for(SinhVien sv : getAllSinhVien()) {
//			if(sv.getMaSV().equalsIgnoreCase(id)) {
//				return sv;
//			}
//		}
//		return null;
//		
//	}
//	
	
	public SinhVien getSinhVienByID(String MaSV) {
		Connection conn=null;
		PreparedStatement sttm=null;
		ResultSet rs=null;
		SinhVien sv = new SinhVien();
		try {
			String sSQL="SELECT * FROM ontap.SinhVien Where MaSV=?;";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,MaSV);
			rs=sttm.executeQuery();
			while(rs.next()) {
				sv.setMaSV(rs.getString(1));
				sv.setTenSV(rs.getString(2));
				sv.setNgaySinh(rs.getDate(3));
				sv.setGioiTinh(rs.getBoolean(4));
				sv.setDiaChi(rs.getString(5));
				return sv;
				
			}
		} catch (Exception e) {
//			System.out.println("Không thành công");
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				sttm.close();
				try {
					if(rs!=null) {rs.close();}	
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return null;
		
	}
	
	
//	public int updateSinhVienByID(SinhVien svNew) {
//		for (SinhVien sv : ls) {
//			if(sv.getMaSV().equalsIgnoreCase(svNew.getMaSV())) {
//				sv.setTenSV(svNew.getTenSV());
//				sv.setNgaySinh(svNew.getNgaySinh());
//				sv.setGioiTinh(svNew.isGioiTinh());
//				sv.setDiaChi(svNew.getDiaChi());
//				return 1;
//				
//			}
//			
//		}
//		return -1;
//	}
	public int updateSinhVienByID(SinhVien sv) {
		DateFormat date_format=new SimpleDateFormat("yyyy/mm/dd");
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="UPDATE SinhVien SET TenSV=?,NgaySinh=?,GioiTinh=?,DiaChi=? WHERE MaSV=?;";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,sv.getTenSV());
			sttm.setString(2,date_format.format(sv.getNgaySinh()));
			sttm.setBoolean(3,sv.isGioiTinh());
			sttm.setString(4,sv.getDiaChi());
			sttm.setString(5,sv.getMaSV());
			if(sttm.executeUpdate()>0) {
				System.out.println("cập nhật thành công");
				return 1;
			}
		} catch (Exception e) {
			System.out.println("cập nhật không thành công");
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				sttm.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		return -1;
		
		
	}
	
	
	public static boolean kiemTraTonTai(SinhVien sv) {
		if(sv!=null) {
			for (SinhVien sinhvien : ls) {
			if(sinhvien.getMaSV().equals(sv.getMaSV())) {
				return true;
			}	
		} }else {
			System.out.println("Hãy kiểm tra xem sinh viên có tồn tại hay không");
		}
		return false;	
	}
//	
}

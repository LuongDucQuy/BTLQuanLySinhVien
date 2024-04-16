package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import database.JDBCUtil;

public class GradeDAO {
    private List<Grade> ls = new ArrayList<>();

//    public int add(Grade d) {
//        ls.add(d);
//        return 1;
//    }
    public int add(Grade g) {
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="INSERT INTO ontap.Diem (MaSV,Toan,Ly,Hoa) values (?,?,?,?);";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,g.getSv().getMaSV());
			sttm.setDouble(2,g.getToan());
			sttm.setDouble(3,g.getLy());
			sttm.setDouble(4,g.getHoa());
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

    
//    public List<Grade> getAllGrade() {
//        return ls;
//    }
    public List<Grade> getAllGrade(){
		List<Grade> ls=new ArrayList<>();
		Connection conn=null;
		Statement sttm=null;
		ResultSet rs=null;
		try {
			String sSQL="SELECT Diem.MaSV,SinhVien.TenSV ,Diem.Toan, Diem.Ly,Diem.Hoa FROM ontap.Diem INNER JOIN SinhVien ON Diem.MaSV=SinhVien.MaSV";
			conn=JDBCUtil.getConnection();
			sttm=conn.createStatement();
			rs=sttm.executeQuery(sSQL);
			while(rs.next()) {
				Grade g = new Grade();
				g.setSv(new SinhVien(rs.getString(1),rs.getString(2)));
				g.setToan(rs.getDouble(3));
				g.setLy(rs.getDouble(4));
				g.setHoa(rs.getDouble(5));
				ls.add(g);
			}
		} catch (Exception e) {
			System.out.println("Hiển thị không thành công");
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
		
		
		return ls;
	}
	

//    public Grade getOneGradeByMaSV(String masv) {
//        for (Grade d : ls) {
//            if (d.getSv().getMaSV().equalsIgnoreCase(masv)) {
//                return d;
//            }
//        }
//        return null;
//    }
    
    public Grade getOneGradeByMaSV(String masv) {
		Connection conn=null;
		PreparedStatement sttm=null;
		ResultSet rs=null;
		
		try {
			String sSQL = "SELECT  ontap.Diem.MaSV, ontap.SinhVien.TenSV, ontap.Diem.Toan, ontap.Diem.Ly, ontap.Diem.Hoa FROM ontap.Diem INNER JOIN SinhVien ON Diem.MaSV=SinhVien.MaSV WHERE ontap.Diem.MaSV=?;";

			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,masv);
			rs=sttm.executeQuery();
			while(rs.next()) {
				Grade g = new Grade();
				g.setSv(new SinhVien(rs.getString(1),rs.getString(2)));
				g.setToan(rs.getDouble(3));
				g.setToan(rs.getDouble(4));
				g.setToan(rs.getDouble(5));
				return g;
				
			}
		} catch (Exception e) {
			System.out.println("Không thành công");
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
	

//    public int updateGrade(Grade dNew) {
//        for (Grade d : ls) {
//            if (d.getSv().getMaSV().equalsIgnoreCase(dNew.getSv().getMaSV())) {
//                d.setToan(dNew.getToan());
//                d.setLy(dNew.getLy());
//                d.setHoa(dNew.getHoa());
//                return 1;
//            }
//        }
//        return -1;
//    }
    
    public int updateGrade(Grade g) {
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="UPDATE ontap.diem SET Toan=?, Ly=?, Hoa=? WHERE MaSV=?;";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(4,g.getSv().getMaSV());
			sttm.setDouble(1,g.getToan());
			sttm.setDouble(2,g.getLy());
			sttm.setDouble(3,g.getHoa());
			if(sttm.executeUpdate()>0) {
				System.out.println("update thành công");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				sttm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1;
		
		
	}

//    public int delGrade(String masv) {
//        Grade d = getOneGradeByMaSV(masv);
//        if (d != null) {
//            ls.remove(d);
//            return 1;
//        }
//        return -1;
//    }
    public int delGrade(String maSv) {
		Connection conn=null;
		PreparedStatement sttm=null;
		try {
			String sSQL="DELETE FROM ontap.diem WHERE MaSV=?;";
			conn=JDBCUtil.getConnection();
			sttm=conn.prepareStatement(sSQL);
			sttm.setString(1,maSv);
			if(sttm.executeUpdate()>0) {
				System.out.println("update thành công");
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				conn.close();
				sttm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return -1;
		
		
	}
}

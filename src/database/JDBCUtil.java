package database;

import java.sql.Connection;
import java.sql.DriverManager;

import com.mysql.cj.jdbc.DatabaseMetaData;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Đăng kí MySQL Driver với DriverManager 
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			//Các thông số
			String url = "jdbc:mySQL://localhost:3306/ontap";
			String userName = "root";
			String pass = "";
			
			//Tạo kết nối
			c = DriverManager.getConnection(url, userName, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if(c!=null) {
				DatabaseMetaData mtdt = (DatabaseMetaData) c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				System.out.println(mtdt.getDatabaseProductVersion());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//package sqlConnect;
//
//import java.sql.*;
//
//
//public class JBDCUtil {
//	public static void main(String[] args) {
//        try {
////            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/web_gtsp", "root", "");
//            Statement stmt = con.createStatement();
//            System.out.println("inserting");
//            
//            String sql = "SELECT * FROM products";
//            stmt.executeQuery(sql);
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
//           
//        } 
//	}
//}


package sqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class JBDCUtil {
	public static Connection getConnection() {
		Connection conn = null;
		
//		Register
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			String url = "jdbc:mysql://localhost:3307/web_gtsp";
			String user = "root";
			String password = "";
			
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeConnection(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void name() {
		
	}

}

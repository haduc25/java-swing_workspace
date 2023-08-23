//package main;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.Statement;
//import sqlConnect.JBDCUtil;
//
//public class runJBDCUtil {
//
//	public static void main(String[] args) {
//		try {
//			Connection conn = JBDCUtil.getConnection(); //file sqlConnect/JBDCUtil.java
//			System.out.println(conn);
//			
//			// Statement
//			Statement st = conn.createStatement();
//			String sqlInsert = "INSERT INTO products(id_sp, id_dm, ten_sp, sub_ten_sp, img_sp, sl_sp) VALUES (10, 2, 'san pham 3','meow meow','img/sp_siudep.jpg', 50)";
//			var rs = st.executeUpdate(sqlInsert);
//			
//			// Result
//			if(rs > 0) {
//				System.out.println("success " + rs);
//			}else {
//				System.out.println("false " + rs);
//			}
//			
//			// close connect
//			JBDCUtil.closeConnection(conn);
//			System.out.println(conn);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}		
//
//	}
//
//}



package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sqlConnect.JBDCUtil;

public class runJBDCUtil8===     {

	public static void main(String[] args) {
		try {
			Connection conn = JBDCUtil.getConnection(); //file sqlConnect/JBDCUtil.java
			System.out.println(conn);
			
			// Query
			String sqlQuery = "SELECT id_sp, ten_sp, sub_ten_sp, img_sp, sl_sp FROM products";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
			
			// Execute query
			ResultSet resultSet = preparedStatement.executeQuery();
			
			// Process results
			while (resultSet.next()) {
				int id = resultSet.getInt("id_sp");
				String tenSP = resultSet.getString("ten_sp");
				String subTenSP = resultSet.getString("sub_ten_sp");
				String imgSP = resultSet.getString("img_sp");
				int slSP = resultSet.getInt("sl_sp");
				
				System.out.println("ID: " + id);
				System.out.println("Tên sản phẩm: " + tenSP);
				System.out.println("Mô tả: " + subTenSP);
				System.out.println("Ảnh sản phẩm: " + imgSP);
				System.out.println("Số lượng: " + slSP);
				System.out.println("===================");
			}
			
			// Close resources
			resultSet.close();
			preparedStatement.close();
			JBDCUtil.closeConnection(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

}

package JDBC; //ConnectDemo.java

import java.sql.*;
import java.sql.Connection;

public class bai1_connect {
	Connection con;

	public bai1_connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_qlsv", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet getData() {
		ResultSet r = null;
		if (con != null) {
			try {
				Statement st = con.createStatement();
				r = st.executeQuery("select * from sinhvien");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" ok");
		return r;
	}

	public void insert(int _id, String _hoTen, String _diaChi, String _tenLop, int _namSinh) {
		String sql = "Insert into sinhvien (id,hoten,diachi,tenlop,namsinh) values (?,?,?,?,?)";
		if (con != null) {
			try {
				PreparedStatement pr = con.prepareStatement(sql);
				pr.setInt(1, _id);
				pr.setString(2, _hoTen);
				pr.setString(3, _diaChi);
				pr.setString(4, _tenLop);
				pr.setInt(5, _namSinh);
				System.out.println(pr.toString());
				pr.executeUpdate();
				pr.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	public void updateSinhVien(int _id, String _hoTen, String _diaChi, String _tenLop, int _namSinh) {
		String sql = "update sinhvien set hoTen=?,diaChi=?,tenLop=?,namSinh=? where id=?";
		try {
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, _hoTen);
			pr.setString(2, _diaChi);
			pr.setString(3, _tenLop);
			pr.setInt(4, _namSinh);
			pr.setInt(5, _id);
			pr.executeUpdate();
			pr.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void showData(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.printf("%-2s", rs.getInt(1));
				System.out.printf("%-20s", rs.getString(2));
				System.out.printf("%-15s", rs.getString(3));
				System.out.printf("%-15s", rs.getString(4));
				System.out.printf("%-15s", rs.getInt(5));
				System.out.println("\n\n==================");
			}

			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public static void main(String[] args) {
		bai1_connect demo = new bai1_connect();
		demo.showData(demo.getData());

//	    demo.insert(0,"Nguyen Van B","Thai Binh", "K18A", 1992);
//		demo.updateSinhVien(4, "Nguyen Van C", "Nam Dinh", "K18B", 2000);
//	        ResultSet r=demo.getData();
//	       if(r!=null){
//	             System.out.println("du lieu sau khi insert");
//	             demo.showData(r);
//	       }

		System.out.println("sau khi update");
		demo.showData(demo.getData());
	}

}

package JDBC;

import java.sql.*;
import java.sql.Connection;

public class bai2_CRUD {
	private final String className = "com.mysql.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost:3307/db_qlsv";
    private final String user = "root";
    private final String pass = "";
    private final String table = "sinhvien";
    private Connection connection;

    public void initConnection() {

        try {
            Class.forName(className);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/db_qlsv", user, pass);
//              DriverManager.getConnection(url, user, pass);
            System.out.println("Ket noi ok");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getAllData() {
        ResultSet rs = null;
        String sqlcomand = "select * from " + table;
        try {
            if (connection != null) {
                Statement st = connection.createStatement();
                rs = st.executeQuery(sqlcomand);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    private void showData(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.printf("%-2s", rs.getInt(1));
                System.out.printf("%-20s", rs.getString(2));
                System.out.printf("%-15s", rs.getString(3));
                System.out.printf("%-15s", rs.getString(4));
                System.out.printf("%-15s", rs.getString(5));
                System.out.printf("\n");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getADataID(String _id) {
        ResultSet rs = null;
        String sqlcomand = "select * from " + table + " where id=" + _id;
        PreparedStatement pst = null;
        
        try {
            pst = connection.prepareStatement(sqlcomand);
            rs = pst.executeQuery(sqlcomand);
//            rs.close();
        } catch (SQLException ex) {
            System.out.println(sqlcomand);
            ex.printStackTrace();
        }
        return rs;
    }

    public void closeConnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void insertRow(int _id, String _hoTen, String _diaChi, String _tenLop, String ns) {
        String insertQuery = "insert into sinhvien values ('"
                + _id + "','" + _hoTen + "','"
                + _diaChi + "','" + _tenLop + "','" + ns + "');";
        System.out.println(insertQuery);
        if (this.connection != null) {
            try {
                Statement st = connection.createStatement();
                int n = st.executeUpdate(insertQuery);
                System.out.println("insert ok" + n);
                st.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void insertRowPreparedStatement(int _id, String _hoTen, String _diaChi, String _tenLop, String _ns) { String insertQuery = "INSERT INTO SINHVIEN VALUES(?,?,?,?,?);";
        if (this.connection != null) {
            try {//connection.setAutoCommit(false);
                PreparedStatement pst = connection.prepareStatement(insertQuery);
                pst.setInt(1, _id);
                pst.setString(2, _hoTen);
                pst.setString(3, _diaChi);
                pst.setString(4, _tenLop);
                pst.setString(5, _ns);
                System.out.println(pst.toString());
                int n = pst.executeUpdate();
                System.out.println("insert ok");
                pst.close();
                // connection.commit();
                //connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean DeleteID(int _id) {
        String sql = "delete from SINHVIEN where ID=?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setInt(1, _id);
            System.out.println(pr.toString());
            return pr.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateSinhVienID(int _id, String _hoTen, String _diaChi,
            String _tenLop, String _ns) {
        int k=0;
        String sql = "update sinhvien set hoten=?,diachi=?,tenlop=?,namsinh=? "
                + "where id=?";
        try {
            PreparedStatement pr = connection.prepareStatement(sql);
            pr.setString(1, _hoTen);
            pr.setString(2, _diaChi);
            pr.setString(3, _tenLop);
            pr.setString(4, _ns);
            pr.setInt(5, _id);
            k=pr.executeUpdate();
           
            return k > 0;
        } catch (SQLException e) {
             System.out.println("gia tri"+k);
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkID(String _id, ResultSet _rs) {
        try {
            while (_rs.next()) {
                if (_rs.getInt(1) == Integer.valueOf(_id)) {
                    _rs.close();
                    return true;
                }
            }
            _rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    
	public static void main(String[] args) {
		bai2_CRUD crud = new bai2_CRUD();
		crud.initConnection();
		crud.showData(crud.getAllData());

		
		
		// crud.insertRow(0, "Nguyễn Phú Trọng", "Hà Nội", "K22", "2007");
        // crud.updateSinhVienID(3, "Nguyen Ai Quoc", "Thái Binh", "KTPM", "2002");
		// crud.DeleteID(4);
		// crud.insertRowPreparedStatement((int)0, "Nguyen Van Thong", "Nam Dinh", "K22A", "1997");
        System.out.println("sau khi update");
//        crud.showData(crud.getAllData());
     
        System.out.println("\n\n=== Lay theo ID ===\n"); 
        
        crud.showData(crud.getADataID("01"));
        
        String targetID = "01"; // Đổi thành ID bạn muốn kiểm tra
        ResultSet dataResultSet = crud.getAllData(); // Lấy ResultSet từ bảng sinhvien (hoặc từ một truy vấn khác)
        boolean idExists = crud.checkID(targetID, dataResultSet);
        
        if (idExists) {
            System.out.println("ID " + targetID + " tồn tại trong CSDL.");
        } else {
            System.out.println("ID " + targetID + " không tồn tại trong CSDL.");
        }

        crud.closeConnect();

	}

}

package sqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDemo {
    Connection con;

    public ConnectDemo() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/web_gtsp", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData() {
        ResultSet rs = null;
        String query = "SELECT * FROM `products`";

        if (con != null) {
            try {
                Statement st = con.createStatement(); // Sử dụng java.sql.Statement ở đây
                rs = st.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Lấy dữ liệu thành công");
        return rs;
    }
    
    public void showData(ResultSet rs) {
        try {
            while (rs.next()) {
                System.out.println("id: " + rs.getInt(1));
                System.out.println("ten sp: " + rs.getString(3));
                System.out.println("so luong sp: " + rs.getInt(6));
                System.out.println("\n\n==================");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertData(int _id, int _idDm, String _tenSp, String _subTenSp, String _imgSp, int _soLuongSP) {
    	String sql = "INSERT INTO `products`(`id_sp`, `id_dm`, `ten_sp`, `sub_ten_sp`, `img_sp`, `sl_sp`) VALUES (?,?,?,?,?,?)";
    
    	if(con!=null) {
    		try {
    			PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, _id);
				ps.setInt(2, _idDm);
				ps.setString(3, _tenSp);
				ps.setString(4, _subTenSp);
				ps.setString(5, _imgSp);
				ps.setInt(6, _soLuongSP);

				System.out.println("PreparedStatement: " + ps);
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    }

    public static void main(String[] args) {
        ConnectDemo demo = new ConnectDemo();
        ResultSet rs = demo.getData();
        if (rs != null) {
            demo.showData(rs);
            
            System.out.println("====== INSERT ======");
            demo.insertData(12, 2, "iPhone 11", "meow", "images/iphone11.png", 999);
            
            System.out.println("====== Dữ liệu sau khi INSERT ======");
            
            // Fetch the data again after the insert operation
            ResultSet updatedRs = demo.getData();
            if (updatedRs != null) {
                demo.showData(updatedRs);
            }
        }
    }
}

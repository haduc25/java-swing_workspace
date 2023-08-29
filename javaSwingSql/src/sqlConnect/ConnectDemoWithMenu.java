package sqlConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectDemoWithMenu {
    Connection con;

    public ConnectDemoWithMenu() {
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
                Statement st = con.createStatement();
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

        if (con != null) {
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
                e.printStackTrace();
            }

        }
    }

    public void updateData(int _id, int _idDm, String _tenSp, String _subTenSp, String _imgSp, int _soLuongSP) {
        String sql = "UPDATE `products` SET `id_dm`=?,`ten_sp`=?,`sub_ten_sp`=?,`img_sp`=?,`sl_sp`=? WHERE `id_sp`=?";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setInt(1, _idDm);
                ps.setString(2, _tenSp);
                ps.setString(3, _subTenSp);
                ps.setString(4, _imgSp);
                ps.setInt(5, _soLuongSP);
                ps.setInt(6, _id);

                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deleteData(int _id) {
        String sql = "DELETE FROM `products` WHERE `id_sp`=?";

        if (con != null) {
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, _id);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ConnectDemoWithMenu demo = new ConnectDemoWithMenu();
        ResultSet rs = demo.getData();
        if (rs != null) {
            demo.showData(rs);

            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n====== MENU ======");
                System.out.println("1. Lấy dữ liệu");
                System.out.println("2. Insert");
                System.out.println("3. Update");
                System.out.println("4. Xóa");
                System.out.println("0. Thoát");
                System.out.print("Nhập lựa chọn: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        ResultSet updatedRs = demo.getData();
                        if (updatedRs != null) {
                            demo.showData(updatedRs);
                        }
                        break;
                    case 2:
                        demo.insertData(13, 2, "New Product", "New Sub Product", "images/newproduct.png", 100);
                        System.out.println("Dữ liệu đã được thêm.");
                        break;
                    case 3:
                        demo.updateData(12, 2, "Updated Product", "Updated Sub Product", "images/updatedproduct.png", 500);
                        System.out.println("Dữ liệu đã được cập nhật.");
                        break;
                    case 4:
                        demo.deleteData(12);
                        System.out.println("Dữ liệu đã được xóa.");
                        break;
                    case 0:
                        System.out.println("Đã thoát.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                }
            } while (choice != 0);

            scanner.close();
        }
    }
}

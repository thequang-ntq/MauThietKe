package solid_01.dao.sinhvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Vector;

import solid_01.models.SinhVien;

public class DbSinhVienDAO implements ISinhVienDAO {
//	@Override
//	public List<SinhVien> docTuNguonDuLieu() {
//		/**
//		 * 1. Kết nối đến csdl
//		 * 2. Tạo stmt
//		 * 3. Thực thi stmt return về ResultSet
//		 * 4. Duyệt qua resultSet để render danh sách sinh viên
//		 */
//		
//		return null;
//	}

	@Override
	public List<SinhVien> docDanhSachSinhVien() {
		List<SinhVien> danhSachSinhVien = new ArrayList<>();

		String sql = "SELECT * FROM sinhvien;";
		Connection cn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Nạp driver thành công"); 
			
			//Ket noi CSDL
			String url = "jdbc:mysql://localhost:3306/quanlysv?useUSSL=false";
			String user = "root";
			String pass = "quang";
			
			cn = DriverManager.getConnection(url, user, pass);
			System.out.println("Kết nối CSDL thành công");
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				SinhVien s = new SinhVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4));
				danhSachSinhVien.add(s);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return danhSachSinhVien;
	}

}


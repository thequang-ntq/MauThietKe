package singletondemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import singletondemo.model.SinhVien;

public class RepoSinhVien {
//	// URL kết nối đến SQL Server
//	// private static final String URL =
//	// "jdbc:sqlserver://localhost:1433;databaseName=ViDuDB;integratedSecurity=true";
//	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ViDuDB;user=sa;password=123;trustServerCertificate=true";
//
//	private Connection taoKetNoi() {
//		Connection connection;
//		try {
//			connection = DriverManager.getConnection(URL);
//			return connection;
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	// Đọc danh sách sinh viên
	public List<SinhVien> getDanhSachSinhVien() throws SQLException {
//		Connection connection = taoKetNoi();
		Connection connection = KetNoiGetter.getInstance().getKetNoi();
		
		List<SinhVien> sinhVienList = new ArrayList<>();
		String query = "SELECT MaSinhVien, HoTen, GioiTinhNam, MaNganhDaoTao FROM vd_ses3_designpatterns.Student;";

		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				String maSinhVien = rs.getString("MaSinhVien");
				String hoTen = rs.getString("HoTen");
				boolean gioiTinhNam = rs.getBoolean("GioiTinhNam");
				String maNganhDaoTao = rs.getString("MaNganhDaoTao");

				SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, gioiTinhNam, maNganhDaoTao);
				sinhVienList.add(sinhVien);
			}
		}
		return sinhVienList;
	}

}

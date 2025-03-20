package solid_01.dao.sinhvien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;
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
	public List<SinhVien> docTuNguonDuLieu() {
		List<SinhVien> danhSachSinhVien = new ArrayList<>();

		// Cấu hình kết nối với cơ sở dữ liệu
		String url = "jdbc:sqlserver://localhost:1433;databaseName=ViDuDB;trustServerCertificate=true;encrypt=true"; // Thay đổi thông tin kết nối
		String username = "sa"; // Thay đổi với tên người dùng của bạn
		String password = "123"; // Thay đổi với mật khẩu của bạn

		// Kết nối đến cơ sở dữ liệu
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			String sql = "SELECT MaSinhVien, HoTen, GioiTinhNam, MaNganhDaoTao FROM Student";
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
				// Xử lý kết quả truy vấn
				while (rs.next()) {
					String maSinhVien = rs.getString("MaSinhVien");
					String hoTen = rs.getString("HoTen");
					boolean gioiTinhNam = rs.getBoolean("GioiTinhNam");
					int maNganhDaoTao = rs.getInt("MaNganhDaoTao");

					// Tạo đối tượng SinhVien và thêm vào danh sách
					SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, gioiTinhNam, maNganhDaoTao);
					danhSachSinhVien.add(sinhVien);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return danhSachSinhVien;
	}

	

}

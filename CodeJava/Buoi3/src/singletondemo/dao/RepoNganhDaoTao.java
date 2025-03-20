package singletondemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import singletondemo.model.NganhDaoTao;
import singletondemo.model.SinhVien;

public class RepoNganhDaoTao {
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

	// Đọc danh sách ngành đào tạo
	public List<NganhDaoTao> getDanhSachNganhDaoTao() throws SQLException {
//		Connection connection = taoKetNoi();
		Connection connection = KetNoiGetter.getInstance().getKetNoi();
		List<NganhDaoTao> nganhDaoTaoList = new ArrayList<>();
		String query = "SELECT MaNganhDaoTao, TenNganhDaoTao FROM vd_ses3_designpatterns.NganhDaoTao;";

		try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int maNganh = rs.getInt("MaNganhDaoTao");
				String tenNganh = rs.getString("TenNganhDaoTao");

				NganhDaoTao nganhDaoTao = new NganhDaoTao(maNganh, tenNganh);
				nganhDaoTaoList.add(nganhDaoTao);
			}
		}
		return nganhDaoTaoList;
	}

	// Insert ngành đào tạo mới
	public void insertNganhDaoTao(int maNganhDaoTao, String tenNganhDaoTao) throws SQLException {
//		Connection connection = taoKetNoi();
		Connection connection = KetNoiGetter.getInstance().getKetNoi();

		String insertQuery = "INSERT INTO vd_ses3_designpatterns.NganhDaoTao (MaNganhDaoTao, TenNganhDaoTao) VALUES (?, ?);";

		try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
			pstmt.setInt(1, maNganhDaoTao);
			pstmt.setString(2, tenNganhDaoTao);
			pstmt.executeUpdate();
		} 
	}

}

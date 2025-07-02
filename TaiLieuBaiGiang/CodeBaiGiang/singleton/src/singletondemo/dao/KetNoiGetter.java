package singletondemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiGetter {
	// 0. Khai báo các thuộc tính, hàm như bình thường
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=ViDuDB;user=sa;password=123;trustServerCertificate=true";
	private Connection ketNoi;

	public Connection getKetNoi() {
		return this.ketNoi;
	}

	// 1. Khai báo private constructor
	private KetNoiGetter() {
		try {
			ketNoi = DriverManager.getConnection(URL);
			// mất 10s!!!
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2. Khai báo INSTANCE
	private static KetNoiGetter instance = null;
	
	// 3. Khai báo getInstance
	public static KetNoiGetter getInstance() {
		if (instance == null) {
			instance = new KetNoiGetter();
		}
		
		return instance;
	}

}

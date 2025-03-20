package singletondemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoiGetter {
	// 0. Khai báo các thuộc tính, hàm như bình thường
	private static final String URL = "jdbc:mysql://localhost:3306/vd_ses3_designpatterns?useUSSL=false";
	private static final String user = "root";
	private static final String pass = "quang";
	private Connection ketNoi;

	public Connection getKetNoi() {
		return this.ketNoi;
	}

	// 1. Khai báo private constructor
	private KetNoiGetter() {
		try {
			ketNoi = DriverManager.getConnection(URL, user, pass);
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

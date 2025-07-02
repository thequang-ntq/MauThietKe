package strategy_bt.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConfig {
	// 0. Khai báo các thuộc tính, hàm như bình thường
	//Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:sqlserver://localhost:1433;databaseName=strategy_bt;trustServerCertificate=true;encrypt=true";
	String user = "sa";
	String pass = "sa";
	private Connection cn;

	public Connection getCn() {
		return this.cn;
	}

	// 1. Khai báo private constructor
	private SQLServerConfig() {
		try {
			cn = DriverManager.getConnection(url, user, pass);
			// mất 10s!!!
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2. Khai báo INSTANCE
	private static SQLServerConfig instance = null;
	
	// 3. Khai báo getInstance
	public static SQLServerConfig getInstance() {
		if (instance == null) {
			instance = new SQLServerConfig();
		}
		
		return instance;
	}

}

package strategy_bt.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfig {

	String url = "jdbc:mysql://localhost:3306/strategy_bt?useUSSL=false";
	String user = "root";
	String pass = "quang";
	private Connection cn;

	public Connection getCn() {
		return this.cn;
	}

	private MySQLConfig() {
		try {
			cn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static MySQLConfig instance = null;
	
	public static MySQLConfig getInstance() {
		if (instance == null) {
			instance = new MySQLConfig();
		}
		
		return instance;
	}
}

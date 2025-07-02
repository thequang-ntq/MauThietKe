package com.ntquang.dp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	// 0. Khai báo các thuộc tính, hàm như bình thường
	//Class.forName("com.mysql.cj.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/proxydb?useUSSL=false";
	String user = "root";
	String pass = "quang";
	private Connection cn;

	public Connection getCn() {
		return this.cn;
	}

	// 1. Khai báo private constructor
	private DBConfig() {
		try {
			cn = DriverManager.getConnection(url, user, pass);
			// mất 10s!!!
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2. Khai báo INSTANCE
	private static DBConfig instance = null;
	
	// 3. Khai báo getInstance
	public static DBConfig getInstance() {
		if (instance == null) {
			instance = new DBConfig();
		}
		
		return instance;
	}

}

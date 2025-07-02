package com.ntquang.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConfig {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=22T1020362DB;trustServerCertificate=true;encrypt=true";
	String user = "sa";
	String pass = "sa";
	private Connection cn;

	public Connection getCn() {
		return this.cn;
	}

	private SQLConfig() {
		try {
			cn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static SQLConfig instance = null;
	
	public static SQLConfig getInstance() {
		if (instance == null) {
			instance = new SQLConfig();
		}
		
		return instance;
	}
}

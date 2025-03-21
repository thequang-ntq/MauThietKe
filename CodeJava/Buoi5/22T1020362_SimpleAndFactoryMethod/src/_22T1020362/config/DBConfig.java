package _22T1020362.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DBConfig {
	// 0. Khai báo các thuộc tính, hàm như bình thường
	//Ket noi CSDL
	private Connection cn;

	public Connection getCn() {
		return this.cn;
	}

	// 1. Khai báo private constructor
	private DBConfig() {
		try {
			FileInputStream fis = new FileInputStream("config.txt");
		    Scanner sc = new Scanner(fis);
		    String line = null;
		    while(sc.hasNextLine()) {
		    	line = sc.nextLine();
		    }
		    String [] lst = line.split("\\|");
			cn = DriverManager.getConnection(lst[0], lst[1], lst[2]);
			sc.close();
		} catch (Exception e) {
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

package _22T1020362.config;

import java.io.FileInputStream;
import java.util.Scanner;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConfig {
	private MongoDatabase db;

	public MongoDatabase getDB() {
		return this.db;
	}

	// 1. Khai báo private constructor
	private MongoDBConfig() {
		try {
			FileInputStream fis = new FileInputStream("config.txt");
		    Scanner sc = new Scanner(fis);
		    String line = null;
		    while(sc.hasNextLine()) {
		    	line = sc.nextLine();
		    }
		    String [] lst = line.split("\\|");
		    MongoClient mongoClient = MongoClients.create(lst[0]);
		    db = mongoClient.getDatabase(lst[1]);
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 2. Khai báo INSTANCE
	private static MongoDBConfig instance = null;
	
	// 3. Khai báo getInstance
	public static MongoDBConfig getInstance() {
		if (instance == null) {
			instance = new MongoDBConfig();
		}
		
		return instance;
	}
}

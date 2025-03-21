package _22T1020362.config;

import java.io.FileInputStream;
import java.util.Scanner;

public class TextFileConfig {
	private String txtfileUrl;
	public String getTextFileUrl() {
		return this.txtfileUrl;
	}
	
	private TextFileConfig() {
		try {
			FileInputStream fis = new FileInputStream("config.txt");
		    Scanner sc = new Scanner(fis);
		    String line = null;
		    while(sc.hasNextLine()) {
		    	line = sc.nextLine();
		    }
		    txtfileUrl = line;
			sc.close();
			// mất 10s!!!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static TextFileConfig instance = null;
	public static TextFileConfig getInstance() {
		if (instance == null) {
			instance = new TextFileConfig();
		}
		
		return instance;
	}
	
}

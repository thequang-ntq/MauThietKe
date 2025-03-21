package _22T1020362.config;

import java.io.FileInputStream;
import java.util.Scanner;

public class TextConfig {
	private String txtfileUrl;
	public String getTextFileUrl() {
		return this.txtfileUrl;
	}
	
	private TextConfig() {
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
	
	private static TextConfig instance = null;
	public static TextConfig getInstance() {
		if (instance == null) {
			instance = new TextConfig();
		}
		
		return instance;
	}
	
}

package _22T1020362.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


public class Config {
	public String getConfigType() throws IOException{
		FileInputStream fis = new FileInputStream("config.txt");
	    Scanner sc = new Scanner(fis);
	    String line = sc.nextLine();
	    sc.close();
	    return line;
	}
	
}

package congnhanlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CongNhanReader {
	public static List<CongNhan> loadFromFile(String filename){
		List<CongNhan> list = new ArrayList<>();
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scanner sc = new Scanner(fis);
        String line;
        while(sc.hasNextLine()) {
        	line = sc.nextLine();
        	if(line.isEmpty()) break;
        	String [] lst = line.split(",");
        	CongNhan cn = new CongNhan(lst[0], LocalDate.parse(lst[1]));
        	list.add(cn);
        }
        sc.close();
        return list;
	}		
}

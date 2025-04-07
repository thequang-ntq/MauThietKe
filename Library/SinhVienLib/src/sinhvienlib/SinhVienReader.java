package sinhvienlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SinhVienReader {
	public static List<SinhVien> loadFromFile(String filename){
		List<SinhVien> list = new ArrayList<>();
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
        	SinhVien sv = new SinhVien(lst[0], lst[1] , Double.valueOf(lst[2]));
        	list.add(sv);
        }
        sc.close();
        return list;
	}		
}

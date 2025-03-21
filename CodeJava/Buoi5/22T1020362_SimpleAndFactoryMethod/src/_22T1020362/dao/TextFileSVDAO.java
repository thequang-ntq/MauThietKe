package _22T1020362.dao;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
public class TextFileSVDAO implements ISVDAO{
	
	private String fileUrl;
	
	@Override
    public List<SinhVien> readSV() {
        List<SinhVien> list = new ArrayList<>();
        FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileUrl);
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
        	SinhVien sv = new SinhVien(lst[0], lst[1] , Boolean.parseBoolean(lst[2]) , Date.valueOf(lst[3]));
        	list.add(sv);
        }
        sc.close();
        return list;
    }
	
	@Override
    public void insertSV(SinhVien sv) {
		List<SinhVien> lst = readSV();
		boolean check = false;
		for(SinhVien s: lst) {
			if(s.getMaSinhVien().equals(sv.getMaSinhVien())) {
				System.out.println("Mã sinh viên đã tồn tại trong hệ thống, quý khách xin vui lòng kiểm tra lại.");
				check = true;
			}
		}
		if(!check) {
			try {
				FileWriter fw;
				fw = new FileWriter(fileUrl, true);
				BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(sv.toString());
		        bw.newLine();
		        bw.close();
		        System.out.println("Thêm mới sinh viên có mã: " + sv.getMaSinhVien() + " thành công");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
     
    }
	
	@Override
    public void deleteSV(String msv) {
		List<SinhVien> lst = readSV();
		boolean removed = lst.removeIf(sv -> sv.getMaSinhVien().equals(msv));
		if(removed) {
			FileWriter fw;
			try {
				fw = new FileWriter(fileUrl, false);
				BufferedWriter bw = new BufferedWriter(fw);
				for(SinhVien sv: lst) {
					bw.write(sv.toString());
					bw.newLine();
				}
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
			System.out.println("Hệ thống đã xóa sinh viên có mã: " + msv);
		}
		else {
			System.out.println("Hệ thống không tìm thấy sinh viên có mã: " + msv);
		}
    }
}

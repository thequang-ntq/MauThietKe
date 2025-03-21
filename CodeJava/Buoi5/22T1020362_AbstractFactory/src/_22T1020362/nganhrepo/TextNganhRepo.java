package _22T1020362.nganhrepo;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
public class TextNganhRepo implements INganhRepo{
	
	private String fileUrl;
	
	@Override
    public List<Nganh> readNDT() {
        List<Nganh> list = new ArrayList<>();
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
        	Nganh ndt = new Nganh(Integer.valueOf(lst[0]), lst[1]);
        	list.add(ndt);
        }
        sc.close();
        return list;
    }
	
	@Override
    public void insertNDT(Nganh ndt) {
		List<Nganh> lst = readNDT();
		boolean check = false;
		for(Nganh n: lst) {
			if(n.getMaNganh() == ndt.getMaNganh()) {
				System.out.println("Mã ngành đã tồn tại trong hệ thống, quý khách xin vui lòng kiểm tra lại.");
				check = true;
			}
		}
		if(!check) {
			try {
				FileWriter fw;
				fw = new FileWriter(fileUrl, true);
				BufferedWriter bw = new BufferedWriter(fw);
		        bw.write(ndt.toString());
		        bw.newLine();
		        bw.close();
		        System.out.println("Thêm mới ngành đào tạo có mã: " + ndt.getMaNganh() + " thành công");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
}

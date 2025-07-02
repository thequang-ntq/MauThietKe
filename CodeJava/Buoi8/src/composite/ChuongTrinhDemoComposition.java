package composite;

//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.List;

import composite.structure.File;
import composite.structure.Folder;
import composite.repo.FakeRepo;
import composite.repo.MySQLRepo;
//import composite.structure.Component;

public class ChuongTrinhDemoComposition {
	//BFS khởi tạo cây đối tượng theo kiểu dần dần
	public static void main(String[] args) {
		//đọc từ trong java
		System.out.println("---Fake----");
		FakeRepo fk = new FakeRepo();
		List<File> f = fk.docFile();
	 	List<Folder> fd = fk.docFolder();
//		fk.in(fd, 0);
		
//		System.out.println("Kich thuoc cua CSHARP la: " + CSHARP.getDungLuong());
//		System.out.println("Kich thuoc cua LAPTRINH la: " + LAPTRINH.getDungLuong());
//		System.out.println("Kich thuoc cua abc la: " + abc.getDungLuong());
		
		//đọc từ mysql db
		System.out.println("---DB---");
		MySQLRepo m = new MySQLRepo();
		List<File> f2 = m.docFile();
		List<Folder> fd2 = m.docFolder();
		for(Folder x: fd2) {
			
			System.out.println(x.getTenThuMuc());
		    m.in(x.getLstThanhPhan(), 1);
		}
	}
}

package _22T1020362;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import _22T1020362.config.Config;
import _22T1020362.dao.ISVDAO;
import _22T1020362.factorymethod.*;
import _22T1020362.models.SinhVien;
import _22T1020362.simplefactory.SVDAOFactory;

public class Program {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		//Simple Factory
		Config cg = new Config();
		String type = cg.getConfigType();
		SVDAOFactory simpleDAO = new SVDAOFactory();
		ISVDAO dao = simpleDAO.getDAO(type);
		
		//Hoặc sử dụng Factory Method
		ISVDAO dao2;
		if(type.equals("MS_SQLSERVER")) {
			DBSVDAOFactory db = new DBSVDAOFactory();
			dao2 = db.getDAO();
		}
		else if(type.equals("TEXT_FILE")) {
			TextFileSVDAOFactory txt = new TextFileSVDAOFactory();
			dao2 = txt.getDAO();
		}
		else {
			dao2 = null;
		}
		
		
		//Dùng simple factory
		System.out.println("-----------------------------Đọc-----------------------------");
		
		//read
		System.out.println("Danh sách SV:");
		System.out.println("[Mã sinh viên" + " - " + "Họ tên" + " - " + "Giới tính nam" + " - " + "Ngày sinh]");
		for(SinhVien sv: dao.readSV()) {
			System.out.println(sv.getMaSinhVien() + " - " + sv.getHoTen() + " - " + (sv.isGioiTinhNam() ? "True" : "False") + " - " + sv.getNgaySinh());
		}
		
		System.out.println("-----------------------------Thêm-----------------------------");
		
		//insert
		SinhVien sv = new SinhVien("22T1020485", "Lê Văn Hoàng", true, Date.valueOf(LocalDate.now()));
		dao.insertSV(sv);
		
		System.out.println("-----------------------------Xóa-----------------------------");
		
		//delete
		String msv = "22T1020485";
		dao.deleteSV(msv);
		sc.close();
		
		//Dùng Factory Method
		if(dao2 != null) {
			System.out.println("-----------------------------Đọc Text File-----------------------------");
			
			//read
			System.out.println("Danh sách SV:");
			System.out.println("[Mã sinh viên" + " - " + "Họ tên" + " - " + "Giới tính nam" + " - " + "Ngày sinh]");
			for(SinhVien sv1: dao2.readSV()) {
				System.out.println(sv1.getMaSinhVien() + " - " + sv1.getHoTen() + " - " + (sv1.isGioiTinhNam() ? "True" : "False") + " - " + sv1.getNgaySinh());
			}
			
			System.out.println("-----------------------------Thêm Text File-----------------------------");
			
			//insert
			SinhVien sv1 = new SinhVien("22T1020485", "Lê Văn Hoàng", true, Date.valueOf(LocalDate.now()));
			dao2.insertSV(sv1);
			
			System.out.println("-----------------------------Xóa Text File-----------------------------");
			
			//delete
			String msv1 = "22T1020485";
			dao2.deleteSV(msv1);
		}
	}


}
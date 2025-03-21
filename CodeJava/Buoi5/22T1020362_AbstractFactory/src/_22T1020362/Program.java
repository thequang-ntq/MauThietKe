package _22T1020362;

import java.io.IOException;

import _22T1020362.abstractfactory.MongoDBRepoFactory;
import _22T1020362.abstractfactory.MySQLRepoFactory;
import _22T1020362.abstractfactory.RepoFactory;
import _22T1020362.abstractfactory.TextRepoFactory;
import _22T1020362.config.Config;
import _22T1020362.models.Nganh;
import _22T1020362.models.SinhVien;
import _22T1020362.nganhrepo.INganhRepo;
import _22T1020362.sinhvienrepo.ISinhVienRepo;

public class Program {
	
	public static void main(String[] args) throws IOException {
		
		//Simple Factory
		Config cg = new Config();
		String type = cg.getConfigType(); //MySQL, MongoDB, Text
		String object = cg.getObjectType(); //Nganh, SinhVien
		
		RepoFactory f;
		if(type.equals("MySQL")) f = new MySQLRepoFactory();
		else if(type.equals("MongoDB")) f = new MongoDBRepoFactory();
		else if(type.equals("Text")) f = new TextRepoFactory();
		else f = null;
		
		
		if(f != null) {
			if(object.equals("Nganh")) {
				INganhRepo ndtRepo = f.getNganhRepo();
				
				System.out.println("-----------------------------Đọc ngành từ " + type + " -----------------------------");
				
				//read
				System.out.println("Danh sách SV:");
				System.out.println("[Mã ngành" + " - " + "Tên ngành]");
				for(Nganh ndt: ndtRepo.readNDT()) {
					System.out.println(ndt.getMaNganh() + " - " + ndt.getTenNganh());
				}
				
				System.out.println("-----------------------------Thêm ngành từ " + type + " -----------------------------");
				
				//insert
				Nganh n = new Nganh(102, "Công nghệ thông tin");
				ndtRepo.insertNDT(n);
				
			}
			else if(object.equals("SinhVien")) {
				ISinhVienRepo svRepo = f.getSinhVienRepo();
				
				System.out.println("-----------------------------Đọc sinh viên từ " + type + " -----------------------------");
				
				//read
				System.out.println("Danh sách SV:");
				System.out.println("[Mã sinh viên" + " - " + "Họ tên" + " - " + "Mã NĐT]");
				for(SinhVien sv: svRepo.readSV()) {
					System.out.println(sv.getMaSinhVien() + " - " + sv.getHoTen() + " - " + sv.getMaNganh());
				}
				
				System.out.println("-----------------------------Xóa sinh viên từ " + type + " -----------------------------");
				
				//delete
				String msv = "22T1020485";
				svRepo.deleteSV(msv);
				
			}
			else {
				System.out.println("Đối tượng không có trong cơ sở dữ liệu");
			}
		}
		else {
			System.out.println("Hệ thống không hỗ trợ nguồn dữ liệu này");
		}
	}
}
package solid_01;

//import java.io.IOException;
import java.util.List;

import solid_01.dao.nganhdaotao.DbNganhDaoTaoDAO;
//import solid_01.dao.nganhdaotao.FakeNganhDaoTaoDAO;
import solid_01.dao.nganhdaotao.INganhDaoTaoDAO;
import solid_01.dao.sinhvien.DbSinhVienDAO;
//import solid_01.dao.sinhvien.FakeSinhVienDAO;
import solid_01.dao.sinhvien.ISinhVienDAO;
//import solid_01.dao.sinhvien.TextSinhVienDAO;
import solid_01.models.NganhDaoTao;
import solid_01.models.SinhVien;

public class ChuongTrinh {
	
	static void inDanhSachNganh(List<NganhDaoTao> lst) {
		System.out.println("Danh sách các ngành đào tạo:");
		for (int i = 0; i < lst.size(); i++) {
			NganhDaoTao n = lst.get(i);
			System.out.printf("Mã ngành = %d - Tên ngành: %s\n", n.getMaNganhDaoTao(), n.getTenNganhDaoTao());
		}
	}	
	
	static void inDanhSachSinhVien(List<SinhVien> lstSinhVien, List<NganhDaoTao> lstNganh) {
		System.out.println("Danh sách sinh viên:");
		for (int i = 0; i < lstSinhVien.size(); i++) {
			SinhVien s = lstSinhVien.get(i);
			NganhDaoTao ndt = null;
			for (NganhDaoTao e : lstNganh)
				if (e.getMaNganhDaoTao() == s.getMaNganhDaoTao()) 
				{
					ndt = e;
					break;
				}
			String maNganhDaoTao = (ndt == null) ? 
			("không rõ ngành đào tạo") : ("ngành " + ndt.getTenNganhDaoTao());
			
			System.out.println("Mã SV = " + s.getMaSinhVien() + " - Tên SV = " + s.getHoTen() 
			+ " - Giới tính = " + (s.isGioiTinhNam()? "Nam":"Nữ") + " - Mã ngành đào tạo = " + maNganhDaoTao);
		}
	}	
	
	public static void main(String[] args) {
		ISinhVienDAO daoSinhVien;
		INganhDaoTaoDAO daoNganh;
		
		// Đọc dữ liệu từ file
//		dao = new TextSinhVienDAO();
//		dao.setDuongDan("sinhvien.txt");

//		dao = new TextSinhVienDAO("sinhvien.txt");
		daoSinhVien = new DbSinhVienDAO();
//		daoNganh = new TextNganhDaoTaoDAO("nganhdaotao.txt");
		daoNganh = new DbNganhDaoTaoDAO();
		
		
//		dao = new TextSinhVienDAO();
//		((TextSinhVienDAO)dao).setDuongDan("sinhvien.txt");
//		((TextSinhVienDAO)dao).setDuongDanNganhDaoTao("nganhdaotao.txt");

//		// Đọc từ nguồn csdl
//		dao = new DbSinhVienDAO();
		
//		dao = new TextSinhVienDAO("sinhvien.txt", "nganhdaotao.txt");
//		((TextSinhVienDAO)dao).setDuongDan("sinhvien.txt");
//		((TextSinhVienDAO)dao).setDuongDanNganhDaoTao("nganhdaotao.txt");
		
		//0. Doc tu nguon du lieu txt
//		SinhVienDAO dao = new SinhVienDAO();
//		dao.setLinkFile("sinhvien.txt");
		
		// 1. Đọc từ nguồn dữ liệu database
//		DbSinhVienDAO dao = new DbSinhVienDAO();
//		lst = dao.docTuNguonDuLieu();
		
		List<SinhVien> danhSachSinhVien = daoSinhVien.docDanhSachSinhVien();
		List<NganhDaoTao> danhSachNganh = daoNganh.docDanhSachNganh();
		
		// 2. Khai thác nguồn dữ liệu
//		for (int i = 0; i < lst.size(); i++) {
//			System.out.println(lst.get(i).getHoTen() + " - " + lst.get(i).getMaSinhVien() 
//			+ " - " + (lst.get(i).isGioiTinhNam()? "Nam" : "Nu") + " - " + lst.get(i).getMaNganhDaoTao());
//		}
		
		//In danh sách ngành
		inDanhSachNganh(danhSachNganh);
		
		//In danh sách sinh viên
		inDanhSachSinhVien(danhSachSinhVien, danhSachNganh);
	}

}

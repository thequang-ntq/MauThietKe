package solid_01;

import java.util.List;

import solid_01.dao.nganhdaotao.FakeNganhDaoTaoDAO;
import solid_01.dao.nganhdaotao.INganhDaoTaoDAO;
import solid_01.dao.nganhdaotao.TextNganhDaoTaoDAO;
import solid_01.dao.sinhvien.DbSinhVienDAO;
import solid_01.dao.sinhvien.ISinhVienDAO;
import solid_01.dao.sinhvien.TextSinhVienDAO;
import solid_01.models.NganhDaoTao;
import solid_01.models.SinhVien;

public class ChuongTrinh {

	static void inDanhSachNganh(List<NganhDaoTao> lst) {
		System.out.println("Danh sách các ngành đào tạo");
		for (int i = 0; i < lst.size(); i++) {
			NganhDaoTao x = lst.get(i);
			System.out.printf("Ma nganh = %d - Tên ngành: %s\n", x.getMaNganh(), x.getTenNganh());
		}
	}	
	
	public static void main(String[] args) {
		ISinhVienDAO dao;
		INganhDaoTaoDAO daoNganh;

		// Đọc dữ liệu từ file
//		dao = new TextSinhVienDAO();
//		dao.setDuongDan("sinhvien.txt");

//		dao = new TextSinhVienDAO("sinhvien.txt");
		dao = new DbSinhVienDAO();
//		daoNganh = new TextNganhDaoTaoDAO("nganhdaotao.txt");
		daoNganh = new FakeNganhDaoTaoDAO();
		
		
//		dao = new TextSinhVienDAO();
//		((TextSinhVienDAO)dao).setDuongDan("sinhvien.txt");
//		((TextSinhVienDAO)dao).setDuongDanNganhDaoTao("nganhdaotao.txt");

//		// Đọc từ nguồn csdl
//		dao = new DbSinhVienDAO();

		List<SinhVien> sinhVienList = dao.docTuNguonDuLieu();
		
		List<NganhDaoTao> lstNganh = daoNganh.docDanhSachNganh();
		inDanhSachNganh(lstNganh);

		// In ra danh sách sinh viên
		for (SinhVien sv : sinhVienList) {
			NganhDaoTao ndt = null;
			for (NganhDaoTao e : lstNganh)
				if (e.getMaNganh() == sv.getMaNganhDaoTao()) {
					ndt = e;
					break;
				}
			if (ndt == null)
				System.out.println(sv.getHoTen() + " khong ro nganh dao tao");
			else
				System.out.println(sv.getHoTen() + " nganh " + ndt.getTenNganh());
		}
	}

}

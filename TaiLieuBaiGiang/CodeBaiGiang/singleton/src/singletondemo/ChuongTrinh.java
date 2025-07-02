package singletondemo;

import java.sql.SQLException;
import java.util.List;

import singletondemo.dao.RepoNganhDaoTao;
import singletondemo.dao.RepoSinhVien;
import singletondemo.model.NganhDaoTao;
import singletondemo.model.SinhVien;

public class ChuongTrinh {

	public static void main(String[] args) {
		RepoNganhDaoTao daoNDT = new RepoNganhDaoTao();
		RepoSinhVien daoSV = new RepoSinhVien();

		// Đọc danh sách sinh viên
		List<SinhVien> lstSV;
		try {
			lstSV = daoSV.getDanhSachSinhVien();
			System.out.println("Danh sách sinh viên:");
			for (SinhVien sv : lstSV) {
				System.out.println(sv.getMaSinhVien() + " - " + sv.getHoTen());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Đọc danh sách ngành đào tạo trước khi thêm
		System.out.println("\nDanh sách ngành đào tạo trước khi bổ sung:");
		List<NganhDaoTao> lstNDT;
		try {
			lstNDT = daoNDT.getDanhSachNganhDaoTao();
			for (NganhDaoTao nganh : lstNDT) {
				System.out.println(nganh.getMaNganh() + " - " + nganh.getTenNganh());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Insert ngành đào tạo mới
		try {
			daoNDT.insertNganhDaoTao(999, "Xã hội học");
		} catch (Exception e) {
			System.out.println("Lỗi khi INSERT " + e.getMessage());
		}

		// Đọc lại danh sách ngành đào tạo sau khi thêm
		System.out.println("\nDanh sách ngành đào tạo sau khi bổ sung:");
		List<NganhDaoTao> lstNDT2;
		try {
			lstNDT2 = daoNDT.getDanhSachNganhDaoTao();
			for (NganhDaoTao nganh : lstNDT2) {
				System.out.println(nganh.getMaNganh() + " - " + nganh.getTenNganh());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

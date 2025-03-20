package buoi4;

import java.util.ArrayList;
import java.util.List;

import buoi4.models.SinhVien;
import buoi4.dao.readData.FakeSinhVienDAO;
import buoi4.dao.search.DBTimKiemSVDAO;
import buoi4.dao.search.FakeTimKiemSVDAO;

public class CTTimKiem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBTimKiemSVDAO dao = new DBTimKiemSVDAO();
		List<SinhVien> lst = new ArrayList<>();
		String keyword = "v";
		lst = dao.timKiemSV(keyword);
		System.out.println("Danh sách SV tìm được có chứa chữ " + keyword + ":");
		System.out.println("[Mã sinh viên" + " - " + "Họ tên" + " - " + "Mã NĐT" + " - " + "Ngày sinh]");
		for(SinhVien sv: lst) {
			System.out.println(sv.getMaSinhVien() + " - " + sv.getHoTen() + " - " + sv.getMaNganhDaoTao() + " - " + sv.getNgaySinh());
		}
	}

}

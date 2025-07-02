package proxy.proxy;

import java.util.ArrayList;
import java.util.List;

import proxy.model.NhanVien;

public class NhanVienServiceImpl implements NhanVienServiceInterface {

	@Override
	public List<NhanVien> getDanhSachNhanVien() {
		// Giả sử mất rất nhiều tài nguyên, thời gian
		List<NhanVien> empList = new ArrayList<>(5);
		empList.add(new NhanVien("Trần Nguyên Phong", 2565.55, "Dev"));
		empList.add(new NhanVien("Nguyễn Văn Trung", 22574, "Project Manager"));
		empList.add(new NhanVien("Nguyễn Thị Hồng", 3256.77, "SSE"));
		empList.add(new NhanVien("Phan Văn Nam", 4875.54, "SSE"));
		empList.add(new NhanVien("Trần Thị Hoa", 2847.01, "Tester"));
		return empList;
	}
}
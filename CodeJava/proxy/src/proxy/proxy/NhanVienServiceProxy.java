package proxy.proxy;

import java.util.List;

import proxy.model.NhanVien;

public class NhanVienServiceProxy implements NhanVienServiceInterface {

	private NhanVienServiceInterface svcNhanVien = null;

	@Override
	public List<NhanVien> getDanhSachNhanVien() {
			if (svcNhanVien == null) {
					System.out.println("Khởi tạo service THẬT SỰ...");
					svcNhanVien = new NhanVienServiceImpl();
			}
			return svcNhanVien.getDanhSachNhanVien();
	}
}
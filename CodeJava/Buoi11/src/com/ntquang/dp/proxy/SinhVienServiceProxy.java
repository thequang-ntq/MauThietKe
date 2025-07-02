package com.ntquang.dp.proxy;

import java.util.List;

import com.ntquang.dp.models.SinhVien;


public class SinhVienServiceProxy implements SinhVienServiceInterface {

	private SinhVienServiceInterface svcSinhVien = null;

	@Override
	public List<SinhVien> getDanhSachSinhVien() {
			if (svcSinhVien == null) {
					System.out.println("Khởi tạo service THẬT SỰ...");
					svcSinhVien = new SinhVienServiceImpl();
			}
			return svcSinhVien.getDanhSachSinhVien();
	}
}
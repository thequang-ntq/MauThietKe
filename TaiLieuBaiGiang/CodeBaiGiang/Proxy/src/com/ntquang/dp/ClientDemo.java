package com.ntquang.dp;

import java.util.List;

import com.ntquang.dp.models.SinhVien;
import com.ntquang.dp.proxy.SinhVienServiceInterface;
import com.ntquang.dp.proxy.SinhVienServiceProxy;

public class ClientDemo {
	public static void main(String[] args) {
			//Đọc danh sách sinh viên từ CSDL proxydb trong mysql, localhost3306, root, quang
			ContainerApp context = new ContainerApp("Trường Đại học Khoa học Huế", "77 Nguyễn Huệ, Thành phố Huế", "HUSC", new SinhVienServiceProxy());
			System.out.println("Tên trường: " + context.getTen());
			System.out.println("Địa chỉ: " + context.getDiaChi());
			System.out.println("Mã trường: " + context.getId());
	
			System.out.println("Sử dụng service...");
			SinhVienServiceInterface service = context.getSinhVienService();
			List<SinhVien> lst = service.getDanhSachSinhVien();
			System.out.println("Danh sách sinh viên:");
			System.out.println("Mã sinh viên, Họ tên, Giới tính, Ngày sinh (ngày/tháng/năm)");
			System.out.println("------------------------------------------");
			for (SinhVien x : lst) {
					System.out.println(x);
			}
	}
}

package proxy;

import java.util.List;

import proxy.model.NhanVien;
import proxy.proxy.NhanVienServiceInterface;
import proxy.proxy.NhanVienServiceProxy;

public class ClientDemo {
	public static void main(String[] args) {
		
			ContainerApp context = new ContainerApp("ABC", "Vietnam", "+0543826767", new NhanVienServiceProxy());
			System.out.println("Ten cong ty: " + context.getTen());
			System.out.println("Dia chi: " + context.getDiaChi());
			System.out.println("Id: " + context.getId());
	
			System.out.println("Sử dụng service...");
			NhanVienServiceInterface service = context.getNhanVienService();
			List<NhanVien> lst = service.getDanhSachNhanVien(); // Thuc su thuc hien loi goi ham truy xuat dich vu
			for (NhanVien x : lst) {
					System.out.println(x);
			}
	}
}
package buoi6.demo_prototype;

import java.util.ArrayList;
import java.util.List;

public class ChuongTrinh {
	public static void main(String[] args) {
		testSinhVienCopy();
	}
	
	private static void testSinhVienCopy() {
		DiaChi husc = new DiaChi("77", "Nguyen Hue St.");
		SinhVien nvtrung = new SinhVien("SV1", "Trung Nguyen", true, husc);
		
		//Cách 1 - Khởi tạo với các thuộc tính...
		SinhVien x = new SinhVien(
				nvtrung.getMaSinhVien(),
				nvtrung.getHoTen(),
				nvtrung.isGioiTinhNam(),
				husc
		);
		
		//Cách 2 - Set từng thuộc tính của đối tượng mới
		x = new SinhVien();
		x.setMaSinhVien(nvtrung.getMaSinhVien());
		x.setHoTen(nvtrung.getHoTen());
		x.setGioiTinhNam(nvtrung.isGioiTinhNam());
		x.setDiaChiThuongTru(husc);
		
		//x có phải là bản sao của nvtrung hay không? 
		//Bản sao: y hệt + độc lập
		//-> x chưa độc lập vì
		x.getDiaChiThuongTru().setTenDuong("Đống Đa");	
		//->nvtrung cũng bị đổi
		//Vấn đề: tạo bản sao sao cho độc lập về địa chỉ, để sau này có thêm nhiều class kế thừa thì vẫn clone được OK
		
		// Khởi tạo danh sách
		List<SinhVien> lst1 = new ArrayList<>();

		lst1.add(new SinhVien("sv1", "Nguyễn Văn Trung", true, new DiaChi("77", "Nguyen Hue St.")));
		lst1.add(new SinhVienNuocNgoai("sv2", "Trần Văn", true, new DiaChi("22", "Ba Trieu St."), "Brazil"));
		lst1.add(new SinhVienNuocNgoai("sv3", "Lê Thị Hoa", false, new DiaChi("30", "Le Loi St."), "New Zealand"));
		lst1.add(new SinhVien("sv4", "John Smith", true, new DiaChi("01", "City St.")));

		System.out.println("DANH SÁCH GỐC");
		for (int i = 0; i < lst1.size(); i++)
				System.out.println(lst1.get(i).toString());
		
		System.out.println("\nTẠO BẢN SAO KIỂU 2");
		
		// Tạo bản sao
		List<SinhVien> lst2 = new ArrayList<>();
		for (int i = 0; i < lst1.size(); i++) {
				SinhVien sv = lst1.get(i);
				lst2.add(sv.taoBanSao());
		}

		// In danh sách bản sao
		for (int i = 0; i < lst2.size(); i++)
			System.out.println(lst2.get(i).toString());
		
		//Kiểm tra
		System.out.println("Kiểm tra địa chỉ: ");
		System.out.println(lst1.get(0).hashCode());
		System.out.println(lst2.get(0).hashCode());
		
	}
}

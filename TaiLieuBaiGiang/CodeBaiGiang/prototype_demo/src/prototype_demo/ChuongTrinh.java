package prototype_demo;

import java.util.ArrayList;
import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ChuongTrinh {

	public static void main(String[] args) {
//		testDonHang();
		testCopyUsingGson();
	}

	private static void testCopyUsingGson() {
		// #region var lst = khởi tạo danh sách Dòng đơn hàng
		DongDonHang d1 = new DongDonHang("laptop HP", 1, 2000);
		DongDonHang d2 = new DongDonHang2("chuot may tinh", 1, 5, 0.3f);
		DongDonHang d3 = new DongDonHang("ban phim co", 1, 25);
		var lst = new ArrayList<DongDonHang>();
		lst.add(d1);
		lst.add(d2);
		lst.add(d3);
		// #endregion

		DonHang dh1 = new DonHang("DH1", new Date(2025 - 1900, 3, 25), lst);

		System.out.println("Thông tin đơn hàng 1");
		System.out.println(dh1.toString());

		// Sao chép dh1 bằng cách sử dụng GSon
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// #region 1. Chuyển object dh1 thành chuỗi JSON
		String stJSON = gson.toJson(dh1);
		System.out.println(stJSON);
		// #endregion
		
		// #region 1. Chuyển chuỗi JSON thành object dh2
		DonHang dh2 = gson.fromJson(stJSON, DonHang.class);
		dh2.setMaDonHang("111111");
		dh2.getLstDongDonHang().get(0).setDonGia(1000);
		System.out.println("Thông tin đơn hàng 2");
		System.out.println(dh2.toString());
		// #endregion
	}

	private static void testDonHang() {
		// #region var lst = khởi tạo danh sách Dòng đơn hàng
		DongDonHang d1 = new DongDonHang("laptop HP", 1, 2000);
		DongDonHang d2 = new DongDonHang2("chuot may tinh", 1, 5, 0.3f);
		DongDonHang d3 = new DongDonHang("ban phim co", 1, 25);
		var lst = new ArrayList<DongDonHang>();
		lst.add(d1);
		lst.add(d2);
		lst.add(d3);
		// #endregion

		DonHang dh1 = new DonHang("DH1", new Date(2025 - 1900, 3, 25), lst);

		System.out.println("Thông tin đơn hàng 1");
		System.out.println(dh1.toString());

		DonHang dh2 = dh1.taoBanSao();
		dh2.getLstDongDonHang().get(2).setSoLuong(3);
		System.out.println("Thông tin đơn hàng 2");
		System.out.println(dh2.toString());

	}

}

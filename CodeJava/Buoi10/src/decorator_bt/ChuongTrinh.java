package decorator_bt;

//import java.time.LocalDate;

import decorator_bt.component.ThueBao;
import decorator_bt.component.Tomato;
import decorator_bt.component.VIP;
//import decorator_bt.deco.KhuyenMai;
import decorator_bt.deco.KhuyenMaiABC;
import decorator_bt.deco.KhuyenMaiXYZ;

public class ChuongTrinh {
	
	private static void test() throws Exception {
		ThueBao x = new Tomato();                      // Gói cơ bản Tomato
        ThueBao x2 = new VIP();
        ThueBao x3, x4 = null;
        
        
        //Khuyến mãi ABC
        x3 = new KhuyenMaiABC(x);
        System.out.println("Khuyến mãi ABC của gói thuê bao Tomato:");
        System.out.println("Phí thuê bao: " + x3.getPhiThueBao());
        System.out.println("Phút gọi free: " + x3.getSoPhutGoiFree());
        System.out.println("Tin nhắn free: " + x3.getSoTinNhanFree());
        System.out.println("Giá gọi/phút: " + x3.getGiaGoi());
        System.out.println("Giá tin nhắn: " + x3.getGiaTinNhan());
        
        System.out.println("");
        //Khuyến mãi XYZ
        x4 = new KhuyenMaiXYZ(x2);                // Thêm khuyến mãi gọi nội mạng miễn phí
        System.out.println("Khuyến mãi XYZ của gói thuê bao VIP:");
        System.out.println("Phí thuê bao: " + x4.getPhiThueBao());
        System.out.println("Phút gọi free: " + x4.getSoPhutGoiFree());
        System.out.println("Tin nhắn free: " + x4.getSoTinNhanFree());
        System.out.println("Giá gọi/phút: " + x4.getGiaGoi());
        System.out.println("Giá tin nhắn: " + x4.getGiaTinNhan());
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

}

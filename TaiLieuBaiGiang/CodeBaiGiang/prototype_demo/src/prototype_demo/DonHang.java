package prototype_demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DonHang {
	private String maDonHang;
	private Date ngayLap;
	private List<DongDonHang> lstDongDonHang; // luu thong tin cac dong don hang
//	private double tongThanhTien;
	
	public DonHang(DonHang x) {
		this.maDonHang = x.maDonHang;
		
//		this.ngayLap = x.ngayLap;
		this.ngayLap = new Date(x.ngayLap.getTime());

		// tạo bản sao cho lstDongDonHang
//		var lst = new ArrayList<DongDonHang>();
//		for (DongDonHang ddh : x.getLstDongDonHang())
//			lst.add(ddh.taoBanSao());
//		this.lstDongDonHang = lst;
		
		var lst = new ArrayList<DongDonHang>();
		for (DongDonHang ddh : x.getLstDongDonHang())
			lst.add(new DongDonHang(ddh));
		this.lstDongDonHang = lst;		
		
//		this.tongThanhTien = x.tongThanhTien;
	}
	
	public DonHang taoBanSao() {
		return new DonHang(this);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Mã đơn hàng: " + this.getMaDonHang() + "\n");
		sb.append("Ngày lập: " + this.getNgayLap() + "\n");
		
		sb.append("Chi tiết:\n");
		for (DongDonHang ddh : this.getLstDongDonHang())			
			sb.append("\t" + ddh.toString() + "\n");
		
		return sb.toString();
	}
}

package prototype_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongDonHang {
	protected String tenSanPham;
	protected int soLuong;
	protected double donGia;
	
	@Override
	public String toString() {
		return String.format("%s %d x %f", tenSanPham, soLuong, donGia);
	}
	
	public DongDonHang(DongDonHang x) {
		this.tenSanPham = x.tenSanPham;
		this.soLuong = x.soLuong;
		this.donGia = x.donGia;
	}
	
	public DongDonHang taoBanSao() {
		return new DongDonHang(this);
	}
}

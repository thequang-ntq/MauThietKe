package prototype_demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongDonHang2 extends DongDonHang {
	private double chietKhau;

	@Override
	public String toString() {
		return String.format("%s %d x %f Chiết khấu %f", tenSanPham, soLuong, donGia, chietKhau);
	}

	public DongDonHang2(DongDonHang2 x) {
		super(x);
		this.chietKhau = x.chietKhau;
	}

	public DongDonHang2 taoBanSao() {
		return new DongDonHang2(this);
	}

	public DongDonHang2(String tenSanPham, int soLuong, double donGia, double chietKhau) {
		super(tenSanPham, soLuong, donGia);
		this.chietKhau = chietKhau;
	}
}

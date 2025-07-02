package buoi6.demo_prototype;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVienNuocNgoai extends SinhVien {
	private String quocGia;
	
	public SinhVienNuocNgoai(String a, String b, boolean c, DiaChi d, String e) {
		super(a,b,c, d);
		this.quocGia = e;
	}
	
	public SinhVienNuocNgoai(SinhVienNuocNgoai x) {
		super(x);
		this.quocGia = x.quocGia;
	}
	
	@Override
	public SinhVien taoBanSao() {
		return new SinhVienNuocNgoai(this);
	}
	
	@Override
	public String toString() {
		return "Sinh viên " + this.getHoTen() + " - " + (super.isGioiTinhNam()? "Nam": "Nữ") + 
		" - " + this.getDiaChiThuongTru().getSoNha() + " " + this.getDiaChiThuongTru().getTenDuong()
		+ " - " + this.getQuocGia();
	}
}

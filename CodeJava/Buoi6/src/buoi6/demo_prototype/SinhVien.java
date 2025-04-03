package buoi6.demo_prototype;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;

	private DiaChi diaChiThuongTru;
	
	public SinhVien(SinhVien x) {
		this.maSinhVien = x.maSinhVien;
		this.hoTen = x.hoTen;
		this.gioiTinhNam = x.gioiTinhNam;
		this.diaChiThuongTru = x.diaChiThuongTru;
	}
	
	public SinhVien taoBanSao() {
		return new SinhVien(this);
	}
	
	public String toString() {
		return "Sinh viên " + this.getHoTen() + " - " + (this.isGioiTinhNam()? "Nam": "Nữ") + " - " + this.getDiaChiThuongTru().getSoNha() + " " + this.getDiaChiThuongTru().getTenDuong();
	}
}
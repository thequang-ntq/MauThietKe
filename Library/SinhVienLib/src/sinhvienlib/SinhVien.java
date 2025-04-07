package sinhvienlib;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private double dtb;
	
	public String type() {
		return "SV";
	}
	
	public String toString() {
		return "Sinh viên: " + this.getMaSinhVien() + " - " + this.getHoTen() + " - " + this.getDtb();
	}
}

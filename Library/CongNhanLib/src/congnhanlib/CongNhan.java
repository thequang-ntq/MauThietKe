package congnhanlib;


import java.time.LocalDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CongNhan {
	private String hoTen;
	private LocalDate ngayBatDauVaoLam;
	
	public String type() {
		return "CN";
	}
//	@SuppressWarnings("deprecation")
	public String toString() {
		return "Công nhân: " + this.getHoTen() + " - " + this.getNgayBatDauVaoLam().getDayOfMonth() + "/" + this.getNgayBatDauVaoLam().getMonthValue() + "/" + this.getNgayBatDauVaoLam().getYear();
	}
}

package decorator_bt.deco;

import java.time.LocalDate;

import decorator_bt.component.ThueBao;

import lombok.*;

@Getter
@Setter
public abstract class KhuyenMai extends ThueBao {
	protected LocalDate ngayBatDauApDung;
	
	protected ThueBao x;
	
	public KhuyenMai(ThueBao x) {
		this.ngayBatDauApDung = LocalDate.now();
		this.x = x;
	}
}

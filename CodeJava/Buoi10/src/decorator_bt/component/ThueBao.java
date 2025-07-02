package decorator_bt.component;
import lombok.*;

@Data
public abstract class ThueBao {
	protected double soDu;
	public abstract int getPhiThueBao();
	public abstract int getSoPhutGoiFree();
	public abstract int getSoTinNhanFree();
	public abstract int getGiaGoi(); // goi 1 phut ton bao nhieu
	public abstract int getGiaTinNhan(); // 1 tin nhan ton bao nhieu
}

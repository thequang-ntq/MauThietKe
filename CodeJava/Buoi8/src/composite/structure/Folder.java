package composite.structure;

import java.util.List;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folder implements Component {
	private String tenThuMuc;
	private List<Component> lstThanhPhan;
	
	@Override
	public double getDungLuong() {
		double tongDungLuong = 0;
		for (Component x: lstThanhPhan)
			tongDungLuong += x.getDungLuong();
		return tongDungLuong;
	}
	@Override
	public String getDuongDan() {
		return "";
	}
}

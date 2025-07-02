package composite.structure;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class File implements Component {
	private String tenFile;
	private double dungLuongCuaFile;
	
	@Override
	public double getDungLuong() {
		return this.dungLuongCuaFile;
	}
	@Override
	public String getDuongDan() {
		return "";
	}
}

package _22T1020362.models;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nganh {
	private int maNganh;
	private String tenNganh;
	
	public String toString() {
		return maNganh + "," + tenNganh + "\n";
	}
}

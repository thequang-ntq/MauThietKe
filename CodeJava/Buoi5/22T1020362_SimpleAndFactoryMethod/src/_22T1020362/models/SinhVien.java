package _22T1020362.models;

import java.sql.Date;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private Date ngaySinh;
	
	public String toString() {
        return maSinhVien + "," + hoTen + "," + (gioiTinhNam ? "True" : "False") + "," + ngaySinh;
    }
}

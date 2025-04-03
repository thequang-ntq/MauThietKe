package buoi6.builder;

import lombok.*;

@Builder
@Getter
@Setter
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private java.sql.Date ngaySinh;
	private int maNganhDaoTao; // mã ngành đào tạo
	
	public String toString() {
		return "Sinh viên: mã sinh viên-" + this.maSinhVien + " họ tên-" + this.hoTen + " giới tính-" + (this.gioiTinhNam ? "Nam" : "Nữ") + " ngày sinh-" + this.ngaySinh  
				+ " mã ngành-" + this.maNganhDaoTao;
	}
}

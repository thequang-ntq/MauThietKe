package singletondemo.model;

public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private String maNganhDaoTao;

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public void setMaSinhVien(String maSinhVien) {
		this.maSinhVien = maSinhVien;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public boolean isGioiTinhNam() {
		return gioiTinhNam;
	}

	public void setGioiTinhNam(boolean gioiTinhNam) {
		this.gioiTinhNam = gioiTinhNam;
	}

	public String getMaNganhDaoTao() {
		return maNganhDaoTao;
	}

	public void setMaNganhDaoTao(String maNganhDaoTao) {
		this.maNganhDaoTao = maNganhDaoTao;
	}

	public SinhVien(String maSinhVien, String hoTen, boolean gioiTinhNam, String maNganhDaoTao) {
		super();
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.gioiTinhNam = gioiTinhNam;
		this.maNganhDaoTao = maNganhDaoTao;
	}

}

package solid_01.models;


public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private int maNganhDaoTao;
	
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

	public int getMaNganhDaoTao() {
		return maNganhDaoTao;
	}

	public void setMaNganhDaoTao(int maNganhDaoTao) {
		this.maNganhDaoTao = maNganhDaoTao;
	}

	public SinhVien(String maSinhVien, String hoTen, boolean gioiTinhNam, int maNganhDaoTao) {
		this.maSinhVien = maSinhVien;
		this.hoTen = hoTen;
		this.gioiTinhNam = gioiTinhNam;
		this.maNganhDaoTao = maNganhDaoTao;
	}
}

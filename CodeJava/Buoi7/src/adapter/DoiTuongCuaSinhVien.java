package adapter;

import sinhvienlib.SinhVien;

public class DoiTuongCuaSinhVien extends DoiTuong{
	private SinhVien sv;
	
	public DoiTuongCuaSinhVien(SinhVien sv) {
		this.sv = sv;
	}
	
	@Override
	public String getDoUuTien() {
		double dtb = this.sv.getDtb();
		if(dtb < 4.0f) {
			return "X";
		}
		else if(dtb < 5.5f) {
			return "D";
		}
		else if(dtb < 7.0f) {
			return "C";
		}
		else if(dtb < 8.5f) {
			return "B";
		}
		else {
			return "A";
		}
	}
	@Override
	public String getHoTen() {
		return sv.getHoTen();
	}
	@Override
	public String getLoai() {
		return "SV";
	}
}

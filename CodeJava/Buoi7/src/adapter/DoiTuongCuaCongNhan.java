package adapter;

import java.time.LocalDate;

import congnhanlib.CongNhan;

public class DoiTuongCuaCongNhan extends DoiTuong{
	private CongNhan cn;
	
	public DoiTuongCuaCongNhan(CongNhan cn) {
		this.cn = cn;
	}
	
	@Override
	public String getDoUuTien() {
		LocalDate now = LocalDate.now();
		int namHT = now.getYear();
		int namVaoLam = this.cn.getNgayBatDauVaoLam().getYear();
		int soNamLamViec = namHT - namVaoLam + 1;
		if(soNamLamViec < 1) {
			return "X";
		}
		else if(soNamLamViec < 5) {
			return "D";
		}
		else if(soNamLamViec < 10) {
			return "C";
		}
		else if(soNamLamViec < 20) {
			return "B";
		}
		else {
			return "A";
		}
	}
	@Override
	public String getHoTen() {
		return cn.getHoTen();
	}
	@Override
	public String getLoai() {
		return "CN";
	}
}

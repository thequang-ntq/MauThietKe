package adapter;

//import congnhanlib.CongNhan;

public class DoUuTien_CongNhan extends DoUuTien_SinhVien{
	private DoUuTien_SinhVien dSV;
	public DoUuTien_CongNhan(DoUuTien_SinhVien dSV) {
		this.dSV = dSV;
	}
	
	@Override
	public String doUuTien(double num) {
		num = (int) num;
		if(num < 1) {
			return "X";
		}
		else if(num < 5) {
			return "D";
		}
		else if(num < 10) {
			return "C";
		}
		else if(num < 20) {
			return "B";
		}
		else {
			return "A";
		}
	}
}

package adapter;

public class DoUuTien_SinhVien {
	
	public String doUuTien(double num) {
		if(num < 4) {
			return "X";
		}
		else if(num < 5.5) {
			return "D";
		}
		else if(num < 7) {
			return "C";
		}
		else if(num < 8.5) {
			return "B";
		}
		else {
			return "A";
		}	
	}
}

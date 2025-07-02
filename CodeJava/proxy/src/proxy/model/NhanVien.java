package proxy.model;


public class NhanVien {
		private String hoTen;
		private double heSoLuong;
		private String chucVu;
	
		public NhanVien(String employeeName, double employeeSalary, String employeeDesignation) {
			this.hoTen = employeeName;
			this.heSoLuong = employeeSalary;
			this.chucVu = employeeDesignation;
		}
	
		public String getHoTen() {
			return hoTen;
		}
	
		public double getHeSoLuong() {
			return heSoLuong;
		}
	
		public String getChucVu() {
			return chucVu;
		}
	
		public String toString() {
			return hoTen + ", chức vụ: " + chucVu + ", HSL: " + heSoLuong;
		}

}
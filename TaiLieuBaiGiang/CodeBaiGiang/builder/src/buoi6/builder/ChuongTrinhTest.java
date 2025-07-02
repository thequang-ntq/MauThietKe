package buoi6.builder;

public class ChuongTrinhTest {
	
	public static void main (String[] args) {
//		testPhanSo();
		testBanh();
		testSinhVien();
	}

	private static void testSinhVien() {
		// TODO Auto-generated method stub
		SinhVien sv = new SinhVien.SinhVienBuilder().maSinhVien("22T1020362").hoTen("Quang").gioiTinhNam(true).build();
		System.out.println(sv.toString());
	}

	private static void testBanh() {
		// TODO Auto-generated method stub
		Banh x = new Banh.BanhBuilder(1, 2).vani(2).nướcDừa(2).cacao(3).ớt(4).tiêu(1).build();
//		Banh y = new Banh(1, 2).vani(9);
		System.out.println(x.toString());
	}
	
	
}

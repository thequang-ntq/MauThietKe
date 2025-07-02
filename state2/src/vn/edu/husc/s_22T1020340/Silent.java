package vn.edu.husc.s_22T1020340;

public class Silent implements State {
	@Override
	public void CuocGoiDen() {
		System.out.println("Co cuoc goi den: ");
		Utils.rung();
		//
	}

	@Override
	public void TinNhan() {
		System.out.println("Co tin nhan den: ");
		//
	}

	@Override
	public void HeThong() {
		System.out.println("Thong bao he thong: ");
		//
	}
}

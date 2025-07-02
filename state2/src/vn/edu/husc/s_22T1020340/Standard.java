package vn.edu.husc.s_22T1020340;

public class Standard implements State {

	@Override
	public void CuocGoiDen() {
		System.out.println("Co cuoc goi den: ");
		Utils.rung();
		Utils.phátÂmThanh(80, 3);
	}

	@Override
	public void TinNhan() {
		System.out.println("Co tin nhan den: ");
		Utils.phátÂmThanh(60, 1);
	}

	@Override
	public void HeThong() {
		System.out.println("Thong bao he thong: ");
		Utils.phátÂmThanh(50, 1);
	}

}

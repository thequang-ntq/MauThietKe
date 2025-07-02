package vn.edu.husc.s_22T1020340;

public class Outdoor implements State {
	@Override
	public void CuocGoiDen() {
		System.out.println("Co cuoc goi den: ");
		Utils.rung();
		Utils.rung();
		Utils.rung();
		Utils.phátÂmThanh(100, 5);
	}

	@Override
	public void TinNhan() {
		System.out.println("Co tin nhan den: ");
		Utils.phátÂmThanh(100, 1);
	}

	@Override
	public void HeThong() {
		System.out.println("Thong bao he thong: ");
		Utils.phátÂmThanh(90, 1);
	}
}

package vn.edu.husc.s_22T1020340;

public class Phone {
	private State state;
	public void setTrangThai (State s) {
		this.state = s;
	}
	public void CoCuocGoiDen() {
		state.CuocGoiDen();
	}
	public void CoTinNhan() {
		state.TinNhan();
	}
	public void CoTBHeThong() {
		state.HeThong();
	}
}

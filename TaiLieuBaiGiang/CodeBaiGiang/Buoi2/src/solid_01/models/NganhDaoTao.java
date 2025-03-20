package solid_01.models;

public class NganhDaoTao {
	private int maNganh;
	private String tenNganh;

	public NganhDaoTao(int maNganhDaoTao, String tenNganh2) {
		this.maNganh = maNganhDaoTao;
		this.tenNganh = tenNganh2;
	}

	public int getMaNganh() {
		return maNganh;
	}

	public void setMaNganh(int maNganh) {
		this.maNganh = maNganh;
	}

	public String getTenNganh() {
		return tenNganh;
	}

	public void setTenNganh(String tenNganh) {
		this.tenNganh = tenNganh;
	}

}

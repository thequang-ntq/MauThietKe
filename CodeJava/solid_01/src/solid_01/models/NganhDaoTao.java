package solid_01.models;

public class NganhDaoTao {
	private int maNganhDaoTao;
	private String tenNganhDaoTao;
	public NganhDaoTao(int maNganhDaoTao, String tenNganhDaoTao) {
//		super();
		this.maNganhDaoTao = maNganhDaoTao;
		this.tenNganhDaoTao = tenNganhDaoTao;
	}
	public int getMaNganhDaoTao() {
		return maNganhDaoTao;
	}
	public void setMaNganhDaoTao(int maNganhDaoTao) {
		this.maNganhDaoTao = maNganhDaoTao;
	}
	public String getTenNganhDaoTao() {
		return tenNganhDaoTao;
	}
	public void setTenNganhDaoTao(String tenNganhDaoTao) {
		this.tenNganhDaoTao = tenNganhDaoTao;
	}
	
}

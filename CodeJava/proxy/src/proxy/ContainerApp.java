package proxy;

import proxy.proxy.NhanVienServiceInterface;

public class ContainerApp {
	private String id;
	private String ten;
	private String diaChi;
	
	private NhanVienServiceInterface serviceNhanVien;

	public ContainerApp(String tenCongTy, String diaChi, String maCongTy, NhanVienServiceInterface svc) {
		this.ten = tenCongTy;
		this.diaChi = diaChi;
		this.id = maCongTy;
		this.serviceNhanVien = svc;

		System.out.println("Constructor của class ContainerApp...");
	}

	public String getTen() {
		return ten;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public String getId() {
		return id;
	}

	public NhanVienServiceInterface getNhanVienService() {
		return serviceNhanVien;
	}

}

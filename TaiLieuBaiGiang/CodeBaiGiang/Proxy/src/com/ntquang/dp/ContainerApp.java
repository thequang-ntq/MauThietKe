package com.ntquang.dp;

import com.ntquang.dp.proxy.SinhVienServiceInterface;
import lombok.Getter;

@Getter
public class ContainerApp {
	private String id;
	private String ten;
	private String diaChi;
	
	private SinhVienServiceInterface serviceSinhVien;

	public ContainerApp(String tenTruong, String diaChi, String maTruong, SinhVienServiceInterface svc) {
		this.ten = tenTruong;
		this.diaChi = diaChi;
		this.id = maTruong;
		this.serviceSinhVien = svc;

	}

	public SinhVienServiceInterface getSinhVienService() {
		return serviceSinhVien;
	}

}


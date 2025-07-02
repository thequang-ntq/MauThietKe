package com.ntquang.dp.proxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ntquang.dp.models.SinhVien;

import com.ntquang.dp.config.DBConfig;

public class SinhVienServiceImpl implements SinhVienServiceInterface {

	@Override
	public List<SinhVien> getDanhSachSinhVien() {
		List<SinhVien> stuList = new ArrayList<>();
		String sql = "SELECT * FROM sinhvien;";
		Connection cn = DBConfig.getInstance().getCn();
		try {
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				SinhVien s = new SinhVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4));
				stuList.add(s);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return stuList;
	}
}
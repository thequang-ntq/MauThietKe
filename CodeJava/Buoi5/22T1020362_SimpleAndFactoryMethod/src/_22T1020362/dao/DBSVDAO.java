package _22T1020362.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
public class DBSVDAO implements ISVDAO{
	
	private Connection cn;
	
	@Override
	public List<SinhVien> readSV(){
	
		List<SinhVien> lst = new ArrayList<>();
		String sql = "SELECT * FROM SinhVien";
		Connection cn = this.cn;
		try {
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				SinhVien s = new SinhVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4));
				lst.add(s);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return lst;

	}
	
	@Override
	public void insertSV(SinhVien sv){
	
		String sql1 = "SELECT * FROM SinhVien WHERE MaSinhVien LIKE " + "'" + sv.getMaSinhVien() + "'";
		String sql2 = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinhNam, NgaySinh) VALUES (?, ?, ?, ?)";
		Connection cn = this.cn;
		try {
			PreparedStatement pr = cn.prepareStatement(sql1);
			ResultSet rs = pr.executeQuery();
			if(rs.isBeforeFirst()) {
				System.out.println("Mã sinh viên đã tồn tại trong hệ thống, quý khách xin vui lòng kiểm tra lại.");
			}
			else {
				pr = cn.prepareStatement(sql2);
				pr.setString(1, sv.getMaSinhVien());
	            pr.setString(2, sv.getHoTen());
	            pr.setBoolean(3, sv.isGioiTinhNam());
	            pr.setDate(4, sv.getNgaySinh());
	            int rowInserted = pr.executeUpdate();
	            if(rowInserted > 0) {
	            	System.out.println("Thêm mới sinh viên có mã: " + sv.getMaSinhVien() + " thành công");
	            }
	            else {
	            	System.out.println("Lỗi không xác định, hệ thống đang kiểm tra lại, xin quý khách vui lòng đợi trong giây lát");
	            }
			}
			rs.close();
			pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteSV(String msv){
	
		String sql1 = "SELECT * FROM SinhVien WHERE MaSinhVien LIKE " + "'" + msv + "'";
		String sql2 = "DELETE FROM SinhVien WHERE MaSinhVien LIKE ?";
		Connection cn = this.cn;
		try {
			PreparedStatement pr = cn.prepareStatement(sql1);
			ResultSet rs = pr.executeQuery();
			if(!rs.isBeforeFirst()) {
				System.out.println("Mã sinh viên không tồn tại trong hệ thống, quý khách xin vui lòng kiểm tra lại.");
			}
			else {
				pr = cn.prepareStatement(sql2);
				pr.setString(1, msv);
	            int rowInserted = pr.executeUpdate();
	            if(rowInserted > 0) {
	            	System.out.println("Xóa thành công sinh viên có mã: " + msv);
	            }
	            else {
	            	System.out.println("Lỗi không xác định, hệ thống đang kiểm tra lại, xin quý khách vui lòng đợi trong giây lát");
	            }
			}
			rs.close();
			pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
}

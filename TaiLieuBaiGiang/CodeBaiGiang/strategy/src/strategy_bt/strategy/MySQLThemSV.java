package strategy_bt.strategy;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import strategy_bt.config.MySQLConfig;
import strategy_bt.model.SinhVien;

public class MySQLThemSV implements StrategyThemSV{
	@Override
	public void themSV(ArrayList<SinhVien> arrSV) {
	    String sqlCheck = "SELECT 1 FROM sinhvien WHERE MaSinhVien = ?;";
	    String sqlInsert = "INSERT INTO sinhvien (MaSinhVien, HoTen, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?);";

	    Connection cn = MySQLConfig.getInstance().getCn();

	    try {
	        for (SinhVien sv : arrSV) {
	            // 1. Kiểm tra sinh viên đã tồn tại
	            PreparedStatement prCheck = cn.prepareStatement(sqlCheck);
	            prCheck.setString(1, sv.getMasv());
	            ResultSet rs = prCheck.executeQuery();

	            if (rs.next()) {
	                System.out.println("Mã sinh viên " + sv.getMasv() + " đã tồn tại, bỏ qua.");
	            } else {
	                // 2. Nếu chưa tồn tại, thêm mới
	                PreparedStatement prInsert = cn.prepareStatement(sqlInsert);
	                prInsert.setString(1, sv.getMasv());
	                prInsert.setString(2, sv.getHoten());
	                prInsert.setBoolean(3, sv.isGt()); // true: Nam, false: Nữ
	                prInsert.setDate(4, new Date(sv.getNgaysinh().getTime())); // java.util.Date → java.sql.Date

	                int rowsInserted = prInsert.executeUpdate();
	                if (rowsInserted > 0) {
	                    System.out.println("Đã thêm sinh viên " + sv.getMasv());
	                }

	                prInsert.close();
	            }

	            rs.close();
	            prCheck.close();
	        }
	        System.out.println("Đã thêm tập dữ liệu sinh viên cho MySQL");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}

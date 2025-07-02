package strategy_bt.strategy;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import strategy_bt.config.SQLiteConfig;
import strategy_bt.model.SinhVien;
//import strategy_bt.strategy.StrategyThemSV;

public class SQLiteThemSV implements StrategyThemSV{
	@Override
	public void themSV(ArrayList<SinhVien> arrSV) {
	    String sqlCheck = "SELECT 1 FROM SinhVien WHERE MaSinhVien = ?";
	    String sqlInsert = "INSERT INTO SinhVien (MaSinhVien, HoTen, GioiTinh, NgaySinh) VALUES (?, ?, ?, ?)";

	    Connection cn = SQLiteConfig.getInstance().getCn();

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
	             // Chuyển Date -> String
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	                String ngaySinhStr = sdf.format(sv.getNgaysinh());
	                prInsert.setString(4, ngaySinhStr);

	                int rowsInserted = prInsert.executeUpdate();
	                if (rowsInserted > 0) {
	                    System.out.println("Đã thêm sinh viên " + sv.getMasv());
	                }

	                prInsert.close();
	            }

	            rs.close();
	            prCheck.close();
	        }
	        System.out.println("Đã thêm tập dữ liệu sinh viên cho SQLite");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}

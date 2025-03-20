package buoi4.dao.readData;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import buoi4.config.DBConfig;
import buoi4.models.SinhVien;

public class DBSinhVienDAO {
	public List<SinhVien> readDataSV(){
	
		List<SinhVien> lst = new ArrayList<>();
		String sql = "SELECT * FROM vd_ses4_designpatterns.sinhvien;";
		Connection cn = DBConfig.getInstance().getCn();
		try {
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				SinhVien s = new SinhVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4), rs.getDate(5));
				lst.add(s);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return lst;

	}
}

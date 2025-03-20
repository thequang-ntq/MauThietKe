package buoi4.dao.search;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import buoi4.config.DBConfig;
import buoi4.dao.readData.DBSinhVienDAO;
import buoi4.hashMap.LimitedCache;
import buoi4.models.SinhVien;
import lombok.Data;

public class DBTimKiemSVDAO {
	
	@Data
	class CacheKetQua {
		List<SinhVien> lst;		
		Date thoiDiemTinh;
	}
	
	private Map<String, CacheKetQua> cache = new LimitedCache<String, CacheKetQua>(15); //max of 15 objects
	
	private List<SinhVien> layDsSinhVienTuSQLQuery(Connection cn, String sql, String keyword, List<SinhVien> lst){
		try {
			 PreparedStatement ps = cn.prepareStatement(sql);
	            ps.setString(1, "%" + keyword + "%"); 

	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	            	SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getBoolean(3), rs.getInt(4), rs.getDate(5));
	                lst.add(sv);
	            }
	            rs.close();
	            ps.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return lst;
	}
	
	public List<SinhVien> timKiemSV(String keyword) {
		// TODO: Chú ý thêm về logic
		List<SinhVien> lst = new ArrayList<>();
		String sql = "SELECT * FROM vd_ses4_designpatterns.SinhVien WHERE HoTen LIKE ?;";
		Connection cn = DBConfig.getInstance().getCn();
		
		//Variable
		CacheKetQua kq;
		LocalDate now = LocalDate.now();
		Date thoiDiemHT = Date.valueOf(now);
		
		
		if (cache.containsKey(keyword) == false) {
			lst = layDsSinhVienTuSQLQuery(cn, sql, keyword, lst);
			kq = new CacheKetQua();
			kq.setLst(lst);
			kq.setThoiDiemTinh(thoiDiemHT);
			cache.put(keyword, kq);
		}
		else {
			kq = cache.get(keyword);
			Date thoiDiemTinh = kq.getThoiDiemTinh();
			long delta = ( thoiDiemHT.getTime() - thoiDiemTinh.getTime() ) / 1000;
			
			if(delta > 50) {
				lst = layDsSinhVienTuSQLQuery(cn, sql, keyword, lst);
				kq = new CacheKetQua();
				kq.setLst(lst);
				kq.setThoiDiemTinh(thoiDiemHT);
				cache.put(keyword, kq);
				
			}
			else lst = kq.getLst();
		}

		return lst;
	}
}

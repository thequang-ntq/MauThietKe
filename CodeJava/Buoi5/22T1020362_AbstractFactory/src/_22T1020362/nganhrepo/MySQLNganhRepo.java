package _22T1020362.nganhrepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import _22T1020362.models.Nganh;
import lombok.*;

@AllArgsConstructor
public class MySQLNganhRepo implements INganhRepo{
	
	private Connection cn;
	
	@Override
	public List<Nganh> readNDT(){
	
		List<Nganh> lst = new ArrayList<>();
		String sql = "SELECT * FROM Nganh;";
		Connection cn = this.cn;
		try {
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				Nganh ndt = new Nganh(rs.getInt(1), rs.getString(2));
				lst.add(ndt);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return lst;

	}
	
	@Override
	public void insertNDT(Nganh ndt){
	
		String sql1 = "SELECT * FROM Nganh WHERE MaNganh LIKE " + "'" + ndt.getMaNganh() + "'";
		String sql2 = "INSERT INTO Nganh (MaNganh, TenNganh) VALUES (?, ?)";
		Connection cn = this.cn;
		try {
			PreparedStatement pr = cn.prepareStatement(sql1);
			ResultSet rs = pr.executeQuery();
			if(rs.isBeforeFirst()) {
				System.out.println("Mã ngành đã tồn tại trong hệ thống, quý khách xin vui lòng kiểm tra lại.");
			}
			else {
				pr = cn.prepareStatement(sql2);
				pr.setInt(1, ndt.getMaNganh());
	            pr.setString(2, ndt.getTenNganh());
	            int rowInserted = pr.executeUpdate();
	            if(rowInserted > 0) {
	            	System.out.println("Thêm mới ngành đào tạo có mã: " + ndt.getMaNganh() + " thành công");
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

package solid_01.dao.nganhdaotao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;

public class DbNganhDaoTaoDAO implements INganhDaoTaoDAO {
	
	@Override
	public List<NganhDaoTao> docDanhSachNganh() {
		List<NganhDaoTao> danhSachNganh = new ArrayList<>();

		String sql = "SELECT * FROM nganhdaotao;";
		Connection cn;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Nạp driver thành công"); 
			
			//Ket noi CSDL
			String url = "jdbc:mysql://localhost:3306/quanlysv?useUSSL=false";
			String user = "root";
			String pass = "quang";
			
			cn = DriverManager.getConnection(url, user, pass);
			System.out.println("Kết nối CSDL thành công");
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				NganhDaoTao n = new NganhDaoTao(rs.getInt(1), rs.getString(2));
				danhSachNganh.add(n);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return danhSachNganh;
	}
}

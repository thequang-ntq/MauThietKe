package solid_01.dao.sinhvien;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import solid_01.models.SinhVien;

public class TextSinhVienDAO implements ISinhVienDAO {
	private String duongDanSinhVien;
	
	public TextSinhVienDAO() {
		///
	}
	
	public TextSinhVienDAO(String duongDanSinhVien) {
		this.duongDanSinhVien = duongDanSinhVien;
	}
	
	public List<SinhVien> docDanhSachSinhVien() {
		
		//Đọc từ nguồn dữ liệu
		List<SinhVien> danhSachSinhVien = new ArrayList<>();
		
		//BufferedReader
		//BufferedReader br = new BufferedReader(new FileReader(tenFile));
        //String line;
        // while ((line = br.readLine()) != null)
        
        //FileInputStream
		try {
			FileInputStream fis = new FileInputStream(duongDanSinhVien);
	        Scanner sc = new Scanner(fis);
	        
	        // Bỏ qua dòng tiêu đề nếu có
	        //br.readLine(); // Ví dụ: mãSV|họ tên|giới tính|mã ngành đào tạo
	        String line;
	        while (sc.hasNextLine()) {
	        	line = sc.nextLine();
	        	if(line.isEmpty()) break;
	            String[] parts = line.split("\\|");
	            if (parts.length == 4) {
	                String maSV = parts[0];
	                String hoTen = parts[1];
	                boolean gioiTinh = Boolean.parseBoolean(parts[2]);
	                int maNganhDaoTao = Integer.parseInt(parts[3]);

	                SinhVien sv = new SinhVien(maSV, hoTen, gioiTinh, maNganhDaoTao);
	                danhSachSinhVien.add(sv);
	            }
	        }
	        sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        return danhSachSinhVien;
	}	
}
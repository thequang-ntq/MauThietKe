package solid_01.dao.nganhdaotao;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import solid_01.models.NganhDaoTao;

public class TextNganhDaoTaoDAO implements INganhDaoTaoDAO {
	private String duongDanNganhDaoTao;
	
	public TextNganhDaoTaoDAO() {
		///
	}
	
	public TextNganhDaoTaoDAO(String duongDanNganhDaoTao) {
		this.duongDanNganhDaoTao = duongDanNganhDaoTao;
	}
	
	@Override
	public List<NganhDaoTao> docDanhSachNganh() {
		
		List<NganhDaoTao> danhSachNganh = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(duongDanNganhDaoTao);
	        Scanner sc = new Scanner(fis);
	        
	        // Bỏ qua dòng tiêu đề nếu có
	        //br.readLine(); // Ví dụ: mãSV|họ tên|giới tính|mã ngành đào tạo
	        String line;
	        while (sc.hasNextLine()) {
	        	line = sc.nextLine();
	        	if(line.isEmpty()) break;
	            String[] fields = line.split("\\|");
	            if (fields.length == 2) {
	            	int maNganhDaoTao = Integer.parseInt(fields[0]);
					String tenNganhDaoTao = fields[1];

					NganhDaoTao x = new NganhDaoTao(maNganhDaoTao, tenNganhDaoTao);
					danhSachNganh.add(x);
	            }
	        }
	        sc.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
        return danhSachNganh;
	}
}

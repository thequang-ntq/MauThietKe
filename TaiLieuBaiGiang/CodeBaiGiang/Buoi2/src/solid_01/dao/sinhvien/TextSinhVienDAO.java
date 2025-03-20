package solid_01.dao.sinhvien;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;
import solid_01.models.SinhVien;

public class TextSinhVienDAO implements ISinhVienDAO {
	private String duongDan;

	public TextSinhVienDAO() {
		///
	}
	
	public TextSinhVienDAO(String ddSinhVien) {
		setDuongDan(ddSinhVien);
	}

	public void setDuongDan(String duongDan) {
		this.duongDan = duongDan;
	}

	public List<SinhVien> docTuNguonDuLieu() {
		List<SinhVien> danhSachSinhVien = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(duongDan))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split("\\|");
				if (fields.length == 4) {
					String maSinhVien = fields[0];
					String hoTen = fields[1];
					boolean gioiTinhNam = Boolean.parseBoolean(fields[2]);
					int maNganhDaoTao = Integer.parseInt(fields[3]);

					SinhVien sinhVien = new SinhVien(maSinhVien, hoTen, gioiTinhNam, maNganhDaoTao);
					danhSachSinhVien.add(sinhVien);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return danhSachSinhVien;
	}

	
}

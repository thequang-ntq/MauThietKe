package solid_01.dao.nganhdaotao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;

public class TextNganhDaoTaoDAO implements INganhDaoTaoDAO {
	private String duongDanNganhDaoTao;

	@Override
	public List<NganhDaoTao> docDanhSachNganh() {
		List<NganhDaoTao> lstNganh = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(duongDanNganhDaoTao))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split("\\|");
				if (fields.length == 2) {
					int maNganhDaoTao = Integer.parseInt(fields[0]);
					String tenNganh = fields[1];

					NganhDaoTao x = new NganhDaoTao(maNganhDaoTao, tenNganh);
					lstNganh.add(x);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lstNganh;
	}

	public TextNganhDaoTaoDAO(String duongDanNganhDaoTao) {
		super();
		this.duongDanNganhDaoTao = duongDanNganhDaoTao;
	}

}

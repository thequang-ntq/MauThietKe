package solid_01.dao.nganhdaotao;

import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;

public class FakeNganhDaoTaoDAO implements INganhDaoTaoDAO {
	@Override
	public List<NganhDaoTao> docDanhSachNganh() {
		List<NganhDaoTao> lstNganh = new ArrayList<>();
		
		lstNganh.add(new NganhDaoTao(102, "Công nghệ thông tin"));
		lstNganh.add(new NganhDaoTao(104, "Toán cao cấp"));
		lstNganh.add(new NganhDaoTao(38, "Báo chí"));
		return lstNganh;
	}
}

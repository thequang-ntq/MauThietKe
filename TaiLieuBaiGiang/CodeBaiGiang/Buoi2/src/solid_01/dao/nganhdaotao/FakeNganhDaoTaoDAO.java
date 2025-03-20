package solid_01.dao.nganhdaotao;

import java.util.ArrayList;
import java.util.List;

import solid_01.models.NganhDaoTao;

public class FakeNganhDaoTaoDAO implements INganhDaoTaoDAO {

	@Override
	public List<NganhDaoTao> docDanhSachNganh() {
		List<NganhDaoTao> lst = new ArrayList<>();
		
		lst.add(new NganhDaoTao(1, "Ngành 1"));
		lst.add(new NganhDaoTao(2, "Ngành 2"));
		lst.add(new NganhDaoTao(3, "Ngành 3"));
		lst.add(new NganhDaoTao(4, "Ngành 4"));
		lst.add(new NganhDaoTao(5, "Ngành 5"));
		
		return lst;
	}

}

package _22T1020362.abstractfactory;

import _22T1020362.config.MySQLConfig;
import _22T1020362.nganhrepo.INganhRepo;
import _22T1020362.nganhrepo.MySQLNganhRepo;
import _22T1020362.sinhvienrepo.ISinhVienRepo;
import _22T1020362.sinhvienrepo.MySQLSinhVienRepo;

public class MySQLRepoFactory extends RepoFactory {
	@Override
	public ISinhVienRepo getSinhVienRepo() {
		return new MySQLSinhVienRepo(MySQLConfig.getInstance().getCn());
	}
	
	@Override
	public INganhRepo getNganhRepo() {
		return new MySQLNganhRepo(MySQLConfig.getInstance().getCn());
	}
}

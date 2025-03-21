package _22T1020362.abstractfactory;

import _22T1020362.config.MongoDBConfig;
import _22T1020362.nganhrepo.INganhRepo;
import _22T1020362.nganhrepo.MongoDBNganhRepo;
import _22T1020362.sinhvienrepo.ISinhVienRepo;
import _22T1020362.sinhvienrepo.MongoDBSinhVienRepo;

public class MongoDBRepoFactory extends RepoFactory{
	@Override
	public ISinhVienRepo getSinhVienRepo() {
		return new MongoDBSinhVienRepo(MongoDBConfig.getInstance().getDB());
	}
	
	@Override
	public INganhRepo getNganhRepo() {
		return new MongoDBNganhRepo(MongoDBConfig.getInstance().getDB());
	}
}

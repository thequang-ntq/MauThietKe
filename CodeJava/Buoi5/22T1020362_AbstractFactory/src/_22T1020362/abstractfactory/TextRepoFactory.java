package _22T1020362.abstractfactory;

import _22T1020362.config.TextConfig;
import _22T1020362.nganhrepo.INganhRepo;
import _22T1020362.nganhrepo.TextNganhRepo;
import _22T1020362.sinhvienrepo.ISinhVienRepo;
import _22T1020362.sinhvienrepo.TextSinhVienRepo;

public class TextRepoFactory extends RepoFactory {
	@Override
	public ISinhVienRepo getSinhVienRepo() {
		return new TextSinhVienRepo(TextConfig.getInstance().getTextFileUrl());
	}
	
	@Override
	public INganhRepo getNganhRepo() {
		return new TextNganhRepo(TextConfig.getInstance().getTextFileUrl());
	}
}

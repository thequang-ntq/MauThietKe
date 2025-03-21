package _22T1020362.factorymethod;

import _22T1020362.config.DBConfig;
import _22T1020362.dao.DBSVDAO;
import _22T1020362.dao.ISVDAO;

public class DBSVDAOFactory extends MethodSVDAOFactory {
	@Override
	public ISVDAO getDAO() {
		return new DBSVDAO(DBConfig.getInstance().getCn());
	}
}

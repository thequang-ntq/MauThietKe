package _22T1020362.factorymethod;

import _22T1020362.config.TextFileConfig;
import _22T1020362.dao.ISVDAO;
import _22T1020362.dao.TextFileSVDAO;

public class TextFileSVDAOFactory extends MethodSVDAOFactory {
	@Override
	public ISVDAO getDAO() {
		return new TextFileSVDAO(TextFileConfig.getInstance().getTextFileUrl());
	}
}

package _22T1020362.simplefactory;

import _22T1020362.config.DBConfig;
import _22T1020362.config.TextFileConfig;
import _22T1020362.dao.DBSVDAO;
import _22T1020362.dao.ISVDAO;
import _22T1020362.dao.TextFileSVDAO;

public class SVDAOFactory{
	public ISVDAO getDAO(String type) {
		
		//thay đổi loại nguồn dữ liệu (Factory) 
		//& chạy 3 bước đọc thêm xóa trong kịch bản (ISVDAO, DBSVDAO, FileSVDAO)
	    switch (type) {
	        case "MS_SQLSERVER":
	            return new DBSVDAO(DBConfig.getInstance().getCn());
	        case "TEXT_FILE":
	        	return new TextFileSVDAO(TextFileConfig.getInstance().getTextFileUrl());
	        default:
	            throw new IllegalArgumentException("Không hỗ trợ nguồn dữ liệu: " + type);
	    }
	}
}

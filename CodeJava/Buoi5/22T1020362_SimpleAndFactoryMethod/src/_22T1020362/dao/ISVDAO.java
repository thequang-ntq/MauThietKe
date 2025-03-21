package _22T1020362.dao;

import java.util.List;

import _22T1020362.models.SinhVien;

public interface ISVDAO {
	List<SinhVien> readSV();  
    void insertSV(SinhVien sv); 
    void deleteSV(String msv);
}

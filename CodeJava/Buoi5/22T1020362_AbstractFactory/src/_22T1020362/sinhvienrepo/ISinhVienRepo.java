package _22T1020362.sinhvienrepo;

import java.util.List;

import _22T1020362.models.SinhVien;

public interface ISinhVienRepo {
	List<SinhVien> readSV();  
    void deleteSV(String msv);
}

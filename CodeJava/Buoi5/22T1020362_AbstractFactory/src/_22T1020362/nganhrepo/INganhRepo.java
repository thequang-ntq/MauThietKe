package _22T1020362.nganhrepo;

import java.util.List;

import _22T1020362.models.Nganh;

public interface INganhRepo {
	List<Nganh> readNDT();  
    void insertNDT(Nganh ndt);
}

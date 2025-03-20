package buoi4.dao.readData;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import buoi4.models.SinhVien;

public class FakeSinhVienDAO {
	public List<SinhVien> readDataSV(){
		List<SinhVien> lstSinhVien = new ArrayList<>();
		String dateOfSV1 = "2004-10-17", dateOfSV2 = "2004-02-11", dateOfSV3 = "2004-09-26";
		Date dateOfSVien1 = Date.valueOf(dateOfSV1), dateOfSVien2 = Date.valueOf(dateOfSV2), dateOfSVien3 = Date.valueOf(dateOfSV3);
		lstSinhVien.add(new SinhVien("22T1020340", "Võ Minh Quân", false, 102, dateOfSVien1));
		lstSinhVien.add(new SinhVien("22T1020606", "Hoàng Trọng Hiếu", true, 102, dateOfSVien2));
		lstSinhVien.add(new SinhVien("22T0001111", "Folotino", true, 0, dateOfSVien3));
		return lstSinhVien;
	}
}

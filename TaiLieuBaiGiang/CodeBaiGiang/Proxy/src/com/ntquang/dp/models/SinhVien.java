package com.ntquang.dp.models;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SinhVien {
	private String maSinhVien;
	private String hoTen;
	private boolean gioiTinhNam;
	private Date ngaySinh;
	
	public String toString() {
		DateTimeFormatter inputFm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		DateTimeFormatter outputFm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String temp = ngaySinh.toString();
		LocalDate ns = LocalDate.parse(temp, inputFm);
        return maSinhVien + ", " + hoTen + ", " + (gioiTinhNam ? "Nam" : "Nữ") + ", " + ns.format(outputFm);
    }
}

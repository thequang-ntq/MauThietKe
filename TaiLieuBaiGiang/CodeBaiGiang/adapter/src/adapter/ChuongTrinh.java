package adapter;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import congnhanlib.CongNhan;
import congnhanlib.CongNhanReader;
import sinhvienlib.SinhVien;
import sinhvienlib.SinhVienReader;

public class ChuongTrinh {

	public static void main(String[] args) {
		// Tạo ra danh sách các đối tượng
		// Xử lý đối tượng
		// In danh sách
		// DoiTuong x = lst.get(i);
		// System.out.printf("%d %s %s %s\n",
//							x.getHoTen(),
//							x.getLoai(),
//							x.getDoUuTien());
//		doc();
		in();
	}

	private static void in() {
		List<SinhVien> lstSV = SinhVienReader.loadFromFile("sv.txt");
		List<CongNhan> lstCN = CongNhanReader.loadFromFile("cn.txt");
		List<DoiTuong> lst = new ArrayList<>();
		//Chuyển từ nguồn sinh viên qua
		for(SinhVien x: lstSV) {
			DoiTuongCuaSinhVien x1 = new DoiTuongCuaSinhVien(x);
			lst.add(x1);
		}
		//Chuyển từ nguồn công nhân qua
		for(CongNhan x: lstCN) {
			DoiTuongCuaCongNhan x1 = new DoiTuongCuaCongNhan(x);
			lst.add(x1);
		}
		
		for(int i = 0; i < lst.size(); i++) {
			for(int j = i+1; j< lst.size(); j++) {
				if(lst.get(i).getDoUuTien().compareTo(lst.get(j).getDoUuTien()) > 0) {
					var temp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, temp);
				}
			}
		}
		System.out.println("Danh sách:");
		System.out.println("STT | Họ tên | Loại | Độ ưu tiên");
		for(int i = 0; i < lst.size(); i++) {
			System.out.println((i+1) + " | " + lst.get(i).getHoTen() + " | " + lst.get(i).getLoai() + " | " + lst.get(i).getDoUuTien());
		}
		
//		Map<SinhVien, String> mapSV = new HashMap<SinhVien, String>();
//		lstSV.sort(Comparator.comparing(SinhVien::getDtb).reversed());
//		Map<CongNhan, String> mapCN = new HashMap<CongNhan, String>();
//		lstCN.sort(Comparator.comparing(CongNhan::getNgayBatDauVaoLam));
//		DoUuTien_SinhVien n = new DoUuTien_SinhVien();
//		for(SinhVien sv: lstSV) {
//			String dut = n.doUuTien(sv.getDtb());
//			mapSV.put(sv, dut);
//		}
//		for(CongNhan cn: lstCN) {
//			DoUuTien_CongNhan n2 = new DoUuTien_CongNhan(n);
//			LocalDate now = LocalDate.now();
//			Period pr = Period.between(cn.getNgayBatDauVaoLam(), now);
//			String dut = n2.doUuTien(pr.getYears());
//			mapCN.put(cn, dut);
//		}
//		System.out.println("Danh sách:");
//		System.out.println("STT | Thông tin chi tiết | Loại | Độ ưu tiên");
//		int i = 1;
//		while(mapSV.size() != 0  || mapCN.size() != 0) {
//			String dutMaxSV = (mapSV.size() != 0) ? Collections.min(mapSV.values()) : "Z";
//			String dutMaxCN = (mapCN.size() != 0) ? Collections.min(mapCN.values()) : "Z";
//			//Nếu cùng độ ưu tiên thì ưu tiên in sinh viên trước
//			if(dutMaxSV.compareTo(dutMaxCN) <= 0) {
//				for(Map.Entry<SinhVien, String> m : mapSV.entrySet()) {
//					if(m.getValue().equals(dutMaxSV)) {
//						System.out.print(i + " | ");
//						System.out.println(m.getKey().toString() + " | " + m.getKey().type() + " | " + m.getValue());
//						mapSV.remove(m.getKey());
//						i++;
//						break;
//					}
//				}
//			}
//			else {
//				for(Map.Entry<CongNhan, String> m : mapCN.entrySet()) {
//					if(m.getValue().equals(dutMaxCN)) {
//						System.out.print(i + " | ");
//						System.out.println(m.getKey().toString() + " | " + m.getKey().type() + " | " + m.getValue());
//						mapCN.remove(m.getKey());
//						i++;
//						break;
//					}
//				}
//			}
//			
//		}
	}

	private static void doc() {
		List<SinhVien> lstSV = SinhVienReader.loadFromFile("sv.txt");
		List<CongNhan> lstCN = CongNhanReader.loadFromFile("cn.txt");
		System.out.println("Danh sách sinh viên:");
		for(SinhVien sv: lstSV) {
			System.out.println(sv.toString());
		}
		System.out.println("Danh sách công nhân:");
		for(CongNhan cn: lstCN) {
			System.out.println(cn.toString());
		}
	}

}

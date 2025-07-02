package com.nvtrung.dp;

import java.util.ArrayList;
import java.util.List;

import com.nvtrung.dp.component.Cafe;
import com.nvtrung.dp.component.CafeChồn;
import com.nvtrung.dp.component.CafePhin;
import com.nvtrung.dp.component.CafeRangXay;
import com.nvtrung.dp.deco.CafeTrangTríRhum;
import com.nvtrung.dp.deco.CafeTrangTríSữa;
import com.nvtrung.dp.deco.TrangTríChoCafe;
import com.nvtrung.dp.deco.CafeTrangTríĐường;

public class ChuongTrinh {
	static void testCafe() throws Exception {
		Cafe x;
		
//		x = new CafeRangXay();
		x = new CafeChồn();
		System.out.printf("%s, giá: %g\n", x.getMôTả(), x.getGiá());
		
		Cafe x2 = null;
//		x2 = new SữaTrangTríChoCafe(x);
//		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());

		x2 = new CafeTrangTríRhum(x);
		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());

//		x2 = new SữaTrangTríChoCafe(x2);
//		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());
//		
//		x2 = new ĐườngTrangTríChoCafe(x2);
//		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());

		x2 = new CafeTrangTríRhum(x2);
		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());
		
		x2 = new CafeTrangTríĐường(x2);
		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());
		
		x2 = new CafeTrangTríSữa(x2);
		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());

//		if (1==1) return;
		
		x2 = new CafeTrangTríRhum(x2);
		System.out.println(x2.getMôTả() + ", giá " + x2.getGiá());
	}

	public static void main(String[] args) {
		try {
			testCafe();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (1 == 1)
			return;

		List<Cafe> lst = new ArrayList<Cafe>();

		// region café phin, có bề mặt đường
		Cafe x;
		x = new CafePhin();
		System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());

		try {
			x = new CafeTrangTríĐường(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			x = new CafeTrangTríĐường(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
			System.out.println("Số lớp đường = " + ((CafeTrangTríĐường) x).getSốLớpĐườngTrangTrí(x));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			x = new CafeTrangTríRhum(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
		} catch (Exception e2) {
			System.out.println("Lỗi khi bổ sung bề mặt rhum");
			e2.printStackTrace();
		}

		try {
			x = new CafeTrangTríSữa(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
		} catch (Exception e1) {
			System.out.println("Lỗi khi tạo lớp bề mặt");
			e1.printStackTrace();
		}

		try {
			x = new CafeTrangTríĐường(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());

			System.out.println("Số lớp đường = " + ((CafeTrangTríĐường) x).getSốLớpĐườngTrangTrí(x));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			x = new CafeTrangTríĐường(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());

			System.out.println("Số lớp đường = " + ((CafeTrangTríĐường) x).getSốLớpĐườngTrangTrí(x));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			x = new CafeTrangTríSữa(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
		} catch (Exception e1) {
			System.out.println("Lỗi khi tạo lớp bề mặt");
			e1.printStackTrace();
		}

		try {
			x = new CafeTrangTríRhum(x);
			System.out.println("x = " + x.getMôTả() + " giá " + x.getGiá());
		} catch (Exception e2) {
			System.out.println("Lỗi khi bổ sung bề mặt rhum");
			e2.printStackTrace();
		}

		lst.add(x);
		// endregion

		// region café rang xay, có các bề mặt: đường, sữa
		try {
			// Cafe x2 = new SữaTrangTríCafe(new ĐườngTrangTríCafe(new CafeRangXay()));
			Cafe x2 = new CafeRangXay();
			x2 = new CafeTrangTríĐường(x2);
			x2 = new CafeTrangTríSữa(x2);
			System.out.println("x2 = " + x2.getMôTả() + " giá " + x2.getGiá());

			lst.add(x2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// endregion

		// region café chồn, rhum
		Cafe x3 = new CafeChồn();
		try {
			x3 = new CafeTrangTríRhum(x3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lst.add(x3);
		// endregion

		System.out.println("Trước khi sắp xếp");
		for (Cafe cafe : lst)
			System.out.println("x = " + cafe.getMôTả() + " giá " + cafe.getGiá());

		{
			System.out.println("==========");
			Cafe x1 = lst.get(0);

			// Lấy bề mặt trên cùng của x1
			Cafe bmx1 = null;
			if (x1 instanceof TrangTríChoCafe)
				bmx1 = ((TrangTríChoCafe) x1).getCafe();
			if (bmx1 != null)
				System.out.println("Bề mặt trên cùng của x1 là " + bmx1.getMôTả());
			else
				System.out.println("Không có bề mặt");
//			Cafe bmx2 = ((TrangTríCafe)bmx1).getCafe();
//			System.out.println("Bề mặt tiếp theo của x1 là " + bmx2.getMôTả());
		}

		if (1 == 1)
			return;

		for (int i = 0; i < lst.size() - 1; i++)
			for (int j = i + 1; j < lst.size(); j++)
				if (lst.get(i).getGiá() < lst.get(j).getGiá()) {
					Cafe tmp = lst.get(i);
					lst.set(i, lst.get(j));
					lst.set(j, tmp);
				}

		System.out.println("Sau khi sắp xếp");
		for (Cafe cafe : lst)
			System.out.println("x = " + cafe.getMôTả() + " giá " + cafe.getGiá());

		/*
		 * Cafe cafe = new CafeRangXay(); System.out.println(cafe.getMôTả() + " giá " +
		 * cafe.getGiá());
		 * 
		 * cafe = new ĐườngTrangTríCafe(cafe); System.out.println(cafe.getMôTả() +
		 * " giá " + cafe.getGiá());
		 * 
		 * try { cafe = new SữaTrangTríCafe(cafe); } catch (Exception e) {
		 * e.printStackTrace(); } System.out.println(cafe.getMôTả() + " giá " +
		 * cafe.getGiá());
		 * 
		 * 
		 * cafe = new ĐườngTrangTríCafe(cafe); System.out.println(cafe.getMôTả() +
		 * " giá " + cafe.getGiá());
		 * 
		 * cafe = new ĐườngTrangTríCafe(cafe); System.out.println(cafe.getMôTả() +
		 * " giá " + cafe.getGiá());
		 * 
		 * 
		 * try { cafe = new SữaTrangTríCafe(cafe); } catch (Exception e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * System.out.println(cafe.getMôTả() + " giá " + cafe.getGiá());
		 */
	}
}

package com.nvtrung.dp.deco;

import com.nvtrung.dp.component.Cafe;

public class CafeTrangTríĐường extends TrangTríChoCafe {

	@Override
	public String getMôTả() {
		// mô tả của ly café + ", đường"
		return this.cafe.getMôTả() + " + đường"; //////
	}

	@Override
	public double getGiá() {
		// giá của ly café + giá bề mặt này
		return this.cafe.getGiá() + 500; 
	}

	public int getSốLớpĐườngTrangTrí(Cafe cafe) {
		// đếm xem có bao nhiêu lớp
		// đường-trang-trí-cho-cafe đã thêm vào cafe?
		int nĐườngTrangTrí = 0;
		Cafe x2 = cafe;
		while (true) {
			if (x2 instanceof TrangTríChoCafe) {
				// x2 đang là lớp trang trí
				if (x2 instanceof CafeTrangTríĐường)
					nĐườngTrangTrí++;
				
				// chuyển xuống lớp trang trí tiếp theo
				// hoặc là cafe
				x2 = ((TrangTríChoCafe) x2).getCafe();
			}
			else
				break;
		}
		
		return nĐườngTrangTrí;
	}
	
	public CafeTrangTríĐường(Cafe cafe) throws Exception {
//		if (getSốLớpĐườngTrangTrí(cafe) >= 2)
//			throw new Exception("Không được thêm quá 2 lớp trang trí đường");
		this.cafe = cafe;
	}
}

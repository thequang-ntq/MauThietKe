package com.nvtrung.dp.simplefactory.ui;

import com.nvtrung.dp.simplefactory.ConVật;
import com.nvtrung.dp.simplefactory.ConVậtFactory;

public class ChuongTrinh {

	public static void main(String[] args) {
		testConVật();
	}

	private static void testConVật() {
		ConVật x = null;
		ConVậtFactory f = new ConVậtFactory();

		// 1. Khởi tạo con vật x
		x = f.getConVật("MÈO");
		// x = f.getConVật("CHÓ");
		// x = f.getConVật("GÀ");

		// 2. Thể hiện hoạt cảnh của game
		x.kêu();
	}

}

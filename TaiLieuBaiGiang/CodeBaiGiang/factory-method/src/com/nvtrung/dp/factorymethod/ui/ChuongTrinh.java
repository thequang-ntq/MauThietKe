package com.nvtrung.dp.factorymethod.ui;

import com.nvtrung.dp.factorymethod.ChóFactory;
import com.nvtrung.dp.factorymethod.ConVật;
import com.nvtrung.dp.factorymethod.ConVậtFactory;
import com.nvtrung.dp.factorymethod.GàFactory;
import com.nvtrung.dp.factorymethod.MèoFactory;

public class ChuongTrinh {
	static void testFactoryMethod() {
		// 1. Khai báo
		ConVật x;
		ConVậtFactory f;

		// 2. Tạo đối tượng
		// x = (new MèoFactory()).getConVật();
		// x = (new ChóFactory()).getConVật();
		x = (new GàFactory()).getConVật();

		// 3. Thể hiện hoạt cảnh
		x.kêu();
	}

	public static void main(String[] args) {
		testFactoryMethod();
	}
}

package com.nvtrung.dp.absfactory.style2;

import com.nvtrung.dp.absfactory.DongVatAnCo;
import com.nvtrung.dp.absfactory.DongVatAnThit;

public class SoiRung implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sói rừng châu Á đuổi\n", this.toString());
		x.chạy();
	}

}

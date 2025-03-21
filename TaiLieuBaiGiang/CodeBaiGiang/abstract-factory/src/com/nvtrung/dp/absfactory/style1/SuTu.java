package com.nvtrung.dp.absfactory.style1;

import com.nvtrung.dp.absfactory.DongVatAnCo;
import com.nvtrung.dp.absfactory.DongVatAnThit;

public class SuTu implements DongVatAnThit {

	@Override
	public void đuổiTheo(DongVatAnCo x) {
		System.out.printf("Sư tử châu Phi đuổi\n", this.toString());
		x.chạy();
	}
}

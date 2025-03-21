package com.nvtrung.dp.absfactory.style1;

import com.nvtrung.dp.absfactory.DongVatAnCo;

public class NguaVan implements DongVatAnCo {

	@Override
	public void chạy() {
		System.out.printf("Ngựa vằn châu Phi chạy :D", this.toString());
	}
}

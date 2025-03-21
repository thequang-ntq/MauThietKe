package com.nvtrung.dp.absfactory.style1;

import com.nvtrung.dp.absfactory.DongVatAnCo;
import com.nvtrung.dp.absfactory.DongVatAnThit;
import com.nvtrung.dp.absfactory.DongVatFactory;

public class FactoryStyle1 extends DongVatFactory {

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new NguaVan();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SuTu();
	}

}

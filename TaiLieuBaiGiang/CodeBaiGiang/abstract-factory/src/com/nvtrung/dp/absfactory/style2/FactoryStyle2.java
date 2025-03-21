package com.nvtrung.dp.absfactory.style2;

import com.nvtrung.dp.absfactory.DongVatAnCo;
import com.nvtrung.dp.absfactory.DongVatAnThit;
import com.nvtrung.dp.absfactory.DongVatFactory;

public class FactoryStyle2 extends DongVatFactory{

	@Override
	public DongVatAnCo createDongVatAnCo() {
		return new Soc();
	}

	@Override
	public DongVatAnThit createDongVatAnThit() {
		return new SoiRung();
	}

}

package com.nvtrung.dp.factorymethod;

public class ChóFactory extends ConVậtFactory{

	@Override
	public ConVật getConVật() {
		return new Chó();
	}

}

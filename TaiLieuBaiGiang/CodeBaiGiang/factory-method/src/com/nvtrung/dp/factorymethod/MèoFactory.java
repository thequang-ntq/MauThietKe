package com.nvtrung.dp.factorymethod;

public class MèoFactory extends ConVậtFactory{

	@Override
	public ConVật getConVật() {
		return new Mèo();
	}

}

package com.nvtrung.dp.factorymethod;

public class GàFactory extends ConVậtFactory {

	@Override
	public ConVật getConVật() {
		return new Gà();
	}

}

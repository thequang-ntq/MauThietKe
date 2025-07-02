package com.nvtrung.dp.deco;

import com.nvtrung.dp.component.Cafe;

public abstract class TrangTríChoCafe extends Cafe { // IS-A

	protected Cafe cafe; // HAS-A

	public Cafe getCafe() {
		return this.cafe;
	}	
}

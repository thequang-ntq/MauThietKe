package com.nvtrung.dp.states;

import com.nvtrung.dp.Utils;

public class StateNgoàiTrời implements State {

	@Override
	public void onCalling() {
		System.out.printf("OnCalling: [\n");
		Utils.rung();
		Utils.rung();
		Utils.rung();
		Utils.phátÂmThanh(100, 5);
		System.out.printf("]\n");
	}

	@Override
	public void onSMSReceived() {
		System.out.println("On SMS received: [");
		Utils.phátÂmThanh(100, 1);
		System.out.println("]");
	}

	@Override
	public void onSystemNotification() {
		System.out.println("On System notification: [");
		Utils.phátÂmThanh(90, 1);
		System.out.println("]");		
	}

}

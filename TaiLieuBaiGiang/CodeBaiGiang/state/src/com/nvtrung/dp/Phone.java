package com.nvtrung.dp;

import com.nvtrung.dp.states.State;

public class Phone { //giống context trong strategy
	private State state;

	public void onCalling() {
		this.state.onCalling();
	}
	
	public void onSMSReceived() {
		this.state.onSMSReceived();
	}
	
	public void onSystemNotification() {
		this.state.onSystemNotification();
	}
	//Hàm thêm
	public void setProfile(State state) {
		System.out.printf("Thiết lập trạng thái [%s] cho điện thoại\n", state.getClass().toString());
		this.state = state;
	}
}

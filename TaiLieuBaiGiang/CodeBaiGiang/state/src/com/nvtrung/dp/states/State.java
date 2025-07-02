package com.nvtrung.dp.states;

public interface State {
	void onCalling();
	void onSMSReceived();
	void onSystemNotification();
}

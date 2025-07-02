package com.nvtrung.dp;

import com.nvtrung.dp.states.StateNgoàiTrời;
import com.nvtrung.dp.states.StateYênLặng;

public class TestProgram {

	public static void main(String[] args) {
		Phone dt = new Phone();
		
		// 1a, b, c, d) Thiết lập trạng thái NgoàiTrời cho điện thoại
		dt.setProfile(new StateNgoàiTrời());
		dt.onSMSReceived();
		dt.onCalling();
		dt.onSystemNotification();
		
		// 2a, b, c, d) Thử nghiệm với trạng thái YênLặng cho điện thoại
		dt.setProfile(new StateYênLặng());
		dt.onSMSReceived();
		dt.onCalling();
		dt.onSystemNotification();
	}

}

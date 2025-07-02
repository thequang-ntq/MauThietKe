package strategy_demo;

import strategy_demo.context.ContextSapXep;
import strategy_demo.strategy.SapXepChen;
import strategy_demo.strategy.SapXepNhanh;
import strategy_demo.strategy.SapXepNoiBot;
import strategy_demo.strategy.StrategySapXep;

public class Client {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		ContextSapXep context = new ContextSapXep();
		StrategySapXep[] strategies = {new SapXepNoiBot(), new SapXepChen(), new SapXepNhanh()};

		for (StrategySapXep engine: strategies) {
				var t1 = System.currentTimeMillis();
				context.setStrategy(engine);
				context.sapXep(arr);
				var t2 = System.currentTimeMillis();
				long tgtt = t2 - t1;
				System.out.println("Thời gian thực thi: " + String.valueOf(tgtt) + " ms");
				// thoi gian thuc thi (1)  = t2 - t1 (ms)
		}
	}
}

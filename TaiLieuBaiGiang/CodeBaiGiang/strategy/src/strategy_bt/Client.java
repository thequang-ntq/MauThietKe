package strategy_bt;

import java.util.ArrayList;

import strategy_bt.context.ContextThemSV;
import strategy_bt.model.SinhVien;
import strategy_bt.strategy.MySQLThemSV;
import strategy_bt.strategy.SQLServerThemSV;
import strategy_bt.strategy.SQLiteThemSV;
import strategy_bt.strategy.StrategyThemSV;

public class Client {
	
	private static void taoMangSV(ArrayList<SinhVien> arrSV, int n) {
		for(int i = 0; i < n; i++) {
			SinhVien x = new SinhVien();
			x.generate();
			arrSV.add(x);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<SinhVien> arrSV = new ArrayList<>();
		int n = 1000;
		taoMangSV(arrSV, n);
		ContextThemSV context = new ContextThemSV();
		StrategyThemSV[] strategies = {new MySQLThemSV(), new SQLServerThemSV(), new SQLiteThemSV()};

		for (StrategyThemSV engine: strategies) {
				var t1 = System.currentTimeMillis();
				context.setStrategy(engine);
				context.themSV(arrSV);
				var t2 = System.currentTimeMillis();
				long tgtt = t2 - t1;
				System.out.println("Thời gian thực thi: " + String.valueOf(tgtt) + " ms");
				// thoi gian thuc thi (1)  = t2 - t1 (ms)
		}
	}
}

package strategy_bt.context;

import java.util.ArrayList;

import lombok.*;
import strategy_bt.model.SinhVien;
import strategy_bt.strategy.StrategyThemSV;

@Setter
public class ContextThemSV {
	private StrategyThemSV strategy;
	
	public void themSV(ArrayList<SinhVien> arrSV) {
		strategy.themSV(arrSV);
	}
}

package strategy_demo.context;

import strategy_demo.strategy.StrategySapXep;
import lombok.*;

@Setter
public class ContextSapXep {
	private StrategySapXep strategy;
	
	public void sapXep(int[] arr) {
		strategy.sapXep(arr);
	}
}

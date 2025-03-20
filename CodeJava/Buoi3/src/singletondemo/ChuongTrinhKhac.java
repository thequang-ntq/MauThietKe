package singletondemo;

import java.util.HashMap;
import java.util.Map;
//Lazy loading
public class ChuongTrinhKhac {

	static Map<String, Integer> cache = new HashMap<String, Integer>();

	private static int getTổng(int a, int b) {

		String baiToan = a + "_" + b;

		if (cache.containsKey(baiToan) == false) {
			System.out.printf("Bắt đầu tính tổng %d + %d...", a, b);
			int kq = a + b;

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("...Đã tính tổng xong");
			cache.put(baiToan, kq);
			return kq;
		} else {
			System.out.println("Sử dụng cache để giải bài toán " + baiToan);
			int kq = cache.get(baiToan);
			return kq;
		}
			
	}

	public static void main(String[] args) {
		int x = getTổng(10, 2);
		System.out.println(x);

		x = getTổng(2, 13);
		System.out.println(x);
		
		x = getTổng(10, 2);
		System.out.println(x);

	}

}

package buoi4;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ChuongTrinh {

	static Map<String, Integer> cache = new HashMap<String, Integer>();
	
	static int tinhTong(int a, int b) {
		String baiToan = a + "+" + b;
		if (cache.containsKey(baiToan)  == false) {
			System.out.println("Bài toán chưa có trong cache. Giải...");
			
			int kq = a + b;
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cache.put(baiToan, kq);
		}
		
		return cache.get(baiToan);
	}
	
	public static void main(String[] args) {
//		testLombok();
		testCaching();
	}

	private static void testCaching() {
		Random rnd = new Random();
		
		for (int i = 0; i < 100; i++) {
			int a = rnd.nextInt(3); // 0 -> 2 => 3 kha nang
			int b = rnd.nextInt(2); // 0 -> 1 => 2 kha nang
			// Tỷ lệ trúng cache: 100/(2*3)
			
			System.out.printf("%d + %d = ?...\n", a, b);
			int x = tinhTong(a, b);
			System.out.println("KQ = " + x);
		}
		
	}

	private static void testLombok() {
		// // TODO Auto-generated method stub
//		SinhVien x;
		testCaching();
		
	}

}
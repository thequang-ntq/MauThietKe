package test;

import test.ite.IteratorSoNguyen;
import test.ite.implement.IteratorSoNguyenDuong;
import test.ite.implement.IteratorSoNguyenVTChan;
import test.ite.implement.MyDataStructure;

public class ChuongTrinhThuNghiem {

	public static void main(String[] args) {
		MyDataStructure x = new MyDataStructure();
		x.add(1);
		x.add(2);
		x.add(100);
		x.add(-1340);
		x.add(135);
		x.add(12);
		x.add(-4);
		x.add(5);
		
		IteratorSoNguyen it;
		it = x.getIteratorSoNguyenChuan();
		it = x.getIteratorSoNguyenDuong();
		it = new IteratorSoNguyenDuong(1, 2, -4, 55, 566, -3, 1, -1, 10);
		
//		it = new IteratorSoNguyenVTChan(x.getLst());
		
		it.start();
		while (it.hasNext()) {
			int e = it.next();
			
			System.out.printf("%d ", e);
		}
		
//		for (int i = 0; i < lst.size(); i++)
//			if (lst.get(i) .)
//			System.out.printf("%d ", lst.get(i));
	}

}

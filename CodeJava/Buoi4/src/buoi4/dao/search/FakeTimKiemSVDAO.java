package buoi4.dao.search;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import buoi4.dao.readData.FakeSinhVienDAO;
import buoi4.models.SinhVien;

public class FakeTimKiemSVDAO {
	
	public static List<SinhVien> timKiemSV(String keyword, FakeSinhVienDAO dao) {
		
		Map<String, List<SinhVien>> cache = new HashMap<String, List<SinhVien>>();
		
		String baiToan = "Tim kiem sinh vien: " + keyword;
		List<SinhVien> lst = dao.readDataSV();
		
		if (cache.containsKey(baiToan)  == false) {
			System.out.println("Bài toán chưa có trong cache. Giải...");
			
			Iterator<SinhVien> iterator = lst.iterator();
	        while (iterator.hasNext()) {
	            SinhVien sv = iterator.next();
	            if ((!sv.getHoTen().contains(keyword)) 
						&& (!sv.getHoTen().contains(keyword.toLowerCase())) 
						&& (!sv.getHoTen().contains(keyword.toUpperCase())) 
					)  
	            {
	                iterator.remove();
	            }
	        }
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			cache.put(baiToan, lst);
		}
		
		return cache.get(baiToan);
	}

}

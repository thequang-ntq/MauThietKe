package strategy_bt.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVien {
	private String masv;
	private String hoten;
	private boolean gt;
	private Date ngaysinh;
	
	public void generate() {
		Random rd = new Random();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        //masv
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        this.masv = sb.toString();
        //hoten
        String[] hoList = {"Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Vũ", "Phan", "Đặng", "Bùi", "Đỗ"};
        String[] tenList = {"Anh", "Bình", "Chi", "Dũng", "Em", "Giang", "Hà", "Khánh", "Linh", "Minh"};
        String ho = hoList[random.nextInt(hoList.length)];
        String ten = tenList[random.nextInt(tenList.length)];
        this.hoten = ho + " " + ten;
        //gt
        this.gt = rd.nextBoolean();
        //ngaySinh
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.of(2006, 12, 31);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        long randomDays = rd.nextInt((int) days + 1);
        this.ngaysinh = Date.valueOf(startDate.plusDays(randomDays));
	}
}

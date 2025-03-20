package solid_01.dao.sinhvien;

import java.util.ArrayList;
import java.util.List;

import solid_01.models.SinhVien;
//DataAccessObject (DAO): là một interface định nghĩa các phương thức trừu tượng
//việc triển khai truy cập dữ liệu cơ bản cho 
//BusinessObject để cho phép truy cập vào nguồn dữ liệu (DataSource).
//Liên lạc với anh chị khóa trên làm khóa luận tốt nghiệp thông qua thầy Trung
//Học cải thiện môn chuyên ngành
//Kiến thức đa ngành - Khoa học máy tính, AI, big data
//xây dựng mạng giả lập - docker, ...
//Design Business Project
//Đặt tên file là Mã sinh viên
//Viết 1 chương trình đọc điểm lấy tên file excel mã sinh viên lọc ra điểm rèn luyện
//Sau đó bỏ danh sách điểm rl đó ra một file excel khác đặt tên là Tên lớp - DiemRenLuyen
//Chứng chỉ B1
public class FakeSinhVienDAO implements ISinhVienDAO {
	@Override
	public List<SinhVien> docDanhSachSinhVien() {
		List<SinhVien> lstSinhVien = new ArrayList<>();
		
		lstSinhVien.add(new SinhVien("22T1020340", "Võ Minh Quân", false, 102));
		lstSinhVien.add(new SinhVien("22T1020606", "Hoàng Trọng Hiếu", true, 102));
		lstSinhVien.add(new SinhVien("22T0001111", "Folotino", true, 0));
		return lstSinhVien;
	}
}

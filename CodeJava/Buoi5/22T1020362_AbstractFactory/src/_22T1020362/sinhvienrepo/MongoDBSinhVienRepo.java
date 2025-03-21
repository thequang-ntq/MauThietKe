package _22T1020362.sinhvienrepo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import _22T1020362.models.SinhVien;
import lombok.*;

@AllArgsConstructor
public class MongoDBSinhVienRepo implements ISinhVienRepo{
	
	private MongoDatabase db;
	
	@Override
	public List<SinhVien> readSV(){
		List<SinhVien> lst = new ArrayList<>();
		try {
            MongoDatabase db = this.db;
            MongoCollection<Document> collection = db.getCollection("sinhvien");
            FindIterable<Document> documents = collection.find();
            // Chuyển đổi Document thành Student
            for (Document doc : documents) {
                String maSinhVien = doc.getString("MaSinhVien");
                String hoTen = doc.getString("HoTen");
                int maNganh = doc.getInteger("MaNganh");

                SinhVien sv = new SinhVien(maSinhVien, hoTen, maNganh);
                lst.add(sv);
            }
        } catch (Exception e) {
            System.err.println("Lỗi kết nối MongoDB: " + e.getMessage());
        }
		return lst;

	}
	
	@Override
	public void deleteSV(String msv){
		
		try {
            MongoDatabase db = this.db;
            MongoCollection<Document> collection = db.getCollection("sinhvien");
            //Tìm có SV không
            Document found = collection.find(Filters.eq("MaSinhVien", msv)).first();
            if(found != null) {
            	collection.deleteOne(Filters.eq("MaSinhVien", msv));
                System.out.println("Đã xóa sinh viên có MaSinhVien: " + msv);
            }
            else {
            	System.out.println("Không tìm thấy sinh viên có MaSinhVien: " + msv);
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa dữ liệu: " + e.getMessage());
        }
		
	}
}

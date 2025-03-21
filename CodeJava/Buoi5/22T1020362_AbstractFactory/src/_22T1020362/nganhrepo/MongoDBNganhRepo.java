package _22T1020362.nganhrepo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import _22T1020362.models.Nganh;
import lombok.*;

@AllArgsConstructor
public class MongoDBNganhRepo implements INganhRepo{
	
	private MongoDatabase db;
	
	@Override
	public List<Nganh> readNDT(){
		List<Nganh> lst = new ArrayList<>();
		try {
            MongoDatabase db = this.db;
            MongoCollection<Document> collection = db.getCollection("nganh");
            FindIterable<Document> documents = collection.find();
            // Chuyển đổi Document thành Student
            for (Document doc : documents) {
            	int maNganh = doc.getInteger("MaNganh");
                String tenNganh = doc.getString("TenNganh");

                Nganh ndt = new Nganh(maNganh, tenNganh);
                lst.add(ndt);
            }
        } catch (Exception e) {
            System.err.println("Lỗi kết nối MongoDB: " + e.getMessage());
        }
		return lst;

	}
	
	@Override
	public void insertNDT(Nganh ndt){
		
		try {
            MongoDatabase db = this.db;
            MongoCollection<Document> collection = db.getCollection("nganh");

            Document found = collection.find(Filters.eq("MaNganh", ndt.getMaNganh())).first();
            if(found != null) {
                System.out.println("Ngành có MaNganh: " + ndt.getMaNganh() + " đã tồn tại trong hệ thống");
            }
            else {
            	Document newNDT = new Document("MaNganh", ndt.getMaNganh()).append("TenNganh", ndt.getTenNganh());
                collection.insertOne(newNDT);

                System.out.println("Đã chèn thành công ngành: " + newNDT.toJson());
            }
            
        } catch (Exception e) {
            System.err.println("Lỗi khi chèn dữ liệu: " + e.getMessage());
        }
		
	}
}

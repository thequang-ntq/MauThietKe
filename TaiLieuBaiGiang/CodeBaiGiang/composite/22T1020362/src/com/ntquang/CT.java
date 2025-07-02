package com.ntquang;

import java.util.List;
import java.util.Scanner;

import com.ntquang.structure.Component;
//import com.ntquang.structure.File;
//import com.ntquang.structure.Folder;
import com.ntquang.config.SQLConfig;
import com.ntquang.repo.SQLRepo;


public class CT {
	//BFS khởi tạo cây đối tượng theo kiểu dần dần
	public static void main(String[] args) {
		System.out.println("Câu 1: Đọc toàn bộ cấu trúc cây thư mục: ");
		SQLRepo repo = new SQLRepo(SQLConfig.getInstance().getCn());
		List<Component> ds = repo.read();
		//1. Đọc toàn bộ cấu trúc cây thư mục được lưu trong cơ sở dữ liệu
		repo.print(ds, 0);
		
		System.out.println("Câu 2: Nhập ID và in ra màn hình thông tin phần tử có ID tương ứng: ");
		//2. 2. Nhập từ bàn phím một `Id`, sau đó in ra màn hình thông tin của phần tử tương ứng, bao gồm:
		//		1. Tên của đối tượng
		//		2. Đường dẫn đầy đủ của đối tượng (các thành phần của đường dẫn cách nhau bởi ký tự “/“)
		//		3. Loại đối tượng: là file hay folder
		//		4. Dung lượng của đối tượng
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập ID của phần tử cần in ra màn hình thông tin: ");
		int id = sc.nextInt();
		repo.printID(id);
		
		System.out.println("Câu 3: Bổ sung File vào thư mục ID, bổ sung thành công thì in:");
		//3. Bổ sung thêm một đối tượng `File` tuỳ ý vào thư mục có `Id` nhập từ bàn phím. Sau khi bổ sung thành công thì đọc thông tin thư mục này từ cơ sở dữ liệu và hiển thị ra màn hình:
		//		1. Tên thư mục
		//		2. Đường dẫn đầy đủ của thư mục
		//		3. Danh sách các file (trực tiếp hoặc gián tiếp) của thư mục
		//		4. Dung lượng của thư mục
		System.out.print("Nhập ID của thư mục cần chèn một file vào: ");
		int folderID = sc.nextInt();
		repo.insertFileToFolder(folderID);
		sc.close();
	}
}

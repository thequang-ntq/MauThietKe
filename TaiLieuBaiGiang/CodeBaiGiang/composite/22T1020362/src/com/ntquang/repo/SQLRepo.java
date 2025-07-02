package com.ntquang.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//import com.ntquang.config.SQLConfig;
import com.ntquang.model.PhanTu;
import com.ntquang.structure.Component;
import com.ntquang.structure.File;
import com.ntquang.structure.Folder;

import lombok.*;



import java.sql.*;
//import java.util.*;



@AllArgsConstructor
public class SQLRepo implements IRepo {
	
	private Connection cn;
	
	//Hàm chung để lấy các phần tử trong cơ sở dữ liệu dạng List
	@Override
    public List<Component> read() {
		//ID -> PhanTu
        Map<Integer, PhanTu> map = new HashMap<>();
        //ID cha -> ID
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();

        try (Statement stmt = cn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM PhanTu")) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ten = rs.getString("Ten");
                Integer idCha = rs.getObject("IDCha") != null ? rs.getInt("IDCha") : null;
                double dungLuong = rs.getDouble("DungLuong");
                String loai = rs.getString("Loai");

                map.put(id, new PhanTu(id, ten, idCha, dungLuong, loai));
                if (idCha != null) {
                    childrenMap.computeIfAbsent(idCha, k -> new ArrayList<>()).add(id);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Xây dựng cây thư mục từ gốc
        List<Component> result = new ArrayList<>();
        for (PhanTu entity : map.values()) {
            if (entity.getIdCha() == null) {
                result.add(buildComponent(entity.getId(), map, childrenMap, ""));
            }
        }
        return result;
    }

	//1.
	//Hàm buildComponent
    private Component buildComponent(int id, Map<Integer, PhanTu> map, Map<Integer, List<Integer>> childrenMap, String parentPath) {
        PhanTu entity = map.get(id);
        String currentPath = parentPath.isEmpty() ? entity.getTen() : parentPath + "/" + entity.getTen();

        if ("File".equalsIgnoreCase(entity.getLoai())) {
            return new File(entity.getTen(), entity.getDungLuong(), parentPath);
        } else {
            List<Component> children = new ArrayList<>();
            List<Integer> ids = childrenMap.getOrDefault(id, new ArrayList<>());
            for (int childId : ids) {
                children.add(buildComponent(childId, map, childrenMap, currentPath));
            }
            return new Folder(entity.getTen(), children, parentPath);
        }
    }

    //Hàm print để in ra theo câu 1
    @Override
    public void print(List<Component> ds, int n) {
        for (Component c : ds) {
            printComponent(c, n);
        }
    }
    
    //Cách hàm print ở trên hoạt động
    private void printComponent(Component c, int level) {
        String prefix = "";
        if (level > 0) {
            prefix = "   ".repeat(level - 1) + "|__";
        }

        String ten = (c instanceof Folder)
                ? ((Folder) c).getTenThuMuc()
                : ((File) c).getTenFile();

        String dungLuongStr = (c instanceof File)
                ? String.format(" (%.0f kb)", ((File) c).getDungLuong())
                : "";

        System.out.println(prefix + ten + dungLuongStr);

        if (c instanceof Folder folder) {
            for (Component child : folder.getLstThanhPhan()) {
                printComponent(child, level + 1);
            }
        }
    }

    //2.
    // Tìm một component bất kỳ theo ID
    public Component findById(int idToFind) {
        List<Component> roots = read();
        return findRecursively(roots, idToFind);
    }
    
    private Component findRecursively(List<Component> components, int idToFind) {
        for (Component c : components) {
            String[] parts = c.getDuongDan().split("/");
            String name = parts[parts.length - 1];

            try (PreparedStatement ps = cn.prepareStatement("SELECT * FROM PhanTu WHERE Ten = ?")) {
                ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                if (rs.next() && rs.getInt("ID") == idToFind) {
                    return c;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (c instanceof Folder f) {
                Component result = findRecursively(f.getLstThanhPhan(), idToFind);
                if (result != null) return result;
            }
        }
        return null;
    }
    
    
    @Override
    //In ra theo câu 2 theo ID của phần tử
    public void printID(int ID) {
        Component c = findById(ID); // dùng hàm đã viết ở trên
        if (c == null) {
            System.out.println("Không tìm thấy phần tử có ID = " + ID);
            return;
        }

        String ten = (c instanceof File) ? ((File) c).getTenFile() : ((Folder) c).getTenThuMuc();
        String loai = (c instanceof File) ? "File" : "Folder";
        String duongDan = c.getDuongDan();
        double dungLuong = c.getDungLuong();

        System.out.println("Tên: " + ten);
        System.out.println("Đường dẫn: " + duongDan);
        System.out.println("Loại: " + loai);
        System.out.println("Dung lượng: " + dungLuong + " kb");
    }

    
    //3.
    //Lấy các file trong folder được thêm
    private List<File> getAllFiles(Component c) {
        List<File> result = new ArrayList<>();
        if (c instanceof File f) {
            result.add(f);
        } else if (c instanceof Folder folder) {
            for (Component child : folder.getLstThanhPhan()) {
                result.addAll(getAllFiles(child));
            }
        }
        return result;
    }
    
 // In thông tin chi tiết của folder sau khi thêm file
    public void printFolderDetails(int folderID) {
        Component folder = findById(folderID);
        if (folder == null || !(folder instanceof Folder)) {
            System.out.println("Không tìm thấy folder có ID = " + folderID);
            return;
        }

        Folder f = (Folder) folder;
        System.out.println("Tên thư mục: " + f.getTenThuMuc());
        System.out.println("Đường dẫn đầy đủ: " + f.getDuongDan());

        System.out.println("Danh sách tất cả các file:");
        List<File> allFiles = getAllFiles(f);
        for (File file : allFiles) {
            System.out.println("- " + file.getDuongDan() + " (" + file.getDungLuong() + " kb)");
        }

        System.out.println("Tổng dung lượng thư mục: " + f.getDungLuong() + " kb");
    }

    //Tạo tên file ngẫu nhiên length ký tự
    public static String taoTenFileNgauNhien(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
    
    //Tạo dung lượng ngẫu nhiên [1,10]
    public static double taoDungLuongNgauNhien() {
    	Random rd = new Random();
    	double s = 1 + Math.random() + 9;
    	return s;
    }
    
    //Thêm 1 folder
    @Override
    public void insertFileToFolder(int folderID) {
        int n = 1; // Thêm 1 file

        try (PreparedStatement checkStmt = cn.prepareStatement(
                "SELECT Loai FROM PhanTu WHERE ID = ?")) {
            checkStmt.setInt(1, folderID);
            ResultSet rs = checkStmt.executeQuery();

            // Kiểm tra tồn tại và loại
            if (!rs.next()) {
                System.out.println("Không tồn tại phần tử với ID = " + folderID);
                return;
            }

            String loai = rs.getString("Loai");
            if (!"Folder".equalsIgnoreCase(loai)) {
                System.out.println("Phần tử ID = " + folderID + " không phải là một Folder.");
                return;
            }

            // Nếu hợp lệ, thực hiện thêm file
            try (PreparedStatement ps = cn.prepareStatement(
                    "INSERT INTO PhanTu(Ten, IDCha, DungLuong, Loai) VALUES (?, ?, ?, ?)")) {
                for (int i = 1; i <= n; i++) {
                	//tên file là chuỗi ngẫu nhiên 5 ký tự
                    ps.setString(1, taoTenFileNgauNhien(5));
                    ps.setInt(2, folderID);
                    //dung lượng ngẫu nhiên [1,10]
                    ps.setDouble(3, taoDungLuongNgauNhien());
                    ps.setString(4, "File");
                    ps.executeUpdate();
                }
                System.out.println(n + " file đã được thêm vào folder ID = " + folderID);
            }

            // Hiển thị chi tiết thư mục sau khi chèn
            printFolderDetails(folderID);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	
}

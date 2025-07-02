package composite.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import composite.config.MySQLConfig;
import composite.structure.Component;
import composite.structure.File;
import composite.structure.Folder;

public class MySQLRepo implements IRepo {
	@Override
	public List<File> docFile(){
		List<File> lst = new ArrayList<>();
		String sql = "SELECT tenFile, dungLuongCuaFile FROM file;";
		Connection cn = MySQLConfig.getInstance().getCn();
		try {
			PreparedStatement pr = cn.prepareStatement(sql);
			ResultSet rs = pr.executeQuery();
			while(rs.next()) {
				File f = new File(rs.getString(1), rs.getDouble(2));
				lst.add(f);
			}
			rs.close(); pr.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return lst;
	}
	
	@Override
	//ChatGPT
	public List<Folder> docFolder() {
	    List<Folder> rootFolders = new ArrayList<>();
	    Connection cn = MySQLConfig.getInstance().getCn();

	    try {
	        // B1: Lấy toàn bộ thư mục
	        String sqlFolder = "SELECT ID, tenThuMuc, parent_ID FROM folder;";
	        PreparedStatement psFolder = cn.prepareStatement(sqlFolder);
	        ResultSet rsFolder = psFolder.executeQuery();

	        // Lưu tạm các Folder theo ID của Folder -> Folder
	        Map<Integer, Folder> folderMap = new HashMap<>();
	        // Tạm lưu mối quan hệ ID của Folder -> parent_ID của Folder đó
	        Map<Integer, Integer> folderParentMap = new HashMap<>();

	        while (rsFolder.next()) {
	            int id = rsFolder.getInt("ID");
	            String ten = rsFolder.getString("tenThuMuc");
	            //parent_ID có thể bị null nên phải dùng getObject
	            Integer parentID = rsFolder.getObject("parent_ID") != null ? rsFolder.getInt("parent_ID") : null;

	            Folder folder = new Folder(ten, new ArrayList<>());
	            folderMap.put(id, folder);
	            folderParentMap.put(id, parentID);
	        }
	        

	        // B2: Lấy toàn bộ file và thêm vào folder tương ứng
	        String sqlFile = "SELECT tenFile, dungLuongCuaFile, folder_ID FROM file;";
	        PreparedStatement psFile = cn.prepareStatement(sqlFile);
	        ResultSet rsFile = psFile.executeQuery();

	        while (rsFile.next()) {
	            String tenFile = rsFile.getString("tenFile");
	            double dungLuong = rsFile.getDouble("dungLuongCuaFile");
	            Integer folderID = rsFile.getObject("folder_ID") != null ? rsFile.getInt("folder_ID") : null;

	            File file = new File(tenFile, dungLuong);
	            Folder folder = folderMap.get(folderID);
	            //bỏ file vào folder
	            if (folder != null) {
	                folder.getLstThanhPhan().add(file);
	            }
	        }
	        
	        rsFolder.close();
	        psFolder.close();
	        rsFile.close();
	        psFile.close();

	        // B3: Gắn folder con vào folder cha
	        for (Map.Entry<Integer, Folder> entry : folderMap.entrySet()) {
	            int id = entry.getKey();
	            Folder folder = entry.getValue();
	            Integer parentID = folderParentMap.get(id); // parent_id của id của folder tương ứng
	            if (parentID == null) {
	                rootFolders.add(folder); // không có cha => là thư mục gốc
	            } else {
	                Folder parentFolder = folderMap.get(parentID);
	                if (parentFolder != null) { //liệu nếu đã có parentID thì folder cha có thể null không?
	                    parentFolder.getLstThanhPhan().add(folder); // thêm folder con vào cha
	                }
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return rootFolders;
	}
	
	@Override
	//Hàm đệ quy in ra cấu trúc trong một thư mục root của cây thư mục theo BFS
	//ChatGPT
	public void in(List<Component> ds, int n) {
		//ngắt ra giữa các cấp
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String indent;
		if(n==1) indent = "|__";
		else {
			String tabIndent = "    ".repeat(n-1);
			indent = "|" + tabIndent + "|__";
		}
		
		//B1: In tất cả ở cấp hiện tại
		for(Component c: ds) {

			if(c instanceof Folder) {
				Folder f = (Folder) c;
				System.out.println(indent + f.getTenThuMuc());
			}
			else if(c instanceof File) {
				File f = (File) c;
				System.out.println(indent + f.getTenFile() + " (" + f.getDungLuongCuaFile() + " kb)");
			}
		}
		
		//B2: Đệ quy in thành phần con của các Folder
		for(Component c: ds) {
			if(c instanceof Folder) {
				Folder f = (Folder) c;
				in(f.getLstThanhPhan(), n+1);
			}
		}
	}
	
}

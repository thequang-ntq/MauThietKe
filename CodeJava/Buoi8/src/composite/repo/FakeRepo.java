package composite.repo;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;
import java.util.List;

import composite.structure.File;
import composite.structure.Folder;
import composite.structure.Component;

public class FakeRepo implements IRepo{

	@Override
	public List<File> docFile(){
		List<File> f = new ArrayList<>();
		f.add(new File("baitap01", 5));
		f.add(new File("baitap02", 3));
		f.add(new File("abc", 12));
		f.add(new File("test", 1));
		return f;
	}
	@Override
	public List<Folder> docFolder(){
		List<Folder> fd = new ArrayList<>();
		List<File> f = docFile();
		fd.add(new Folder("LY THUYET", Arrays.asList(f.get(2))));
		fd.add(new Folder("JAVA", Arrays.asList(f.get(0), f.get(1), fd.get(0))));
		fd.add(new Folder("C#", Arrays.asList()));
		fd.add(new Folder("LAP TRINH", Arrays.asList(fd.get(1), fd.get(2), f.get(3))));
		return fd;
	}
	@Override
	//Hàm đệ quy in ra cấu trúc cây thư mục
	public void in(List<Component> ds, int n) {
		String indent;
		if(n==0) indent = "|__";
		else {
			String tabIndent = "	".repeat(n);
			indent = "|" + tabIndent + "|__";
		}
		for(Component c: ds) {
			if(c instanceof Folder) {
				Folder f = (Folder) c;
				System.out.println(indent + f.getTenThuMuc());
				in(f.getLstThanhPhan(), n+1);
			}
			else if(c instanceof File) {
				File f = (File) c;
				System.out.println(indent + f.getTenFile() + " (" + f.getDungLuongCuaFile() + " kb)");
			}
		}
	}
}

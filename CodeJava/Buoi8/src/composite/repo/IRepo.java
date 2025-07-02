package composite.repo;

import java.util.List;

import composite.structure.Component;
import composite.structure.File;
import composite.structure.Folder;

public interface IRepo {
	List<File> docFile();
	List<Folder> docFolder();
	void in(List<Component> ds, int n);
}

package com.ntquang.repo;

import java.util.List;

import com.ntquang.structure.Component;
//import com.ntquang.structure.File;
//import com.ntquang.structure.Folder;

public interface IRepo {
	List<Component> read();
	//1
	void print(List<Component> ds, int n);
	//2
	void printID(int ID);
	//3
	void insertFileToFolder(int FolderID);
}

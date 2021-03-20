package com.salesforce.tests.fs;

import com.salesforce.tests.models.Directory;
import com.salesforce.tests.models.FileNode;

import exceptions.InvalidPathException;

public class Explorer implements FileExplorer {

	private static Explorer explorer = new Explorer();
	 
	private FileNode directoriesTree = new Directory("", "root");
	
	private Explorer() {}

	public static Explorer getExplorer() {
		return explorer;
	}
	
	public FileNode getFileInPath(String path) throws InvalidPathException {
		String[] directories = path.split("/");
		FileNode file = null;
		if(directories.length == 2 && this.directoriesTree.getName().equalsIgnoreCase(directories[1])) {
			return this.directoriesTree;
		} 
		for (int i = 2; i < directories.length; i++) {
			 if("..".equals(directories[i])) {
				if(i == 2) {
					file =  this.directoriesTree;
				} else {
					file = this.getFileInPath(this.directoriesTree, directories[i-1]);
				}
			} else {
				file = this.getFileInPath(this.directoriesTree, directories[i]);
			}
		}
		return file;
	}
	
	private FileNode getFileInPath(FileNode node, String fileName) throws InvalidPathException {
		for (FileNode file : node.listFiles()) {
			if(file.getName().equalsIgnoreCase(fileName)) {
				return file;
			}
		}
		throw new InvalidPathException();
	}
	
}

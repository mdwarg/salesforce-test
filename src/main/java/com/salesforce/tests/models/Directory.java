package com.salesforce.tests.models;

import java.util.Stack;

public class Directory extends File implements FileNode {

	private Stack<FileNode> files;
	private String myPath;
	
	public Directory(String parentPath, String name) {
		super(parentPath, name);
		this.files = new Stack<FileNode>();
		this.myPath = this.getParentPath() + "/" + this.getName();
	}
	
	public Boolean isDirectory() {
		return Boolean.TRUE;
	}

	public Stack<FileNode> listFiles() {
		return this.files;
	}

	public Boolean createNewDirectory(String name) {
		if(this.fileExist(name)) {
			return Boolean.FALSE;
		}
		files.push(new Directory(this.myPath ,name));
		return Boolean.TRUE;
	}
	
	public Boolean createNewFile(String name) {
		if(this.fileExist(name)) {
			return Boolean.FALSE;
		}
		files.push(new File(this.myPath, name));
		return Boolean.TRUE;
	}

	private Boolean fileExist(String name) {
		for (FileNode fileNode : files) {
			if(fileNode.getName().equalsIgnoreCase(name)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

}

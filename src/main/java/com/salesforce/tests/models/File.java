package com.salesforce.tests.models;

import java.util.Stack;

public class File implements FileNode {

	private String name;
	private String parentPath;
	
	public File(String parentPath, String name) {
		super();
		this.parentPath = parentPath;
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getParentPath() {
		return this.parentPath;
	}

	public Boolean isDirectory() {
		return Boolean.FALSE;
	}

	public Stack<FileNode> listFiles() {
		return null;
	}

	public Boolean createNewDirectory(String name) {
		return Boolean.FALSE;
	}

	public Boolean createNewFile(String name) {
		return Boolean.FALSE;
	}
	
	public String getAbsolutePath() {
		return this.parentPath + "/" + name;
	}


}

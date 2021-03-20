package com.salesforce.tests.models;

import java.util.Stack;

public interface FileNode {
	public String getName();
	public String getParentPath();
	public String getAbsolutePath();
	public Boolean isDirectory();
	public Stack<FileNode> listFiles();
	public Boolean createNewDirectory(String name);
	public Boolean createNewFile(String name);
}

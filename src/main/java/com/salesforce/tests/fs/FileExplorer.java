package com.salesforce.tests.fs;

import com.salesforce.tests.models.FileNode;

import exceptions.InvalidPathException;

public interface FileExplorer {
	
	public FileNode getFileInPath(String path) throws InvalidPathException;
	
}
package com.salesforce.tests.models;

import java.util.Stack;

public class Context {
	
	private Stack<String> path = new Stack<String>();

	public Context() {
		super();
	}

	public Context(String currentDirectory) {
		super();
		String[] splitPath = currentDirectory.split("/");
		for (int i = 0; i < splitPath.length; i++) {
			this.path.push(splitPath[i]);			
		}
	}
	
	public void goToPath(String path) {
		String[] splitPath = path.split("/");
		for (int i = 0; i < splitPath.length; i++) {
			if(splitPath[i].equals("..")) {
				this.path.pop();
			} else if(!splitPath[i].equals(".")) {
				this.path.push(splitPath[i]);			
			}
		}
	}

	public String getCurrentDirectory() {
		StringBuffer directoryPath = new StringBuffer();
		for (String directory : this.path) {
			directoryPath.append("/" + directory);
		}
		return directoryPath.toString();
	}
	
}

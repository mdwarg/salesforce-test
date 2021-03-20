package com.salesforce.tests.models;

import java.util.Stack;

public class Context {

	private Stack<String> path = new Stack<String>();

	public Context() {
		super();
		this.path.push("root");
	}

	public void goToPath(String targetPath) {
		String[] splitPath = targetPath.split("/");
		this.path = new Stack<String>();
		for (int i = 1; i < splitPath.length; i++) {
			if (splitPath[i].equals("..")) {
				if (this.path.size() > 1) {
					this.path.pop();
				}
			} else if (!splitPath[i].equals(".")) {
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

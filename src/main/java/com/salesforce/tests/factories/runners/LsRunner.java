package com.salesforce.tests.factories.runners;

import java.io.File;
import java.util.Stack;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.fs.Explorer;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class LsRunner implements CommandRunner {
	private Command command;
	private static String COMMAND_HELP = "To use this command write 'ls' or 'ls -r' if you want list the files recursively";

	public LsRunner(Command command) {
		this.command = command;
	}

	public Boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
		if(!command.getParameters().isEmpty()) {
			throw new InvalidParamsException("Unsoported params. " + COMMAND_HELP);
		}
		boolean recursive = false;
		if(command.getOptions().size() > 1 || (command.getOptions().size() == 1 && !command.getOptions().get(0).equals("-r"))) {
			throw new BadOptionException(command.getOptions().get(0));
		}
		if(command.getOptions().size() == 1 && command.getOptions().get(0).equals("-r")) {
			recursive = true;
		}
		
		listDirectory(context, recursive);
		return Boolean.TRUE;
	}

	private void listDirectory(Context context, boolean recursive) {
		FileNode currentPath = Explorer.getExplorer().getFileInPath(context.getCurrentDirectory());
		Stack<FileNode> fileStack = currentPath.listFiles();
		for (FileNode fileNode : fileStack) {
			System.out.println(fileNode.getAbsolutePath());
			if(recursive && fileNode.isDirectory()) {
				context.goToPath(context.getCurrentDirectory() + "/" + fileNode.getName());
				this.listDirectory(context, recursive);
				context.goToPath(context.getCurrentDirectory() + "/" + "..");
			}			
		}
	}
}
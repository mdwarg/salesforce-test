package com.salesforce.tests.runners;

import java.io.File;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class LsRunner implements CommandRunner {
	private Command command;
	private static String COMMAND_HELP = "To use this command write 'ls' or 'ls -r' if you want list the files recursively";

	public LsRunner(Command command) {
		this.command = command;
	}

	public boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
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
		return true;
	}

	private void listDirectory(Context context, boolean recursive) {
		File currentPath = new File(context.getCurrentDirectory());
		File[] filedList = currentPath.listFiles();
		for (int i = 0; i < filedList.length; i++) {
			File file = filedList[i];
			System.out.println(file.getAbsolutePath().toString());
			if(recursive && file.isDirectory()) {
				context.goToPath(file.getName());
				this.listDirectory(context, recursive);
				context.goToPath("..");
			}			
		}
	}
}
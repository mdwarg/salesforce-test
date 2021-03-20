package com.salesforce.tests.factories.runners;

import java.io.File;
import java.io.IOException;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.fs.Explorer;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class TouchRunner implements CommandRunner {
	private Command command;
	private static String COMMAND_HELP = "To use the command wirte: touch <fileName>";

	public TouchRunner(Command command) {
		this.command = command;
	}

	public Boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
		if (!this.command.getOptions().isEmpty()) {
			throw new InvalidParamsException("Unrecognized parameters. " + COMMAND_HELP);
		}
		if (this.command.getParameters().isEmpty()) {
			throw new InvalidParamsException("Missing parameters. " + COMMAND_HELP);
		}
		if (this.command.getParameters().size() > 1) {
			throw new InvalidParamsException("Too many parameters. " + COMMAND_HELP);
		}

		FileNode currentPath = Explorer.getExplorer().getFileInPath(context.getCurrentDirectory());
		if (currentPath.createNewFile(command.getParameters().get(0))) {
			System.out.println("File created");
		} else {
			throw new InvalidParamsException("File exist");
		}
		return Boolean.TRUE;
	}
}
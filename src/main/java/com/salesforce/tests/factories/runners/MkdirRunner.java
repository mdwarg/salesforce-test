package com.salesforce.tests.factories.runners;

import java.io.File;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.fs.Explorer;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class MkdirRunner implements CommandRunner {
	private Command command;
	private static String COMMAND_HELP = "To use the command wirte: mkdir <directoryName>";

	public MkdirRunner(Command command) {
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

		FileNode currentDirectory = Explorer.getExplorer().getFileInPath(context.getCurrentDirectory());
		if (currentDirectory.createNewDirectory(command.getParameters().get(0))) {
			System.out.println("Directory created");
		} else {
			throw new InvalidParamsException("Directory name already exists. Directory could not be created");
		}
		return Boolean.TRUE;
	}
}
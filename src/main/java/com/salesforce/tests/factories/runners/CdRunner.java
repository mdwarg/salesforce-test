package com.salesforce.tests.factories.runners;

import java.io.File;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.fs.Explorer;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;
import exceptions.InvalidPathException;

public class CdRunner implements CommandRunner {
	private Command command;

	private static String COMMAND_HELP = "To use the command wirte: cd <path>";

	public CdRunner(Command command) {
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
		String targetPath = context.getCurrentDirectory() + "/" + this.command.getParameters().get(0);
		try {
			if (Explorer.getExplorer().getFileInPath(targetPath).isDirectory()) {
				context.goToPath(targetPath);
			}
		} catch (InvalidPathException e) {
			throw new InvalidParamsException("Invalid path. " + COMMAND_HELP);
		}
		return Boolean.TRUE;
	}
}
package com.salesforce.tests.runners;

import java.io.File;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class CdRunner implements CommandRunner {
    private Command command;
    
    private static String COMMAND_HELP = "To use the command wirte: cd <path>";
    
    public CdRunner(Command command) {
        this.command = command;
    }
    
    public boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
    	if(!this.command.getOptions().isEmpty()) {
    		throw new InvalidParamsException("Unrecognized parameters. " + COMMAND_HELP);
    	}
    	if(this.command.getParameters().isEmpty()) {
    		throw new InvalidParamsException("Missing parameters. " + COMMAND_HELP);
    	}
     	if(this.command.getParameters().size() > 1) {
    		throw new InvalidParamsException("Too many parameters. " + COMMAND_HELP);
    	}
     	String newPath = context.getCurrentDirectory() + "/" + this.command.getParameters().get(0);
		File file = new File(newPath);
    	if(file.isDirectory()) {
    		context.goToPath(this.command.getParameters().get(0));
    	} else {
    		throw new InvalidParamsException("Invalid path. " + COMMAND_HELP);
    	}
        return true;
    }    
}
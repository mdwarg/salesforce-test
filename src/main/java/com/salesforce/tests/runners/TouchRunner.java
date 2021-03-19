package com.salesforce.tests.runners;

import java.io.File;
import java.io.IOException;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class TouchRunner implements CommandRunner {
    private Command command;
    private static String COMMAND_HELP = "To use the command wirte: touch <fileName>";
    
    public TouchRunner(Command command) {
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
     	
        File file = new File(context.getCurrentDirectory() + "/" + command.getParameters().get(0));
        if (!file.exists()) {
            try {
            	file.createNewFile();
			    System.out.println("File created");
			} catch (IOException e) {
				throw new InvalidParamsException("File could not be created");
			}
        } else {
        	throw new InvalidParamsException("File exist");
        }
        return true;
    }    
}
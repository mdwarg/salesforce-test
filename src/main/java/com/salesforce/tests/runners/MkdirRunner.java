package com.salesforce.tests.runners;

import java.io.File;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class MkdirRunner implements CommandRunner {
    private Command command;
    private static String COMMAND_HELP = "To use the command wirte: mkdir <directoryName>";
    
    public MkdirRunner(Command command) {
        this.command = command;
    }
    
    public boolean runCommand(Context context)  throws BadOptionException, InvalidParamsException {
    	if(!this.command.getOptions().isEmpty()) {
    		throw new InvalidParamsException("Unrecognized parameters. " + COMMAND_HELP);
    	}
    	if(this.command.getParameters().isEmpty()) {
    		throw new InvalidParamsException("Missing parameters. " + COMMAND_HELP);
    	}
     	if(this.command.getParameters().size() > 1) {
    		throw new InvalidParamsException("Too many parameters. " + COMMAND_HELP);
    	}
     	
        File directory = new File(context.getCurrentDirectory() + "/" + command.getParameters().get(0));
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created");
            } else {
                throw new InvalidParamsException("Directory could not be created");
            }
        } else {
        	throw new InvalidParamsException("Directory exist");
        }
        return true;
    }    
}
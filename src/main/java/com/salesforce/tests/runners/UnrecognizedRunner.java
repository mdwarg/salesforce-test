package com.salesforce.tests.runners;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class UnrecognizedRunner implements CommandRunner {
    private Command command;
    
    public UnrecognizedRunner(Command command) {
        this.command = command;
    }
    
    public boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
        System.out.println("we couldn't recognized the <" + command.getName() + "> command");
        return true;
    }    
}
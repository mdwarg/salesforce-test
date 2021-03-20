package com.salesforce.tests.factories.runners;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class PwdRunner implements CommandRunner {
    private Command command;
    
    public PwdRunner(Command command) {
        this.command = command;
    }
    
    public Boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
        System.out.println(context.getCurrentDirectory());
        return Boolean.TRUE;
    }    
}
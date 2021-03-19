package com.salesforce.tests.runners;

import com.salesforce.tests.factories.*;
import com.salesforce.tests.models.*;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class QuitRunner implements CommandRunner {
   
    public QuitRunner() {}
    
    public boolean runCommand(Context context) throws BadOptionException, InvalidParamsException {
        System.out.println("bye bye...");
        return false;
    }    
}
package com.salesforce.tests.factories;

import com.salesforce.tests.models.Context;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public interface CommandRunner {
    // It return false if the command finish the app
    public Boolean runCommand(Context context) throws BadOptionException, InvalidParamsException;
}
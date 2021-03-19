package com.salesforce.tests.fs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.salesforce.tests.factories.CommandRunner;
import com.salesforce.tests.factories.CommandRunnerFactory;
import com.salesforce.tests.models.Command;
import com.salesforce.tests.models.Context;

import exceptions.BadOptionException;
import exceptions.InvalidParamsException;

public class Terminal {
	
	private Context context;
	private InputStreamReader streamReader;
	private BufferedReader buffer;
	
	public Terminal() {
		super();
	}

	public void run() {
        this.init();
        try {
        	this.processComands();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private void init() {
		this.streamReader = new InputStreamReader(System.in);
        this.buffer = new BufferedReader(streamReader);
        this.context = new Context(System.getProperty("user.dir"));
	}

	private void processComands() throws IOException {
		boolean runApp = true;
		while (runApp) {
			System.out.print(this.context.getCurrentDirectory() + "> ");
		    String commandText = this.buffer.readLine();
		    Command command = this.parseCommand(commandText);
		    CommandRunner runner = CommandRunnerFactory.getRunner(command);
		    try {
		    	runApp = runner.runCommand(this.context);
		    } catch (BadOptionException e) {
		    	System.out.println("Bad option: the command <" + command.getName() + "> doesn't support de option: " + e.getBadOption());
		    } catch (InvalidParamsException e) {
		    	System.out.println("Invalid params: " + e.getMessage());
		    }
		}
	}

	private Command parseCommand(String commandText) {
        String[] parts = commandText.split(" ");
        String name = parts[0];
        List<String> options = new ArrayList<String>();
        List<String> params = new ArrayList<String>();
        for (int i = 1; i < parts.length; i++) {
            if(parts[i].startsWith("-")) {
                options.add(parts[i]);
            } else {
                params.add(parts[i]);
            }            
        }
        return new Command(name, options, params);
    }
}

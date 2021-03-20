package com.salesforce.tests.factories;

import com.salesforce.tests.factories.runners.CdRunner;
import com.salesforce.tests.factories.runners.LsRunner;
import com.salesforce.tests.factories.runners.MkdirRunner;
import com.salesforce.tests.factories.runners.PwdRunner;
import com.salesforce.tests.factories.runners.QuitRunner;
import com.salesforce.tests.factories.runners.TouchRunner;
import com.salesforce.tests.factories.runners.UnrecognizedRunner;
import com.salesforce.tests.models.Command;

public class CommandRunnerFactory {

	public static CommandRunner getRunner(Command command) {
		
		if("quit".equalsIgnoreCase(command.getName())) {
			return new QuitRunner();
		}
		if("pwd".equalsIgnoreCase(command.getName())) {
			return new PwdRunner(command);
		}
		if("ls".equalsIgnoreCase(command.getName())) {
			return new LsRunner(command);
		}
		if("mkdir".equalsIgnoreCase(command.getName())) {
			return new MkdirRunner(command);
		}
		if("cd".equalsIgnoreCase(command.getName())) {
			return new CdRunner(command);
		}
		if("touch".equalsIgnoreCase(command.getName())) {
			return new TouchRunner(command);
		}
		return new UnrecognizedRunner(command);
	}

}
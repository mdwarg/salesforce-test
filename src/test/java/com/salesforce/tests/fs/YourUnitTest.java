package com.salesforce.tests.fs;

import java.io.IOException;

import org.junit.Test;

import com.salesforce.tests.factories.CommandRunnerFactory;
import com.salesforce.tests.models.Command;
import com.salesforce.tests.runners.CdRunner;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest {
    
	@Test
    public void testCdRunner() throws IOException {
		CdRunner cdRunner = CommandRunnerFactory.getRunner(new Command("cd")); 
    }
}

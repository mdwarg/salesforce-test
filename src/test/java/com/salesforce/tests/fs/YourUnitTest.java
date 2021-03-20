package com.salesforce.tests.fs;

import java.io.IOException;

import org.junit.Test;

import com.salesforce.tests.factories.CommandRunner;
import com.salesforce.tests.factories.CommandRunnerFactory;
import com.salesforce.tests.factories.runners.CdRunner;
import com.salesforce.tests.models.Command;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {

	@Test
	public void testPwd() throws IOException {
		String[] expectedResults = { "/root> /root\n", "/root> bye bye...\n" };
		runTest(expectedResults, "pwd", "quit");
	}

	@Test
	public void testMkdir() throws IOException {
		String[] expectedResults = { "/root> Directory created\n", "/root> bye bye...\n" };
		runTest(expectedResults, "mkdir test", "quit");
	}

	@Test
	public void testMkdirWithoutParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Missing parameters. To use the command wirte: mkdir <directoryName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "mkdir", "quit");
	}

	@Test
	public void testMkdirBadParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Unrecognized parameters. To use the command wirte: mkdir <directoryName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "mkdir -f", "quit");
	}

	@Test
	public void testMkdirMultipleBadParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Too many parameters. To use the command wirte: mkdir <directoryName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "mkdir test test2", "quit");
	}

	@Test
	public void testMkdirRepetibleName() throws IOException {
		String[] expectedResults = { "/root> Directory created\n",
				"/root> Invalid params: Directory name already exists. Directory could not be created\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "mkdir test3", "mkdir test3", "quit");
	}

	@Test
	public void testCdBadPath() throws IOException {
		String[] expectedResults = { "/root> Invalid params: Invalid path. To use the command wirte: cd <path>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "cd unexist", "quit");
	}

	@Test
	public void testCdWithoutParams() throws IOException {
		String[] expectedResults = { "/root> Invalid params: Missing parameters. To use the command wirte: cd <path>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "cd", "quit");
	}

	@Test
	public void testTouch() throws IOException {
		String[] expectedResults = { "/root> File created\n", "/root> bye bye...\n" };
		runTest(expectedResults, "touch file.txt", "quit");
	}

	@Test
	public void testTouchDuplicated() throws IOException {
		String[] expectedResults = { "/root> File created\n", "/root> Invalid params: File exist\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "touch file2.txt", "touch file2.txt", "quit");
	}

	@Test
	public void testTouchBadParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Unrecognized parameters. To use the command wirte: touch <fileName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "touch -f", "quit");
	}

	@Test
	public void testTouchTooManyParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Too many parameters. To use the command wirte: touch <fileName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "touch file1 txt", "quit");
	}

	@Test
	public void testTouchWithoutParams() throws IOException {
		String[] expectedResults = {
				"/root> Invalid params: Missing parameters. To use the command wirte: touch <fileName>\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "touch", "quit");
	}

	@Test
	public void testLsBadOption() throws IOException {
		String[] expectedResults = { "/root> Bad option: the command <ls> doesn't support the option: -p\n",
				"/root> bye bye...\n" };
		runTest(expectedResults, "ls -p", "quit");
	}

	@Test
	public void testLs() throws IOException {
		// TODO Couldn't test the ls command because the test not are independent one
		// between others
//        String[] expectedResults = {
//                "/root> File created\n",
//                "/root> /root/file5.txt\n",
//                "/root> bye bye...\n"
//        };
//        runTest(expectedResults, "touch file5.txt", "ls", "quit");
	}

	@Test
	public void testMkdirAndCd() throws IOException {
		String[] expectedResults = { "/root> Directory created\n", "/root> ", "/root/test4> bye bye...\n" };
		runTest(expectedResults, "mkdir test4", "cd test4", "quit");
	}
}

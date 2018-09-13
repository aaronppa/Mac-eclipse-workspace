package org.bitcamp.ex11;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestListener;
import junit.framework.TestResult;

public class Chapter11 extends TestCase {

	public void testChapter11() {
		System.out.println("- TestCase::testChapter11() invoked.");
		
		System.out.println("Hello");
		
//		throw new RuntimeException("testChapter11");
		
		assertTrue(false);
		
	} // testChapter11

	@Override
	public int countTestCases() {
//		System.out.println("- TestCase::countTestCase() invoked.");
		return super.countTestCases();
	}

	@Override
	protected TestResult createResult() {
		System.out.println("- TestCase::createResult() invoked.");
		return super.createResult();
	}

	@Override
	public TestResult run() {
		System.out.println("- TestCase::run() invoked.");
		return super.run();
	}

	@Override
	public void run(TestResult result) {
		System.out.println("- TestCase::run("+result+") invoked.");
		
		result.addListener(new TestListener() {

			@Override
			public void addError(Test test, Throwable t) {
				System.out.println("\t- TestListender::addError("+test+","+t+") invoked.");
				
			}

			@Override
			public void addFailure(Test test, AssertionFailedError t) {
				System.out.println("\t- TestListender::addFailure("+test+","+t+") invoked.");
				
			}

			@Override
			public void endTest(Test test) {
				System.out.println("\t- TestListender::endTest("+test+") invoked.");
				
			}

			@Override
			public void startTest(Test test) {
				System.out.println("\t- TestListender::startTest("+test+") invoked.");
				
			} // startTest
			
		}); //addListener
		
		super.run(result);
	}

	@Override
	public void runBare() throws Throwable {
		System.out.println("- TestCase::runBare() invoked.");
		super.runBare();
	}

	@Override
	protected void runTest() throws Throwable {
		System.out.println("- TestCase::runTest() invoked.");
		super.runTest();
	}

	@Override
	protected void setUp() throws Exception {
		System.out.println("- TestCase::setUp() invoked.");
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		System.out.println("- TestCase::tearDown() invoked.");
		super.tearDown();
	}

	@Override
	public String getName() {
//		System.out.println("- TestCase::getName() invoked.");
		return super.getName();
	}

	@Override
	public void setName(String name) {
		System.out.println("- TestCase::setName("+name+") invoked.");
		super.setName(name);
	}
}

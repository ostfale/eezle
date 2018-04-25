package de.ostfale.testng.regressionsuite;

import de.ostfale.testng.base.BaseTestSuite;
import org.testng.annotations.*;

/**
 * Test class for Test Suites
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_TestClass1 extends BaseTestSuite {

	@BeforeClass
	public void setUp() {
		System.out.println("TestNG_TestClass1 -> This runs once before class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("TestNG_TestClass1 -> This runs once after class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("TestNG_TestClass1 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("TestNG_TestClass1 -> This runs after every method");
	}

	@Test
	public void testMethod1() {
		System.out.println("Running Test -> TestNG_TestClass1 -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("Running Test -> TestNG_TestClass1 -> testMethod2");
	}
}

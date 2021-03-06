package de.ostfale.testng;

import org.testng.annotations.*;

/**
 * Test class 2 for Test suite
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_TestClass2 {

	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs once before class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs once after class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs before every method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs after every method");
	}

	@Test
	public void testMethod1() {
		System.out.println("\nRunning Test -> TestNG_TestClass2 -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("\nRunning Test -> TestNG_TestClass2 -> testMethod2");
	}
}

package de.ostfale.testng.base;

import org.testng.annotations.*;

/**
 * Test base class
 * Created : 25.04.2018
 *
 * @author : usauerbrei
 */
public class BaseTestSuite {

	@BeforeClass
	public void beforeClass() {
		System.out.println("BaseTestSuite -> before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("BaseTestSuite -> after class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BaseTestSuite -> before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("BaseTestSuite -> after test");
	}


	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BaseTestSuite -> before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("BaseTestSuite -> after suite");
	}
}

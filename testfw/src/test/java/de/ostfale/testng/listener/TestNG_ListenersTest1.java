package de.ostfale.testng.listener;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Example test class where the methods are intercepted by a listener independently of the type of test or pre or
 * post condition.
 * Created : 30.04.2018
 *
 * @author : usauerbrei
 */
//@Listeners(CustomListener1.class)
public class TestNG_ListenersTest1 {

	@BeforeClass
	public void setUp() {
		System.out.println("TestNG_ListenersTest1 -> Code in before class");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("TestNG_ListenersTest1 -> Code in after class");
	}

	@Test
	public void testMethod1() {
		System.out.println("TestNG_ListenersTest1 -> Code in testMethod1");
		Assert.assertTrue(true);
	}

	@Test
	public void testMethod2() {
		System.out.println("TestNG_ListenersTest1 -> Code in testMethod2");
		Assert.assertTrue(false);
	}
}

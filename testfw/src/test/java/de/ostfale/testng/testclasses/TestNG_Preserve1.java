package de.ostfale.testng.testclasses;

import org.testng.annotations.Test;

/**
 * Execution order
 * Created : 26.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_Preserve1 {

	@Test
	public void testMethod1() {
		System.out.println("TestNG_Preserve1 -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("TestNG_Preserve1 -> testMethod2");
	}
}

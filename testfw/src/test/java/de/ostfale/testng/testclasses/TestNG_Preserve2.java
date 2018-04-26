package de.ostfale.testng.testclasses;

import org.testng.annotations.Test;

/**
 * Execution order test class
 * Created : 26.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_Preserve2 {

	@Test
	public void testMethod1() {
		System.out.println("TestNG_Preserve2 -> testMethod1");
	}

	@Test
	public void testMethod2() {
		System.out.println("TestNG_Preserve2 -> testMethod2");
	}
}

package de.ostfale.testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Some basic TestNG tests
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class SomeClassToTestTest {

	@Test
	public void testSum() {
		System.out.println("\nRunning Test -> testSum");
		SomeClassToTest obj = new SomeClassToTest();
		int result = obj.sumNumbers(1, 2);
		assertEquals(result, 3);
	}

	@Test
	public void testStrings() {
		System.out.println("\nRunning Test -> testStrings");
		String expectedString = "Hello World";
		SomeClassToTest obj = new SomeClassToTest();
		String result = obj.addStrings("Hello", "World");
		assertEquals(result, expectedString);
	}

	@Test
	public void testArrays() {
		System.out.println("\nRunning Test -> testArrays");
		int[] expectedArray = {1, 2, 3, 4};
		SomeClassToTest obj = new SomeClassToTest();
		int[] result = obj.getArray();
		assertEquals(result, expectedArray);
		System.out.println("\nEnd Test -> testArrays");
	}
}
package de.ostfale.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Show soft asserts  which doesn't stop at a failing test.
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_SoftAsserts {

	@Test
	public void testSum() {
		SoftAssert softAssert = new SoftAssert();

		System.out.println("\nRunning -> testSum");
		SomeClassToTest toTest = new SomeClassToTest();
		int result = toTest.sumNumbers(1, 2);
		softAssert.assertEquals(result, 2);
		softAssert.assertEquals(result, 3);
		// without assertAll all tests will pass
		softAssert.assertAll();
	}
}

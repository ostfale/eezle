package de.ostfale.testng;

/**
 * Test pojo for test
 * Created : 24.04.2018
 *
 * @author : usauerbrei
 */
public class SomeClassToTest {

	public int sumNumbers(int a, int b) {
		return a + b;
	}

	public String addStrings(String a, String b) {
		return a + " " + b;
	}

	public int[] getArray() {
		int[] arrayExample = {1, 2, 3,4};
		return arrayExample;
	}
}

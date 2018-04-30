package de.ostfale.testng.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Example for a data provider class
 * Created : 30.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_DataProvider {

	@Test(dataProvider = "inputs", dataProviderClass = TestData.class)
	public void testMethod1(String input1, String input2) {
		System.out.println("Input 1: " + input1);
		System.out.println("Input 2: " + input2);
	}
}

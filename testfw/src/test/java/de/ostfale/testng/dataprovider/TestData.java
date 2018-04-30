package de.ostfale.testng.dataprovider;

import org.testng.annotations.DataProvider;

/**
 * Data provider class
 * Created : 30.04.2018
 *
 * @author : usauerbrei
 */
public class TestData {

	@DataProvider(name = "inputs")
	public Object[][] getData() {
		return new Object[][]{
				{"bmw", "m3"},
				{"audi", "a6"},
				{"benz", "c300"}
		};
	}
}

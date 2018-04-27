package de.ostfale.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Example for using test parameters. Can only run started from xml file (where parameters are defined)
 * Created : 27.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_Parameters {

	@BeforeClass
	@Parameters({"browser", "platform"})
	public void setUp(String browser, String platform) {
		System.out.println("TestNG_Parameters -> Setup");
		System.out.println("1. Parameter value from xml file: " + browser);
		System.out.println("2. Parameter value from xml file: " + platform);
	}

	@Test
	@Parameters({"response"})
	public void testMethod1(String response) throws InterruptedException {
		String[] stringArray = response.split(",");
		System.out.println("TestNG_Parameters -> testMethod1");
		System.out.println("Response from xml file: " + response);
		System.out.println("stringArray[0] from xml file: " + stringArray[0]);
		System.out.println("stringArray[1] from xml file: " + stringArray[1]);
	}
}

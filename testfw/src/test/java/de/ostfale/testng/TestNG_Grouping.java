	package de.ostfale.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Grouping tests. Always run in BeforeClass and AfterClass executes methods even if they does not belong to a group
 * Created : 25.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_Grouping {

	@BeforeClass(alwaysRun=true)
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@Test(groups = {"cars", "suv"})
	public void testBMWX6() {
		System.out.println("Running Test - BMW X6");
	}

	@Test(groups = {"cars", "sedan"})
	public void testAudiA6() {
		System.out.println("Running Test - Audi A6 ");
	}

	@Test(groups = { "bikes" })
	public void testNinja() {
		System.out.println("Running Test - Kawasaki Ninja");
	}

	@Test(groups = { "bikes" })
	public void testHondaCBR() {
		System.out.println("Running Test - Honda CBR");
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		System.out.println("After Class");
	}

}

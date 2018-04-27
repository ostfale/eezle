package de.ostfale.testng;

import org.testng.annotations.Test;

/**
 * Second test class for parallel execution
 * Created : 27.04.2018
 *
 * @author : usauerbrei
 */
public class TestNG_TestParallel2 {

	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("TestNG_Parallel2 -> testMethod1");
		Thread.sleep(2000);
		System.out.println("TestNG_Parallel2 -> testMethod1 -> More Steps");
	}

	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG_Parallel2 -> testMethod2");
		Thread.sleep(2000);
		System.out.println("TestNG_Parallel2 -> testMethod2 -> More Steps");
	}
}

package de.ostfale.testng.listener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Test suite listener
 * Created : 02.05.2018
 *
 * @author : usauerbrei
 */
public class CustomListener3 implements ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		// When <suite> tag starts
		System.out.println("onStart: before suite starts");
	}

	@Override
	public void onFinish(ISuite suite) {
		// When <suite> tag completes
		System.out.println("onFinish: after suite completes");
	}
}

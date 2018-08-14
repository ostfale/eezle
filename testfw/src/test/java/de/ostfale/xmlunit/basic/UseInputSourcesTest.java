package de.ostfale.xmlunit.basic;

import org.junit.Test;
import org.xmlunit.builder.Input;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

/**
 * With XMLUnit, we can pick XML data from a variety of sources that may be convenient for our application’s needs.
 * In this case, we use the Input class with its array of static methods.
 * Created : 14.08.2018
 *
 * @author : usauerbrei
 */
public class UseInputSourcesTest {

	/**
	 * To pick input from an XML file located in the project root, we do the following
	 */
	@Test
	public void givenFileSource_whenAbleToInput_thenCorrect() {
		ClassLoader classLoader = getClass().getClassLoader();
		String testPath = classLoader.getResource("xmlunit/test.xml").getPath();
		String controlPath = classLoader.getResource("xmlunit/control.xml").getPath();

		assertThat(Input.fromFile(testPath), isSimilarTo(Input.fromFile(controlPath)));
	}

	/**
	 * To pick an input source from an XML string, like so
	 */
	@Test
	public void givenStringSource_whenAbleToInput_thenCorrect() {
		String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
		String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";

		assertThat(Input.fromString(testXml), isSimilarTo(Input.fromString(controlXml)));
	}

	/**
	 * Let’s now use a stream as the input
	 */
	@Test
	public void givenStreamAsSource_whenAbleToInput_thenCorrect() {
		assertThat(Input.fromStream(UseInputSourcesTest.class
						.getResourceAsStream("/xmlunit/test.xml")),
				isSimilarTo(
						Input.fromStream(UseInputSourcesTest.class
								.getResourceAsStream("/xmlunit/control.xml"))));
	}

	/**
	 * We could also use Input.from(Object) where we pass in any valid source to be resolved by XMLUnit.
	 * For example, we can pass a file in
	 */
	@Test
	public void givenFileSourceAsObject_whenAbleToInput_thenCorrect() {
		ClassLoader classLoader = getClass().getClassLoader();

		assertThat(
				Input.from(new File(classLoader.getResource("xmlunit/test.xml").getFile())),
				isSimilarTo(Input.from(new File(classLoader.getResource("xmlunit/control.xml").getFile()))));
	}

	@Test
	public void givenStringSourceAsObject_whenAbleToInput_thenCorrect() {
		assertThat(
				Input.from("<struct><int>3</int><boolean>false</boolean></struct>"),
				isSimilarTo(Input.from("<struct><int>3</int><boolean>false</boolean></struct>")));
	}

	@Test
	public void givenStreamAsObject_whenAbleToInput_thenCorrect() {
		assertThat(
				Input.from(UseInputSourcesTest.class.getResourceAsStream("/xmlunit/test.xml")),
				isSimilarTo(Input.from(UseInputSourcesTest.class.getResourceAsStream("/xmlunit/control.xml"))));
	}
}

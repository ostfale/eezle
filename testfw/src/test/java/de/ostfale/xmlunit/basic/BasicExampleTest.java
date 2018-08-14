package de.ostfale.xmlunit.basic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.xmlunit.matchers.CompareMatcher.isIdenticalTo;

/**
 * Some basic xmlunit tests
 * Created : 14.08.2018
 *
 * @author : usauerbrei
 */
public class BasicExampleTest {

	@Test
	public void given2XMLS_whenIdentical_thenCorrect() {
		String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
		String testXml = "<struct><int>3</int><boolean>false</boolean></struct>";
		assertThat(testXml, isIdenticalTo(controlXml));
	}

	@Test
	public void given2XMLSWithSimilarNodesButDifferentSequence_whenNotIdentical_thenCorrect() {
		String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
		String testXml = "<struct><boolean>false</boolean><int>3</int></struct>";
		assertThat(testXml, not(isIdenticalTo(controlXml)));

	}
}
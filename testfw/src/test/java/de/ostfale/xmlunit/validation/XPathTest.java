package de.ostfale.xmlunit.validation;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xmlunit.builder.Input;
import org.xmlunit.xpath.JAXPXPathEngine;

import java.io.File;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;
import static org.xmlunit.matchers.HasXPathMatcher.hasXPath;

/**
 * When an XPath expression is evaluated against a piece of XML a NodeList is created that contains the matching Nodes.
 * Created : 16.08.2018
 *
 * @author : usauerbrei
 */
public class XPathTest {

	private final static String SRC_PATH = "xmlunit/teachers.xml";
	private File sourceFile;

	@Before
	public void setUp() {
		ClassLoader classLoader = getClass().getClassLoader();
		sourceFile = new File(classLoader.getResource(SRC_PATH).getFile());
	}

	/**
	 * We can retrieve all the nodes called teacher and perform assertions on them individually
	 */
	@Test
	public void givenXPath_whenAbleToRetrieveNodes_thenCorrect() {

		Iterable<Node> i = new JAXPXPathEngine().selectNodes("//teacher", Input.fromFile(sourceFile).build());
		assertNotNull(i);
		int count = 0;
		for (Iterator<Node> it = i.iterator(); it.hasNext(); ) {
			count++;
			Node node = it.next();
			assertEquals("teacher", node.getNodeName());

			NamedNodeMap map = node.getAttributes();
			assertEquals("department", map.item(0).getNodeName());
			assertEquals("id", map.item(1).getNodeName());
			assertEquals("teacher", node.getNodeName());
		}
		assertEquals(2, count);
	}

	/**
	 * To verify that a path exists, we can do the following
	 */
	@Test
	public void givenXmlSource_whenAbleToValidateExistingXPath_thenCorrect() {
		assertThat(Input.fromFile(sourceFile), hasXPath("//teachers"));
		assertThat(Input.fromFile(sourceFile), hasXPath("//teacher"));
		assertThat(Input.fromFile(sourceFile), hasXPath("//subject"));
		assertThat(Input.fromFile(sourceFile), hasXPath("//@department"));
	}

	/**
	 * To verify that a path does not exist, this is what we can do
	 */
	@Test
	public void givenXmlSource_whenFailsToValidateInExistentXPath_thenCorrect() {
		assertThat(Input.fromFile(sourceFile), not(hasXPath("//sujet")));
	}
}

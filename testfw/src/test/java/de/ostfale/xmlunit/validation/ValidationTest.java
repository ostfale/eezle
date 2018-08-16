package de.ostfale.xmlunit.validation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlunit.builder.Input;
import org.xmlunit.validation.Languages;
import org.xmlunit.validation.ValidationProblem;
import org.xmlunit.validation.ValidationResult;
import org.xmlunit.validation.Validator;

import java.util.Iterator;

import static org.junit.Assert.assertTrue;

/**
 * XMLUnit performs XML validation using the Validator class. You create an instance of it using the forLanguage
 * factory method while passing in the schema to use in validation.
 * The schema is passed in as a URI leading to its location, XMLUnit abstracts the schema locations
 * it supports in the Languages class as constants.
 * We typically create an instance of Validator class like so: <p/>
 * <code>Validator v = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);</code>
 * <<p/>
 * After this step, if we have our own XSD file to validate against our XML, we simply specify its source and then call
 * Validator‘s validateInstance method with our XML file source.<p/>
 * Created : 15.08.2018
 *
 * @author : usauerbrei
 */
public class ValidationTest {

	private static final Logger logger = LoggerFactory.getLogger(ValidationTest.class);

	private static final String XSD = "/xmlunit/students.xsd";
	private static final String XML = "/xmlunit/students.xml";
	private static final String XML_ERROR = "/xmlunit/students_with_error.xml";

	/**
	 * The result of the validation is an instance of ValidationResult which contains a boolean flag indicating
	 * whether the document has been validated successfully.
	 */
	@Test
	public void givenXml_whenValidatesAgainstXsd_thenCorrect() {
		Validator v = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);
		v.setSchemaSource(Input.fromStream(ValidationTest.class.getResourceAsStream(XSD)).build());
		ValidationResult r = v.validateInstance(Input.fromStream(ValidationTest.class.getResourceAsStream(XML)).build());
		Iterator<ValidationProblem> probs = r.getProblems().iterator();
		while (probs.hasNext()) {
			probs.next().toString();
		}
		assertTrue(r.isValid());
	}

	/**
	 * The ValidationResult also contains an Iterable with ValidationProblems in case there is a failure.
	 */
	@Test
	public void givenXmlWithErrors_whenReturnsValidationProblems_thenCorrect() {
		Validator v = Validator.forLanguage(Languages.W3C_XML_SCHEMA_NS_URI);
		v.setSchemaSource(Input.fromStream(ValidationTest.class.getResourceAsStream(XSD)).build());
		ValidationResult r = v.validateInstance(Input.fromStream(ValidationTest.class.getResourceAsStream(XML_ERROR)).build());
		Iterator<ValidationProblem> probs = r.getProblems().iterator();
		int count = 0;
		while (probs.hasNext()) {
			count++;
			logger.info(probs.next().toString());
		}
		assertTrue(count > 0);
	}
}

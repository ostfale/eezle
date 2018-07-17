package de.ostfale.jaxb;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Unmarshalling XML with JAXB to a Java object involves creating an Unmarshaller on the JAXBContext
 * and calling the unmarshal() method. This method accepts the XML file to unmarshall.
 * Created : 17.07.2018
 *
 * @author : usauerbrei
 */
public class XmlToProductTest {

	private Product product;

	@Test
	public void testXmlToObject() throws JAXBException {
		File file = new File("product.xml");
		JAXBContext jaxbContext = JAXBContext.newInstance(Product.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		product = (Product) unmarshaller.unmarshal(file);
		System.out.println(product);
	}
}

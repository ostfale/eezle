package de.ostfale.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * Pojo with Jaxb annotations
 * Created : 17.07.2018
 *
 * @author : usauerbrei
 */
/*
 *This annotation is used at the top level class to indicate the root element in the XML document.
 * The name attribute in the annotation is optional. If not specified, the class name is used as
 * the root XML element in the document.
 */
@XmlRootElement(name = "product")
public class Product {

	//  This annotation is used to indicate the attribute of the root element
	@XmlAttribute(name = "id")
	private String productId;

	// This annotation is used on the properties of the class which will be the sub-elements of the root element.
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "imageUrl")
	private String imageUrl;
	@XmlElement(name = "price")
	private BigDecimal price;
	@XmlElement(name = "createdBy")
	private User createdBy;

	public Product() {
	}

	public Product(String productId, String description, String imageUrl, BigDecimal price, User createdBy) {
		this.productId = productId;
		this.description = description;
		this.imageUrl = imageUrl;
		this.price = price;
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "Product{" +
				"\n productId='" + productId + '\'' +
				",\n description='" + description + '\'' +
				",\n imageUrl='" + imageUrl + '\'' +
				",\n price=" + price +
				",\n createdBy=" + createdBy + "\n" +
				'}';
	}
}

package de.ostfale.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Often you will need to marshall Java collection objects, such as List, Set, and Map to XML,
 * and also unmarshall XML back to collection objects.
 * Consider our current application where we now need to work with a list of products.
 * To model the new requirement, let us create a Products class.
 * <p>
 * Created : 17.07.2018
 *
 * @author : usauerbrei
 */
@XmlRootElement(name = "products")
public class Products {
	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	@XmlElement(name = "product")
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void add(Product product) {
		if (this.products == null) {
			this.products = new ArrayList<>();
		}
		this.products.add(product);
	}
}

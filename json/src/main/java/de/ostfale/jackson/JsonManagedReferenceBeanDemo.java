package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * The @JsonManagedReference and @JsonBackReference annotation are used to create JSON
 * structures that have a bidirectional relationship.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonManagedReferenceBeanDemo {

	public long personId = 0;
	public String name = "James Clark";
	@JsonManagedReference
	public JsonBackReferenceDemoBean manager;

	public JsonManagedReferenceBeanDemo(long personId, String name, JsonBackReferenceDemoBean manager) {
		this.personId = personId;
		this.name = name;
		this.manager = manager;
	}
}

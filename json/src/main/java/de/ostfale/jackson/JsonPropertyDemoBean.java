package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The @JsonProperty annotation is used to map property names with JSON keys during serialization and deserialization.
 * By default, if you try to serialize a POJO, the generated JSON will have keys mapped to the fields of the POJO.
 * If you want to override this behavior, you can use the @JsonProperty annotation on the fields.
 * It takes a String attribute that specifies the name that should be mapped to the field during serialization.
 * You can also use this annotation during deserialization when the property names of the JSON and the field names of the Java object do not match.
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonPropertyDemoBean {

	@JsonProperty("person-id")
	public long personId = 123L;
	@JsonProperty("name")
	public String name = "James Clark";

	@Override
	public String toString() {
		return "PropertyDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * The @JsonPropertyOrder annotation tells Jackson to serialize the Java object to JSON, i
 * n the order specified as the arguments of the annotation. This annotation also allows partial ordering.
 * The properties are first serialized in the order in which they are found, followed by any other
 * properties not included in the annotation.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
@JsonPropertyOrder({"name", "personId"})
public class JsonPropertyOrderDemoBean {
	public long personId = 123L;
	public String name = "James Clark";
}

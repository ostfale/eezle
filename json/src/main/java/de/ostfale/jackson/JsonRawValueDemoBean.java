package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonRawValue;

/**
 * The @JsonRawValue annotation is used on methods and fields. It tells Jackson to serialize the field or property as declared.
 * For example, if you have a String field in your Java class, the JSON value that Jackson generates is enclosed within quotes (” “).
 * But when you annotate the field with @JsonRawValue, Jackson omits the quotes.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonRawValueDemoBean {

	public long personId = 0;
	public String name = "James Clark";
	@JsonRawValue
	public String address = "{\"doorNumber\": 1234, \"street\": \"phase-1\", " + "\"city\": \"New York\"}";
}

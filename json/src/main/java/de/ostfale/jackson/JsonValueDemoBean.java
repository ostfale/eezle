package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The @JsonValue annotation is used at the method level. This annotation tells Jackson to use this method
 * to generate the JSON string from the Java object. Typically, if you want to print a serialized object,
 * you override the toString() method. But, by using the @JsonValue annotation, you can define the way
 * in which the Java object is to be serialized. <p>
 * In order to explain the difference between the serialized object
 * with and without the @JsonValue annotation, the code includes the toString() method. You can also run the
 * code without overriding the toString() method.</p>
 * <p>
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonValueDemoBean {

	@JsonProperty
	private long personId = 123L;
	@JsonProperty
	private String name = "James Clark";

	@JsonValue
	public String toJson() {
		return this.name + "," + this.personId + "," + this.toString();
	}

	@Override
	public String toString() {
		return "JsonValueDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

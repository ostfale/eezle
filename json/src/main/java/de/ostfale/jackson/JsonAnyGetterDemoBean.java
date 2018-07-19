package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

/**
 * The @JsonAnyGetter annotation can be used when you don’t want to declare a property
 * or a method for every possible key in JSON. This annotation is used on the getter
 * methods which enables you to use a Map to hold all your properties that you want to serialize.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonAnyGetterDemoBean {

	public long personId = 123L;
	public String personName = "James Clark";
	private Map<String, String> properties = new HashMap<>();

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}
}


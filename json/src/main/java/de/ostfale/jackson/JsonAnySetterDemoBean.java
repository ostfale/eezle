package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * The @JsonAnySetter annotation is used on setter methods of a Map field.
 * Sometimes you may find some JSON values that cannot be mapped to the fields in the Java object class.
 * In such a case, the @JsonAnySetter captures the data and stores them in a Map.
 * Created : 20.07.2018
 *
 * @author : usauerbrei
 */
public class JsonAnySetterDemoBean {

	public long personId = 123L;
	public String personName = "James Clark";
	private Map<String, String> properties = new HashMap<>();

	@JsonAnySetter
	public void setProperties(String key, String value) {
		properties.put(key, value);
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	@Override
	public String toString() {
		return "AnySetterDemoBean{" +
				"personId=" + personId +
				", personName='" + personName + '\'' +
				", properties=" + properties +
				'}';
	}
}

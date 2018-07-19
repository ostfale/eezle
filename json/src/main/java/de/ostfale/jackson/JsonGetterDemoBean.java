package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonGetter;

/**
 * The @JsonGetter annotation is used to customize the generated JSON keys.
 * This is accomplished with the value argument of @JsonGetter. The value passed
 * is the name that should be used as the JSON key.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonGetterDemoBean {

	public long personId = 123L;
	public String personName = "James Clark";

	@JsonGetter(value = "person-id")
	public long getPersonId() {
		return personId;
	}

	@JsonGetter(value = "person-name")
	public String getPersonName() {
		return personName;
	}
}

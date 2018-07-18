package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * The @JsonInclude annotation is used to exclude properties or fields of a class under certain conditions.
 * This is defined using the JsonInclude.Include enum. This enum contains constants,
 * that determine whether or not to exclude the property.
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonIncludeDemoBean {

	public long personId = 123L;
	public String name = null;

	@Override
	public String toString() {
		return "JsonIncludeDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

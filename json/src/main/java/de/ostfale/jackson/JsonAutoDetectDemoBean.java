package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * The @JsonAutoDetect annotation is used at the class level to tell Jackson to override
 * the visibility of the properties of a class during serialization and deserialization.
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonAutoDetectDemoBean {
	private long personId = 123L;
	private String name = "James Clark";

	public long getPersonId() {
		return personId;
	}

	public void setPersonId(long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "JsonIgnoreDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

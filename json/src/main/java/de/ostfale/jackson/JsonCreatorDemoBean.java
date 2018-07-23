package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The @JsonCreator annotation tells Jackson that the JSON properties can be mapped to the fields of a constructor of the POJO.
 * This is helpful when the JSON properties do not match with the names of the Java object field names.
 * The @JsonCreator annotation can be used where @JsonSetter cannot be used. For example, immutable objects which
 * need their initial values to be injected through constructors.
 * Created : 20.07.2018
 *
 * @author : usauerbrei
 */
public class JsonCreatorDemoBean {

	public long personId = 0;
	public String name = "James Clark";

	@JsonCreator
	public JsonCreatorDemoBean(@JsonProperty("id") long personId, @JsonProperty("name") String name) {
		this.personId = personId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreatorDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

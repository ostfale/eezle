package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * The @JsonView annotation is used to include or exclude a property dynamically during serialization and deserialization.
 * It tells the view in which the properties are rendered. Let us consider an example Java class that uses the @JsonView
 * annotation with Public and Internal views.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonViewDemoBean {

	@JsonView(Views.Public.class)
	@JsonProperty
	public long personId = 0;

	@JsonView(Views.Public.class)
	@JsonProperty
	public String name = "James Clark";

	@JsonView(Views.Internal.class)
	@JsonProperty
	public String gender = "male";

	@Override
	public String toString() {
		return "ViewDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				", gender='" + gender + '\'' +
				'}';
	}
}

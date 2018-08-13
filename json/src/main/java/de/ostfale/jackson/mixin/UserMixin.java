package de.ostfale.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * UserMixin is an abstract class where the constructor of the class is annotated with @JsonCreator to tell
 * Jackson in what order to pass fields from a JSON object to the constructor.
 * Each argument of the constructor is annotated with @JsonProperty to indicate the name of the property to bind to.
 * Created : 13.08.2018
 *
 * @author : usauerbrei
 */
public abstract class UserMixin {

	@JsonCreator
	public UserMixin(@JsonProperty Long id, @JsonProperty String name,
	                 @JsonProperty int age, @JsonProperty String gender,
	                 @JsonProperty String email, @JsonProperty String phoneNo) {

	}
}

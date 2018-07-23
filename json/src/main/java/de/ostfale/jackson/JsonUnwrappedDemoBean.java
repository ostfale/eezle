package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * The @JsonUnwrapped annotation unwraps the values during serialization and deserialization.
 * It helps in rendering the values of a composed class as if they belonged to the parent class.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonUnwrappedDemoBean {

	public static class Address {
		public String doorNumber = "12";
		public String streetName = "phase-1";
		public String pinCode = "123456";
		public String city = "New York";

		@Override
		public String toString() {
			return "Address{" +
					"doorNumber='" + doorNumber + '\'' +
					", streetName='" + streetName + '\'' +
					", pinCode='" + pinCode + '\'' +
					", city='" + city + '\'' +
					'}';
		}
	}

	public long personId = 0;
	public String name = "James Clark";
	@JsonUnwrapped
	public Address address = new Address();
}

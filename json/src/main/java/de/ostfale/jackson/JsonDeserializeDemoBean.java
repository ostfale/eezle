package de.ostfale.jackson;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * The @JsonDeserialize annotation tells Jackson to use a custom deserializer while deserializing the JSON to Java object.
 * To do so, you need to annotate the field to which you need to apply the custom deserializer.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonDeserializeDemoBean {

	public long personId = 123L;
	public String name = "James Clark";

	@JsonDeserialize(using = CustomDateDeserializer.class)
	public Date activeDate;

	@Override
	public String toString() {
		return "DeserializeDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				", activeDate=" + activeDate +
				'}';
	}
}

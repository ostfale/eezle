package de.ostfale.jackson;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

/**
 * The @JsonSerialize annotation is used tell Jackson to use the declared custom serializer during the serialization of the field,
 * which is marked with this annotation. Let us consider a POJO that uses the @JsonSerialize annotation.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonSerializeDemoBean {

	public long personId = 123L;
	public String name = "James Clark";
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date activeDate;

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}

package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * The @JsonFormat annotation is used to tell Jackson that the format in which the value for a field is serialized.
 * It specifies the format using the JsonFormat.Shape enum
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonFormatDemoBean {

	@JsonProperty("person-id")
	public long personId = 123L;
	@JsonProperty("name")
	public String name = "James Clark";
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	@JsonProperty("active-date")
	public Date activeDate;

	public JsonFormatDemoBean() {
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}
}

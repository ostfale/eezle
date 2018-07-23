package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 * The @JsonFilter annotation is used to tell Jackson to use a custom defined filter to serialize the Java object.
 * To define your filter, you need to use the FilterProvider class. This provider gets the actual filter instance to use.
 * The filter is then configured by assigning the FilterProvider to ObjectMapper.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
@JsonFilter("customFilter")
public class JsonFilterDemoBean {

	public long personId = 123L;
	public String  name = "James Clark";
	public String gender = "male";
}

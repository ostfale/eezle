package de.ostfale.jackson;

import com.fasterxml.jackson.annotation.JacksonInject;

/**
 * The @JacksonInject annotation is used to tell Jackson that particular values of the deserialized
 * object will be injected and not read from the JSON string.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JacksonInjectDemoBean {

	@JacksonInject
	public long personId = 0;
	public String name = "James Clark";

	@Override
	public String toString() {
		return "JacksonInjectDemoBean{" +
				"personId=" + personId +
				", name='" + name + '\'' +
				'}';
	}
}

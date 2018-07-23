package de.ostfale.jackson;

import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * The test code to test the @JacksonInject annotation.In order to inject values into a field, you can use the
 * InjectableValues class. You need to configure ObjectMapper to read both, the injected values from
 * injectableValues and the remaining values from the JSON string.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JacksonInjectDemoBeanTest {

	@Test
	public void testDeSerializingWithJacksonInject() throws IOException {
		String jsonString = "{\"name\": \"Mary Parker\"}";
		InjectableValues injectableValues = new InjectableValues.Std().addValue(long.class, 231L);
		JacksonInjectDemoBean bean = new ObjectMapper().reader(injectableValues).forType(JacksonInjectDemoBean.class).readValue(jsonString);
		System.out.println(bean);
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.personId, is(equalTo(231L)));
	}
}
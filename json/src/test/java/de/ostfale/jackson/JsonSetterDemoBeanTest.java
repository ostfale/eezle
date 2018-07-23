package de.ostfale.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test code to test the @JsonSetter annotation
 * Created : 20.07.2018
 *
 * @author : usauerbrei
 */
public class JsonSetterDemoBeanTest {

	private ObjectMapper objectMapper;

	@Before
	public void setUp() {
		objectMapper = new ObjectMapper();
	}

	@After
	public void tearDown() {
		objectMapper = null;
	}

	@Test
	public void testDeSerializingWithJsonSetter() throws IOException {
		String jsonString = "{\"id\": 231, \"name\": \"Mary Parker\"}";
		JsonSetterDemoBean bean = objectMapper.readValue(jsonString, JsonSetterDemoBean.class);
		System.out.println(bean);
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.personId, is(equalTo(231L)));
	}
}
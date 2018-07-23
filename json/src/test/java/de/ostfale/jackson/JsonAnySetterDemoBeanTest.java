package de.ostfale.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * The test code to test the @JsonAnySetter annotation
 * Created : 20.07.2018
 *
 * @author : usauerbrei
 */
public class JsonAnySetterDemoBeanTest {

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
		String jsonString = "{\"personId\": 231, \"personName\": \"Mary Parker\", \"emailId\": \"mary@gmail.com\", \"gender\": \"female\"}";
		JsonAnySetterDemoBean bean = objectMapper.readValue(jsonString, JsonAnySetterDemoBean.class);
		System.out.println(bean);
		assertThat(bean.personName, is(equalTo("Mary Parker")));
		assertThat(bean.personId, is(equalTo(231L)));
		assertEquals("female", bean.getProperties().get("gender"));
	}
}
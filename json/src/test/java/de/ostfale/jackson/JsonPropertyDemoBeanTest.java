package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test code to test the @JsonProperty annotation
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonPropertyDemoBeanTest {

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
	public void testSerializingWithJsonProperty() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonPropertyDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("123"));
	}

	@Test
	public void testDeSerializingWithJsonProperty() throws IOException {
		String jsonString = "{\"person-id\": 231, \"name\": \"Mary Parker\"}";
		JsonPropertyDemoBean bean = objectMapper.readValue(jsonString, JsonPropertyDemoBean.class);
		System.out.println(bean);
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.personId, is(equalTo(231L)));
	}

}
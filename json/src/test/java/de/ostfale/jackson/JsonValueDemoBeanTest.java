package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Test @JsonValue. As shown in the preceding figure, the Java object is serialized by Jackson
 * by calling the defined method toJson(). The quotation marks are added by Jackson.
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonValueDemoBeanTest {

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
	public void testSerializingWithJsonValue() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonValueDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("James Clark,123"));
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Here, the address field is a JSON string. This JSON string will be serialized as a
 * part of the final JSON string of the RawValueDemoBean object.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonRawValueDemoBeanTest {

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
	public void testSerializingWithJsonRawValue() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonRawValueDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("{\"doorNumber\": 1234, " +
				"\"street\": \"phase-1\", \"city\": \"New York\"}"));
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * As you can see the result, the name property is first serialized before the personId.
 * Without the @JsonPropertyOrder annotation, the object would have been serialized in the order found in the class
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonPropertyOrderDemoBeanTest {

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
	public void testSerializingWithJsonPropertyOrder() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonPropertyOrderDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("123"));
		assertThat(jsonString, containsString("James Clark"));
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Test JsonAutoDetect
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonAutoDetectDemoBeanTest {

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
	public void testSerializingWithJsonAutoDetect() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonAutoDetectDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("123"));
		assertThat(jsonString, containsString("James Clark"));
	}
}
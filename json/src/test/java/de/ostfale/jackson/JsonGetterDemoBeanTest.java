package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test code to test the @JsonGetter annotation
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonGetterDemoBeanTest {

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
	public void testSerializingWithJsonGetter() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonGetterDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("person-id"));
		assertThat(jsonString, containsString("person-name"));
	}

}
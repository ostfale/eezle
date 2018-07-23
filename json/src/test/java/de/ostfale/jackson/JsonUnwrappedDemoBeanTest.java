package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * The test code to test the @JsonUnwrapped annotation
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonUnwrappedDemoBeanTest {

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
	public void testSerializingWithJsonUnwrapped() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonUnwrappedDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("address")));
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

/**
 * As shown in the preceding figure, the JSON string does not contain the property name as it is initialized to null.
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonIncludeDemoBeanTest {

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
	public void testSerializingWithJsonInclude() throws JsonProcessingException {
		String jsonString = objectMapper.writeValueAsString(new JsonIncludeDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("123"));
		assertThat(jsonString, not(containsString("name")));
	}
}
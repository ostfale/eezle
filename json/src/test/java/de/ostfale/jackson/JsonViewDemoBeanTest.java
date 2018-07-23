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
 * The test code to test the @JsonView annotation. As you can see in the test code, you need to configure
 * the ObjectMapper to include which type of view must be used for writing the JSON from the Java object
 * using the writerWithView() method.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonViewDemoBeanTest {

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
	public void testSerializingWithJsonView() throws JsonProcessingException {
		String jsonString = objectMapper.writerWithView(Views.Public.class).writeValueAsString(new JsonViewDemoBean());
		String jsonStringInternal = objectMapper.writerWithView(Views.Internal.class).writeValueAsString(new JsonViewDemoBean());
		System.out.println(jsonString);
		System.out.println(jsonStringInternal);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("gender")));
		assertThat(jsonStringInternal, containsString("gender"));
	}
}
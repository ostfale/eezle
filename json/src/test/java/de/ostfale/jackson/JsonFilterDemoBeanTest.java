package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * The test code to test the @JsonFilter annotation. As you can see, the custom filter declared as the arguments
 * of the @JsonFilter annotation extract only the name and filters out the other properties of the bean during serialization.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonFilterDemoBeanTest {

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
	public void testSerializingWithJsonFilter() throws JsonProcessingException {
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("customFilter", SimpleBeanPropertyFilter.filterOutAllExcept("name"));
		String jsonString = objectMapper.writer(filterProvider).
				writeValueAsString(new JsonFilterDemoBean());
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, not(containsString("123")));
	}
}
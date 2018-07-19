package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test code to test the @JsonAnyGetter annotation
 * As you can see, all the properties are serialized as the properties of JsonAnyGetterDemoBean object
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonAnyGetterDemoBeanTest {

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
	public void testSerializingWithJsonAnyGetter() throws JsonProcessingException {
		JsonAnyGetterDemoBean bean = new JsonAnyGetterDemoBean();
		Map<String, String> stringMap = bean.getProperties();
		stringMap.put("emailId", "james@gmail.com");
		stringMap.put("gender", "male");
		String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("emailId"));
		assertThat(jsonString, containsString("gender"));
	}
}
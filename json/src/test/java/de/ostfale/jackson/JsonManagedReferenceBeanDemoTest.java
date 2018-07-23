package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * //TODO INSERT DESCRIPTION
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonManagedReferenceBeanDemoTest {

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
	public void testSerializingWithJsonManagedAndBackReference() throws JsonProcessingException {
		JsonBackReferenceDemoBean demoBean = new JsonBackReferenceDemoBean(123L, "Mary Parker");
		JsonManagedReferenceBeanDemo bean = new JsonManagedReferenceBeanDemo(231L, "John Thomas", demoBean);
		demoBean.addEmployees(bean);
		String jsonString = objectMapper.writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("John Thomas"));
		assertThat(jsonString, containsString("231"));
		assertThat(jsonString, not(containsString("employees")));
	}
}
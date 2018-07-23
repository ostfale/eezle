package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The test code to test the @JsonIdentityInfo annotation
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonIdentityInfoEmployeeDemoBeanTest {

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
	public void testSerializingWithJsonIdentityInfo() throws JsonProcessingException {
		IdentityInfoManagerDemoBean demoBean = new IdentityInfoManagerDemoBean(123L, "Mary Parker");
		JsonIdentityInfoEmployeeDemoBean bean = new JsonIdentityInfoEmployeeDemoBean(231L, "John Thomas", demoBean);
		demoBean.addEmployees(bean);
		String jsonString = objectMapper.writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("John Thomas"));
		assertThat(jsonString, containsString("231"));
		assertThat(jsonString, containsString("employees"));
	}
}
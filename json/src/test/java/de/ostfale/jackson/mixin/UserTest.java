package de.ostfale.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Complete test code to test the Jackson mix-in
 * Created : 13.08.2018
 *
 * @author : usauerbrei
 */
public class UserTest {

	private User user;

	@Before
	public void setUp() {
		user = new User(123, "James", 23, "Male",
				"james@gmail.com", "1234567890");
	}

	@After
	public void tearDown() {
		user = null;
	}

	@Test
	public void JacksonMixinAnnotationTest() throws JsonProcessingException {
		ObjectMapper objectMapper = buildMapper();
		objectMapper.addMixIn(User.class, UserMixin.class);
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
		System.out.println(json);

	}

	private static ObjectMapper buildMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibilityChecker(objectMapper.getSerializationConfig()
				.getDefaultVisibilityChecker()
				.withFieldVisibility(JsonAutoDetect.Visibility.ANY)
				.withGetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withSetterVisibility(JsonAutoDetect.Visibility.NONE)
				.withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
		return objectMapper;
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Here, the CustomDateDeserializer class extends the StdDeserializer class with a generic type Date.
 * The overriden deserialize() method returns the Date object.
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class JsonDeserializeDemoBeanTest {

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
	public void testDeSerializingWithJsonDeserialize() throws IOException {
		String jsonString = "{\"personId\": 231, \"name\": \"Mary Parker\", " + "\"activeDate\":\"26-09-2017 11:00:00\"}";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		JsonDeserializeDemoBean bean = objectMapper.readValue(jsonString, JsonDeserializeDemoBean.class);
		System.out.println(bean);
		assertThat(bean.name, is(equalTo("Mary Parker")));
		assertThat(bean.personId, is(equalTo(231L)));
		assertEquals("26-09-2017 11:00:00", simpleDateFormat.format(bean.activeDate));
	}
}
package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * The code to test the @JsonSerialize annotation is this.
 * Created : 19.07.2018
 *
 * @author : usauerbrei
 */
public class JsonSerializeDemoBeanTest {

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
	public void testSerializingWithJsonSerialize() throws JsonProcessingException, ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String date = "29-09-2017 10:00:00";
		Date newDate = simpleDateFormat.parse(date);
		JsonSerializeDemoBean bean = new JsonSerializeDemoBean();
		bean.setActiveDate(newDate);
		String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bean);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("123"));
		assertThat(jsonString, containsString("29-09-2017 10:00:00"));
	}
}
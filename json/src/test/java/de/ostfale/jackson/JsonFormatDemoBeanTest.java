package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Test code to test the @JsonFormat annotation
 * Created : 18.07.2018
 *
 * @author : usauerbrei
 */
public class JsonFormatDemoBeanTest {

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
	public void testSerializingWithJsonFormat() throws JsonProcessingException, ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		String dateAndTime = "26-09-2017 11:00:00";
		Date date = simpleDateFormat.parse(dateAndTime);
		JsonFormatDemoBean fb = new JsonFormatDemoBean();
		fb.setActiveDate(date);
		String jsonString = objectMapper.writeValueAsString(fb);
		System.out.println(jsonString);
		assertThat(jsonString, containsString("James Clark"));
		assertThat(jsonString, containsString("123"));
		assertThat(jsonString, containsString("26-09-2017 11:00:00"));
	}

}
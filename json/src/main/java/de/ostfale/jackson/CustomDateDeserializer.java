package de.ostfale.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The custom deserializer
 * Created : 23.07.2018
 *
 * @author : usauerbrei
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

	public CustomDateDeserializer() {
		this(null);
	}

	public CustomDateDeserializer(Class<?> c) {
		super(c);
	}

	@Override
	public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
		try {
			String date = jsonParser.getText();
			return simpleDateFormat.parse(date);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

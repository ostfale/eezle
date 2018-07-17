package de.ostfale.base.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 * Using TemporalQuery allows us to check which information is present and to provide defaults
 * for any information that is missing
 * Created : 31.05.2018
 *
 * @author : usauerbrei
 */
public class MyCustomTemporalQuery implements TemporalQuery {

	public static void main(String[] args) {

		TemporalQuery<TemporalAccessor> myCustomQuery = new MyCustomTemporalQuery();

		// results in 2018-03-16
		//LocalDateTime localDateTime = conversionService.convert( formatter.parse( "2018-03-16", myCustomQuery ), LocalDateTime.class );
		// results in 00:00
		//LocalTime localTime = conversionService.convert( formatter.parse( "2018-03-16", myCustomQuery ), LocalTime.class );
	}

	@Override
	public Object queryFrom(TemporalAccessor temporal) {
		LocalDate date = temporal.isSupported(ChronoField.EPOCH_DAY) ? LocalDate.ofEpochDay(temporal.getLong(ChronoField.EPOCH_DAY)) : LocalDate.now();
		LocalTime time = temporal.isSupported(ChronoField.NANO_OF_DAY) ? LocalTime.ofNanoOfDay(temporal.getLong(ChronoField.NANO_OF_DAY)) : LocalTime.MIN;
		return LocalDateTime.of(date, time);
	}
}

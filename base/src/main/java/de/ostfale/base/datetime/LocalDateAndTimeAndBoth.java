package de.ostfale.base.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * Handling von {@link java.time.LocalDate} and {@link java.time.LocalDateTime} and {@link java.time.LocalTime}
 * Created : 22.05.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class LocalDateAndTimeAndBoth {

	public static void main(String[] args) {
		new LocalDateAndTimeAndBoth().doIt();
	}

	private void doIt() {
		instantiationExample();
		conversionExample();
		plusMinusExample();
		localDateToDateTime();
	}

	/**
	 * All of these types represent the local date and/or time for a region, but, just like java.util.Date,
	 * they contain zero information about the zone in which it is represented, only a representation of the
	 * date and time in your current timezone.
	 */
	private void instantiationExample() {
		LocalDate date = LocalDate.of(2018, 2, 13);
		log.info("LocalDate parsed args : {}", date);
		// Uses DateTimeformatter.ISO_LOCAL_DATE for which the format is: yyyy-MM-dd
		date = LocalDate.parse("2018-02-14");
		log.info("LocalDate parsed String : {}", date);

		LocalTime time = LocalTime.of(6, 30);
		log.info("LocalTime parsed args : {}", time);
		// Uses DateTimeFormatter.ISO_LOCAL_TIME for which the format is: HH:mm[:ss[.SSSSSSSSS]]
		// this means that both seconds and nanoseconds may optionally be present.
		time = LocalTime.parse("06:30");
		log.info("LocalTime parsed String : {}", time);

		LocalDateTime dateTime = LocalDateTime.of(2018, 2, 13, 6, 30);
		log.info("LocalDateTime parsed args : {}", dateTime);
		// Uses DateTimeFormatter.ISO_LOCAL_DATE_TIME for which the format is the
		// combination of the ISO date and time format, joined by 'T': yyyy-MM-dd'T'HH:mm[:ss[.SSSSSSSSS]]
		dateTime = LocalDateTime.parse("2018-02-13T06:30");
		log.info("LocalDateTime parsed String : {}", dateTime + "\n");
	}

	private void conversionExample() {
		// LocalDate to LocalDateTime
		LocalDateTime dateTime = LocalDate.parse("2018-02-13").atTime(LocalTime.parse("06:30"));
		log.info("At date to a given date: {}", dateTime);

		// LocalTime to LocalDateTime
		dateTime = LocalTime.parse("06:30").atDate(LocalDate.parse("2018-02-13"));
		log.info("At time to a given date: {}", dateTime);

		// LocalDateTime to LocalDate/LocalTime
		LocalDate date = LocalDateTime.parse("2018-02-13T06:30").toLocalDate();
		log.info("Get date from datetime: {}", date);
		LocalTime time = LocalDateTime.parse("2018-02-13T06:30").toLocalTime();
		log.info("Get time from datetime: {}", time + "\n");
	}

	/**
	 * It's easy to perform operations on our date and time representations, using the `plus` and `minus` methods as well as
	 * some utility functions
	 */
	private void plusMinusExample() {
		LocalDate date = LocalDate.parse("2018-02-13").plusDays(5);
		log.info("Added 5 days to a date: {}", date);
		date = LocalDate.parse("2018-02-13").plus(3, ChronoUnit.MONTHS);
		log.info("Added 3 month to a date: {}", date);

		LocalTime time = LocalTime.parse("06:30").minusMinutes(30);
		log.info("Go back 30 minutes: {}", time);
		time = LocalTime.parse("06:30").minus(500, ChronoUnit.MILLIS);
		log.info("Go back 500 milliseconds: {}", time);

		LocalDateTime dateTime = LocalDateTime.parse("2018-02-13T06:30").plus(Duration.ofHours(2));
		log.info("Add 2 hours to da LocalDateTime: {}", dateTime);


		// using TemporalAdjusters, which implements a few useful cases:
		date = LocalDate.parse("2018-02-13").with(TemporalAdjusters.lastDayOfMonth());
		log.info("Get last day of month with temporal adjusters: {}", date + "\n");
	}

	/**
	 * We can convert from a Date type to the Instant type, which is a representation of the time since the epoch
	 * of 1 January 1970, and then we can instantiate a LocalDateTime using the Instant and the current zone.
	 * To convert back to a date, we can simply use the Instant that the Java 8 time type represents.
	 * One thing to take note of, though, is that although LocalDate, LocalTime and LocalDateTime do not contain
	 * any Zone or Offset information, they do represent the local date and/or time in a specific region,
	 * and as such they do hold the offset present in that region. Thus, we are required to provide an offset
	 * to correctly convert the specific type to an Instant.
	 */
	private void localDateToDateTime() {

		LocalDateTime dateTime = LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());
		log.info("LocalDateTime from current Date: {}", dateTime);

		Date now = new Date();
		log.info("Date now: {}", now);
		dateTime = LocalDateTime.ofInstant(now.toInstant(), ZoneId.systemDefault());
		log.info("Local datetime of now: {}", dateTime);
		Date date = Date.from(dateTime.toInstant(ZoneOffset.ofHours(1)));
		log.info("Date with Zone offset: {}", date);
		date = Date.from(dateTime.toInstant(ZoneId.systemDefault().getRules().getOffset(dateTime)));
		log.info("Date with Zone systemdefault offset: {}", date);
	}
}

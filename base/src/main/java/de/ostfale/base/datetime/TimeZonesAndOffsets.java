package de.ostfale.base.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.util.Set;

/**
 * Java 8 provides us with ZonedDateTime and OffsetDateTime, the first one being a LocalDateTime
 * with information for a specific Zone (e.g. Europe/Paris), the second one being a LocalDateTime
 * with an offset. What’s the difference? OffsetDateTime uses a fixed time difference between
 * UTC/Greenwich and the date that is specified, whilst ZonedDateTime specifies the zone in which
 * the time is represented, and will take daylight saving time into account.
 * Created : 24.05.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class TimeZonesAndOffsets {

	public static void main(String[] args) {
		new TimeZonesAndOffsets().doIt();
	}

	private void doIt() {
		convertBetweenOffestandZonedDateTime();
		switchingBetweenZonedAndOffsetDateTime();
		getTimeOffsetForSpecificZone();
	}

	private void convertBetweenOffestandZonedDateTime() {
		OffsetDateTime offsetDateTime = LocalDateTime.parse("2018-02-14T06:30").atOffset(ZoneOffset.ofHours(2));
		log.info("Use standard format of OffsetDateTime: {}", offsetDateTime);

		// Uses DateTimeFormatter.ISO_OFFSET_DATE_TIME for which the default format is
		// ISO_LOCAL_DATE_TIME followed by the offset ("+HH:mm:ss")
		offsetDateTime = OffsetDateTime.parse("2018-02-14T06:30+06:00");
		log.info("Use ISO_OFFSET format of OffsetDateTime: {}", offsetDateTime);

		ZonedDateTime zonedDateTime = LocalDateTime.parse("2018-02-14T06:30").atZone(ZoneId.of("Europe/Paris"));
		log.info("Use standard zoned Date: {}", zonedDateTime);


		// Uses DateTimeFormatter.ISO_ZONED_DATE_TIME for which the default format is
		// ISO_OFFSET_DATE_TIME followed by the the ZoneId in square brackets.
		zonedDateTime = ZonedDateTime.parse("2018-02-14T06:30+08:00[Asia/Macau]");
		log.info("Use ISO_ZONED_DATE_TIME zoned Date: {}", zonedDateTime + "\n");
	}

	/**
	 * Converting from a ZonedDateTime to OffsetDateTime will take daylight saving time into account, while converting
	 * in the other direction, from OffsetDateTime to ZonedDateTime, means you will not have information about the region
	 * of the zone, nor will there be any rules applied for daylight saving time. That is because an offset does not
	 * define any time zone rules, nor is it bound to a specific region.
	 */
	private void switchingBetweenZonedAndOffsetDateTime() {
		ZonedDateTime winter = LocalDateTime.parse("2018-01-14T06:30").atZone(ZoneId.of("Europe/Paris"));
		ZonedDateTime summer = LocalDateTime.parse("2018-08-14T06:30").atZone(ZoneId.of("Europe/Paris"));


		// offset will be +01:00
		OffsetDateTime offsetDateTime = winter.toOffsetDateTime();
		log.info("Offset winter datetime (1h): {}", offsetDateTime);

		// offset will be +02:00
		offsetDateTime = summer.toOffsetDateTime();
		log.info("Offset summer datetime (2h): {}", offsetDateTime);


		offsetDateTime = LocalDateTime.parse("2018-02-14T06:30").atOffset(ZoneOffset.ofHours(5));
		log.info("Show localdatetime with offset 5h: {}", offsetDateTime);
		ZonedDateTime zonedDateTime = offsetDateTime.toZonedDateTime();
		log.info("Show zonedDateTime from above offest: {}", zonedDateTime + "\n");
	}

	/**
	 * Now, what if we would like to know what the time for a specific zone or offset is in our own timezone?
	 */
	private void getTimeOffsetForSpecificZone() {
		// timeInMacau represents 2018-02-14T13:30+08:00[Asia/Macau]
		ZonedDateTime timeInMacau = LocalDateTime.parse( "2018-02-14T13:30" ).atZone( ZoneId.of( "Asia/Macau" ) );
		log.info("Time in Macau: {}", timeInMacau);

		// timeInParis represents 2018-02-14T06:30+01:00[Europe/Paris]
		ZonedDateTime timeInParis = timeInMacau.withZoneSameInstant( ZoneId.of( "Europe/Paris" ) );
		log.info("Time in Paris: {}", timeInParis);

		OffsetDateTime offsetInMacau = LocalDateTime.parse( "2018-02-14T13:30" ).atOffset( ZoneOffset.ofHours( 8 ) );
		log.info("Offset datetime in Macau: {}", offsetInMacau);
		OffsetDateTime offsetInParis = offsetInMacau.withOffsetSameInstant( ZoneOffset.ofHours( 1 ) );
		log.info("Offset datetime in Paris: {}", offsetInParis);

		Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
	//	availableZoneIds.forEach(System.out::println);
	}
}

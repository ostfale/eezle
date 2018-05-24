package de.ostfale.base.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Duration and Period are two representations of time between two dates, the former representing the difference
 * of time in seconds and nanoseconds, the latter in days, months and years.
 * Created : 24.05.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class DurationAndPeriod {

	public static void main(String[] args) {
		new DurationAndPeriod().doIt();
	}

	private void doIt() {
		getDifferenceBetweenTwoLocalDateValues();
	}

	/**
	 * When outputting Period or Duration using toString(), a special format will be used based on ISO-8601 standard.
	 * The pattern used for a Period is PnYnMnD, where n defines the number of years, months or days present within the period.
	 * This means that P1Y2M3D defines a period of 1 year, 2 months, and 3 days. The ‘P’ in the pattern is the period designator,
	 * which tells us that the following format represents a period.<br>
	 * When using Durations, we move away slightly from the ISO-8601 standard, as Java 8 does not use the same patterns.
	 * The pattern defined by ISO-8601 is PnYnMnDTnHnMn.nS. This is basically the Period pattern, extended with a time representation.
	 * In the pattern, T is the time designator, so the part that follows defines a duration specified in hours, minutes and seconds.
	 */
	private void getDifferenceBetweenTwoLocalDateValues() {
		Period period = Period.between(LocalDate.parse("2018-01-18"), LocalDate.parse("2018-02-14"));
		log.info("Show period (days, month, years) between to dates: {}", period);

		Duration duration = Duration.between(LocalDateTime.parse("2018-01-18T06:30"), LocalDateTime.parse("2018-02-14T22:58"));
		log.info("Show duration (seconds, nanoseconds) between to dates: {}", duration);

		long hours = duration.toHours();
		log.info("Show hours of duration: {}", hours);


		hours = LocalDateTime.parse("2018-01-18T06:30").until(LocalDateTime.parse("2018-02-14T22:58"), ChronoUnit.HOURS);
		log.info("Show difference between to timestamps: {}", hours);
	}
}

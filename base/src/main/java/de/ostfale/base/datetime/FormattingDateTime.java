package de.ostfale.base.datetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * Formatting examples
 * Created : 28.05.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class FormattingDateTime {

	public static void main(String[] args) {
		new FormattingDateTime().doIt();
	}

	private void doIt() {
		handleDifferentFormatsAtOnce();
		useBuilderPattern();
		multiplePatternsDifferSlightly();
	}

	/**
	 * The square brackets in a pattern define an optional part in the pattern. By making our various formats optional,
	 * the first pattern that matches the string will be used to convert our date representation.
	 */
	private void handleDifferentFormatsAtOnce() {
		// Let’s say we want to convert all of patterns mentioned above.
		// 09-23-2018, 23/09/2018 and 2018-09-23 should all convert to the same LocalDate.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][dd/MM/yyyy][MM-dd-yyyy]");
		LocalDate localDate = LocalDate.parse("09-23-2018", formatter);
		log.info("Local data from 09-23-2018 : {}", localDate);
		localDate = LocalDate.parse("23/09/2018", formatter);
		log.info("Local data from 23/09/2018 : {}", localDate);
		localDate = LocalDate.parse("2018-09-23", formatter);
		log.info("Local data from 2018-09-23 : {}", localDate + "\n");
	}

	private void useBuilderPattern() {

		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
				.optionalStart().appendPattern("dd/MM/yyyy").optionalEnd()
				.optionalStart().appendPattern("MM-dd-yyyy").optionalEnd()
				.toFormatter();

		LocalDate localDate = LocalDate.parse("09-23-2018", formatter);
		log.info("Builder:: Local data from 09-23-2018 : {}", localDate);
		localDate = LocalDate.parse("23/09/2018", formatter);
		log.info("Builder:: Local data from 23/09/2018 : {}", localDate);
		localDate = LocalDate.parse("2018-09-23", formatter);
		log.info("Builder:: Local data from 2018-09-23 : {}", localDate + "\n");
	}

	/**
	 * What if our patterns only differ slightly? Let’s take a look at yyyy-MM-dd and yyyy-MMM-dd
	 */
	private void multiplePatternsDifferSlightly() {
		// 2018-09-23 and 2018-Sep-23 should convert to the same LocalDate.
		// Using the ofPattern example we’ve used above will work:
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[yyyy-MM-dd][yyyy-MMM-dd]");
		LocalDate localDate = LocalDate.parse("2018-09-23", formatter);
		log.info("Local data from 2018-09-23 : {}", localDate);
		localDate = LocalDate.parse("2018-Sep-23", formatter);
		log.info("Local data from 2018-Sep-23 : {}", localDate);


		// Using the ofPattern example where we reuse the common part of the pattern
		formatter = DateTimeFormatter.ofPattern("yyyy-[MM-dd][MMM-dd]");
		localDate = LocalDate.parse("2018-09-23", formatter);
		log.info("With common part: Local data from 2018-09-23 : {}", localDate);
		localDate = LocalDate.parse("2018-Sep-23", formatter);
		log.info("With common part: Local data from 2018-Sep-23 : {}", localDate);
	}
}

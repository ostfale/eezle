package de.ostfale.xmlunit.basic;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.ComparisonControllers;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

/**
 * Differences between two XML documents above are detected by the Difference Engine.
 * By default and for efficiency reasons, it stops the comparison process as soon as the first difference is found.
 * <p>
 * Created : 14.08.2018
 *
 * @author : usauerbrei
 */
public class DetailedDifferenceTest {

	private static final Logger logger = LoggerFactory.getLogger(DetailedDifferenceTest.class);

	/**
	 * To get all the differences between two pieces of XML we use an instance of the Diff class like so
	 */
	@Test
	public void given2XMLS_whenGeneratesDifferences_thenCorrect() {
		String controlXml = "<struct><int>3</int><boolean>false</boolean></struct>";
		String testXml = "<struct><boolean>false</boolean><int>3</int></struct>";
		Diff myDiff = DiffBuilder.compare(controlXml).withTest(testXml).build();

		Iterator<Difference> differenceIterator = myDiff.getDifferences().iterator();
		int size = 0;
		while (differenceIterator.hasNext()) {
			logger.info(differenceIterator.next().toString());
			size++;
		}
		assertThat(size, greaterThan(1));
	}

	/**
	 * If we want to force the Difference Engine to stop after the first difference is found and not
	 * proceed to enumerate further differences – we need to supply a ComparisonController:
	 */
	@Test
	public void given2XMLS_whenGeneratesOneDifference_thenCorrect() {
		String myControlXML = "<struct><int>3</int><boolean>false</boolean></struct>";
		String myTestXML = "<struct><boolean>false</boolean><int>3</int></struct>";

		Diff myDiff = DiffBuilder
				.compare(myControlXML)
				.withTest(myTestXML)
				.withComparisonController(ComparisonControllers.StopWhenDifferent)
				.build();

		Iterator<Difference> differenceIterator = myDiff.getDifferences().iterator();
		int size = 0;
		while (differenceIterator.hasNext()) {
			logger.info(differenceIterator.next().toString());
			size++;
		}
		assertThat(size, equalTo(1));
	}
}

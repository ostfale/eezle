package de.ostfale.xmlunit.differences;

import org.junit.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A DifferenceEvaluator makes determinations of the outcome of a comparison. Its role is
 * restricted to determining the severity of a comparison’s outcome.
 * Created : 14.08.2018
 *
 * @author : usauerbrei
 */
public class CustomDifferenceEvaluator {

	private static final String CONTROL = "<a><b attr=\"abc\"></b></a>";
	private static final String TEST = "<a><b attr=\"xyz\"></b></a>";

	/**
	 * In the default state, they are technically evaluated as different because their attr attributes have different values.
	 */
	@Test
	public void given2XMLsWithDifferences_whenTestsDifferentWithoutDifferenceEvaluator_thenCorrect() {
		Diff myDiff = DiffBuilder.compare(CONTROL).withTest(TEST)
				.checkForSimilar().build();
		assertTrue(myDiff.toString(), myDiff.hasDifferences());
	}

	/**
	 * We then rewrite our initial failed test and supply our own DifferenceEvaluator instance
	 */
	@Test
	public void given2XMLsWithDifferences_whenTestsSimilarWithDifferenceEvaluator_thenCorrect() {
		Diff myDiff = DiffBuilder.compare(CONTROL).withTest(TEST)
				.withDifferenceEvaluator(new IgnoreAttributeDifferenceEvaluator("attr"))
				.checkForSimilar().build();

		assertFalse(myDiff.toString(), myDiff.hasDifferences());
	}
}

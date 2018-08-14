package de.ostfale.xmlunit.basic;

import org.junit.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.ElementSelectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.xmlunit.matchers.CompareMatcher.isSimilarTo;

/**
 * The DefaultNodeMatcher class is consulted by XMLUnit at comparison stage as it loops over nodes of controlXml, to determine
 * which XML node from testXml to compare with the current XML node it encounters in controlXml.
 * Before that, DefaultNodeMatcher will have already consulted ElementSelector to decide how to match nodes.
 * Our test has failed because in the default state, XMLUnit will use a depth-first approach to traversing the XMLs and based
 * on document order to match nodes, hence <int> is matched with <boolean>.
 * Created : 14.08.2018
 *
 * @author : usauerbrei
 */
public class CompareSpecificNodesTest {

	private static final String SOURCE = "<struct><int>3</int><boolean>false</boolean></struct>";
	private static final String TARGET = "<struct><boolean>false</boolean><int>3</int></struct>";

	/**
	 * In this case, we are telling DefaultNodeMatcher that when XMLUnit asks for a node to compare,
	 * you should have sorted and matched the nodes by their element names already.
	 */
	@Test
	public void given2XMLS_whenSimilar_thenCorrect() {
		assertThat(TARGET,
				isSimilarTo(SOURCE).withNodeMatcher(
						new DefaultNodeMatcher(ElementSelectors.byName)));
	}

	/**
	 * Alternatively, we could have used a Diff from xmlunit-core rather than using xmlunit-matchers
	 */
	@Test
	public void given2XMLs_whenSimilarWithDiff_thenCorrect() {
		Diff myDiffSimilar = DiffBuilder.compare(SOURCE).withTest(TARGET)
				.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byName))
				.checkForSimilar().build();

		assertFalse("XML similar " + myDiffSimilar.toString(),
				myDiffSimilar.hasDifferences());
	}
}

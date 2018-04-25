package de.ostfale.stream.filter;

import de.ostfale.stream.domain.Book;
import de.ostfale.stream.domain.BookLibrary;
import de.ostfale.stream.domain.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The method Filter allows selective processing of stream elements
 * <p>
 *     <code>Stream &lt;T&gt; filter(Predicate&lt;T&gt;)</code>
 * </p>
 * Created : 25.04.2018
 *
 * @author : usauerbrei
 */
public class FilterExamples {

	private static final Logger logger = LoggerFactory.getLogger(FilterExamples.class);

	private List<Book> bookList;

	public static void main(String[] args) {
		new FilterExamples().doIt();
	}

	private void doIt() {
		filterByTopic();
	}

	private void filterByTopic() {
		bookList = BookLibrary.initBookList();
		List<Book> result = bookList.stream()
				.filter(b -> b.getTopic() == Topic.COMPUTING)
				.collect(Collectors.toList());

		logger.info("Number of Computing Books: {}", result.size());
	}
}

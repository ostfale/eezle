package naftalin.streams.bookexample;

import lombok.extern.slf4j.Slf4j;

import java.time.Year;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Examples of stream processing using book library data
 * Created : 13.11.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class ExamplesStreamProcessing {

	private static List<Book> library = Bootstrap.getLibrary();

	public static void main(String[] args) {
		doIt();
	}

	private static void doIt() {
		Stream<Book> computingBooks = library.stream().filter(b -> b.getTopic() == Topic.COMPUTING); // stream of computing books
		log.info("Nof. computing books: {}", computingBooks.count());

		Stream<String> bookTitles = library.stream().map(Book::getTitle);
		log.info("Nof. book titles: {}", bookTitles.count());

		// list of sorted Booktitles
		Stream<Book> sortedByTitle = library.stream().sorted(Comparator.comparing(Book::getTitle));
		printStream(sortedByTitle);

		Stream<String> authorsInBookTitleOrder = library.stream()
				                                         .sorted(Comparator.comparing(Book::getTitle))
				                                         .flatMap(book -> book.getAuthors().stream())
				                                         .distinct();
		authorsInBookTitleOrder.forEach(System.out::println);

		Stream<Book> firstHundredBooks = library.stream().sorted(Comparator.comparing(Book::getTitle)).limit(100);
		printStream(firstHundredBooks);

		Stream<Book> restAfterHundredBooks = library.stream().sorted(Comparator.comparing(Book::getTitle)).skip(100);
		printStream(restAfterHundredBooks);

		Optional<Book> oldestBook = library.stream().min(Comparator.comparing(book -> book.getPubDate()));
		log.info("Oldest book: {}", oldestBook.get());

		Set<String> titles = library.stream().map(Book::getTitle).collect(toSet());

		intSummaryStatisticsExample();
		findOldestBookInLibrary();
		collectTitleOfBooksIntoSet();
		mapBookTitleToPublicationDate();
		mappingWithDuplicateKeysAllowed();
	}

	private static void mappingWithDuplicateKeysAllowed() {
		Map<String, Year> titleToPubdate = library.stream()
				                                   .collect(toMap(Book::getTitle, Book::getPubDate, (x, y) -> x.isAfter(y) ? x : y));
		log.info("Map with merger function: " + titleToPubdate.toString());
	}

	private static void mapBookTitleToPublicationDate() {
		Map<String, Year> titleToPubDate = library.stream()
				                                   .collect(toMap(Book::getTitle, Book::getPubDate));
		log.info("Mapped title to publication date: " + titleToPubDate.toString());
	}

	private static void collectTitleOfBooksIntoSet() {
		Set<String> titles = library.stream().map(Book::getTitle).collect(toSet());
		log.info("All book titles: {}", titles.toString());
	}

	private static void findOldestBookInLibrary() {
		Optional<Book> oldestBook = library.stream()
				                            .min(Comparator.comparing(Book::getPubDate));
		log.info("Oldest book in library: {}", oldestBook.get().getTitle());
	}

	private static void intSummaryStatisticsExample() {

		IntSummaryStatistics intSummaryStatistics = library.stream()
				                                            .mapToInt(b -> IntStream.of(b.getPageCount()).sum())
				                                            .summaryStatistics();
		log.info("Pagecount: {} :: Min: {} :: Max: {}", intSummaryStatistics.getCount(), intSummaryStatistics.getMin(), intSummaryStatistics.getMax());

	}

	private static void printStream(Stream<Book> bookStream) {
		bookStream.forEach(System.out::println);
	}
}

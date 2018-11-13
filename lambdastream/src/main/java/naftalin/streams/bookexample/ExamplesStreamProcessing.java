package naftalin.streams.bookexample;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

		Set<String> titles = library.stream().map(Book::getTitle).collect(Collectors.toSet());

	}

	private static void printStream(Stream<Book> bookStream) {
		bookStream.forEach(System.out::println);
	}
}

package naftalin.streams.bookexample;

import lombok.extern.slf4j.Slf4j;

import java.time.Year;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * Collectors functions
 * Created : 16.11.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class CollectorsExample {

	private static List<Book> library = Bootstrap.getLibrary();

	public static void main(String[] args) {
		doIt();
	}

	private static void doIt() {
		usingFinisherForFirstBookTitleChar();
		immutableBookList();
		chainingMostPopularTopic();
		mapConcatenatedTitlesByTopic();
		partitioningByFictionOrNonFiction();
		summarizeStatistice();
		groupingByAveragedHeightPerTopic();
		groupingVolumeCountsByTopic();
		groupingByNumberOfAuthors();
		groupingByAndCountingCollector();
		groupingByWithUserSuppliedCollector();
		groupingBooksByTopic();
		toCollectionExamples();
		toMapFunction();
		joiningExamples();
	}

	private static void usingFinisherForFirstBookTitleChar() {
		Map<Character, String> firstCharOfBookJoined = library.stream()
				                                               .map(Book::getTitle)
				                                               .collect(groupingBy(t -> t.charAt(0), joining(";")));
		log.info("Show first Char of Book title: " + firstCharOfBookJoined);
	}

	private static void immutableBookList() {
		List<String> titles = library.stream()
				                      .map(Book::getTitle)
				                      .collect(collectingAndThen(toList(), Collections::unmodifiableList));
		log.info("Book titles in unmodifiables list: " + titles);
	}

	private static void chainingMostPopularTopic() {
		Optional<Topic> mostPopularTopic = library.stream()
				                                   .collect(groupingBy(Book::getTopic, counting()))
				                                   .entrySet().stream()
				                                   .max(Map.Entry.comparingByValue())
				                                   .map(Map.Entry::getKey);
		log.info("Most popular topic: " + mostPopularTopic.get());
	}

	private static void mapConcatenatedTitlesByTopic() {
		Map<Topic, String> concatenatedTitlesByTopic = library.stream()
				                                               .collect(groupingBy(Book::getTopic, mapping(Book::getTitle, joining(";"))));
		log.info("Concatenated titles per topic: " + concatenatedTitlesByTopic);
	}

	private static void summarizeStatistice() {
		Map<Topic, IntSummaryStatistics> volumeStats = library.stream()
				                                               .collect(groupingBy(Book::getTopic, summarizingInt(b -> b.getPageCount().length)));
		log.info("Show volume statistics: " + volumeStats);
	}

	private static void groupingByAveragedHeightPerTopic() {
		Map<Topic, Double> averageHeightByTopic = library.stream()
				                                          .collect(groupingBy(Book::getTopic, averagingDouble(Book::getHeight)));
		log.info("Average height per Topic: " + averageHeightByTopic);
	}

	private static void groupingVolumeCountsByTopic() {
		Map<Topic, Integer> volumeCountByTopic = library.stream()
				                                         .collect(groupingBy(Book::getTopic, summingInt(b -> b.getPageCount().length)));
		log.info("Volumes per topic: " + volumeCountByTopic);
	}

	private static void groupingByNumberOfAuthors() {
		Map<Topic, Optional<Book>> mostAuthorsByTopic = library.stream()
				                                                .collect(groupingBy(Book::getTopic, maxBy(Comparator.comparing(b -> b.getAuthors().size()))));
		log.info("Books by no of authors: " + mostAuthorsByTopic);
	}

	private static void groupingByAndCountingCollector() {
		Map<Topic, Long> booksCounted = library.stream().collect(groupingBy(Book::getTopic, Collectors.counting()));
		log.info("GroupingBy with user Collectors counting: " + booksCounted);
	}

	private static void groupingByWithUserSuppliedCollector() {
		Map<Topic, List<Book>> booksByTopic = library.stream().collect(groupingBy(Book::getTopic, Collectors.toList()));
		log.info("GroupingBy with user supplied collector: " + booksByTopic);
	}

	private static void partitioningByFictionOrNonFiction() {
		Map<Boolean, List<Book>> fictionOrNonFiction = library.stream()
				                                               .collect(partitioningBy(b -> b.getTopic() == Topic.FICTION || b.getTopic() == Topic.HISTORY));
		log.info("Partitioning by Fiction or Non Fiction: " + fictionOrNonFiction);
	}

	private static void groupingBooksByTopic() {
		Map<Topic, List<Book>> booksByTopic = library.stream()
				                                      .collect(groupingBy(Book::getTopic));
		log.info("Grouped books by Topic: " + booksByTopic);
	}

	private static void toCollectionExamples() {

		NavigableSet<String> sortedTitles = library.stream().map(Book::getTitle).collect(toCollection(TreeSet::new));
		log.info("Collect into navigable set: " + sortedTitles);

		BlockingQueue<Book> queueInPubDateOrder = library.stream()
				                                          .sorted(Comparator.comparing(Book::getPubDate))
				                                          .collect(toCollection(LinkedBlockingQueue::new));
		log.info("Collect in blocking queue: " + queueInPubDateOrder);

	}

	private static void toMapFunction() {
		Map<String, Year> titleToPubDate = library.stream()
				                                   .collect(toMap(Book::getTitle,
						                                   Book::getPubDate,
						                                   BinaryOperator.maxBy(Comparator.naturalOrder()), TreeMap::new));
		log.info("Books by PubDate: " + titleToPubDate);
	}

	private static void joiningExamples() {
		String concatenatedTitles = library.stream().map(Book::getTitle).collect(joining("::"));
		log.info("Concatenated titles: {}", concatenatedTitles);

		List<String> allAuthorsForABook = library.stream()
				                                  .map(b -> b.getAuthors().stream()
						                                            .collect(joining(" - ", b.getTitle() + ": ", "")))
				                                  .collect(toList());
		log.info("Books by authors: " + allAuthorsForABook.toString());
	}
}

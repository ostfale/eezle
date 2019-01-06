package naftalin.booksfindingexample;

import lombok.extern.slf4j.Slf4j;
import naftalin.streams.bookexample.Book;
import naftalin.streams.bookexample.Bootstrap;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toConcurrentMap;

/**
 * Calculates position of the books on the shelf
 * Created : 22.11.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class DisplacementCalculator {

	private static List<Book> library = Bootstrap.getLibrary();

	// creates an empty container
	private Supplier<Deque<DispRecord>> supplier = ArrayDeque::new;

	// appends a single book to Deque and calc displacement from last element
	private BiConsumer<Deque<DispRecord>, Book> accumulator = (dqLeft, b) -> {
		int disp = dqLeft.isEmpty() ? 0 : dqLeft.getLast().totalDisp();
		dqLeft.add(new DispRecord(b.getTitle(), disp, Arrays.stream(b.getPageCount()).sum()));
	};

	// merges two disRecord instances
	private BinaryOperator<Deque<DispRecord>> combiner = (left, right) -> {
		if (left.isEmpty()) return right;
		int newDisp = left.getLast().totalDisp();
		List<DispRecord> displacedRecords = right.stream().map(dr -> new DispRecord(dr.title, dr.disp + newDisp, dr.length)).collect(Collectors.toList());
		left.addAll(displacedRecords);
		return left;
	};

	private Function<Deque<DispRecord>, Map<String, Integer>> finisher =
			ddr -> ddr.parallelStream().collect(toConcurrentMap(dr -> dr.title, dr -> dr.disp));

	public static void main(String[] args) {
		new DisplacementCalculator().doIt();
	}

	private void doIt() {
		Map<String, Integer> displacmentMap = library.stream().collect(Collector.of(supplier, accumulator, combiner, finisher));
		log.info("Book displament: " + displacmentMap.toString());
	}
}

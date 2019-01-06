package functionalinterface.predicate;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Predicate functional interface is a specialization of a Function that receives a generified value and returns a boolean.
 * A typical use case of the Predicate lambda is to filter a collection of values
 * Created : 21.11.2018
 *
 * @author : usauerbrei
 */
@Slf4j
public class PredicateExample {

	public static void main(String[] args) {
		doIt();
	}

	private static void doIt() {
		simpleExample();
	}

	/**
	 * In the code above we filter a list using the Stream API and keep only names that start with the letter “A”.
	 * The filtering logic is encapsulated in the Predicate implementation.
	 */
	private static void simpleExample() {
		List<String> names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
		List<String> namesWithA = names.stream()
				                          .filter(name -> name.startsWith("A"))
				                          .collect(Collectors.toList());
		log.info("Names starting with A: " + namesWithA);
	}
}

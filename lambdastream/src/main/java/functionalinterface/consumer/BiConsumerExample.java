package functionalinterface.consumer;

import java.util.HashMap;
import java.util.Map;

/**
 * Example for {@link java.util.function.BiConsumer}
 * Represents an operation that accepts two input arguments and returns no result.
 *
 * Created : 21.11.2018
 *
 * @author : usauerbrei
 */
public class BiConsumerExample {

	public static void main(String[] args) {
		doIt();
	}

	private static void doIt() {
		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);

		ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));
	}
}

package naftalin.streams;

import java.util.stream.IntStream;

/**
 * Shows some basic streams examples
 * Created : 12.11.2018
 *
 * @author : usauerbrei
 */
public class BasicExamples {

	public static void main(String[] args) {
		new BasicExamples().doIt();
	}

	private void doIt() {
		simpleIntStream();
	}

	private void simpleIntStream() {
		IntStream.iterate(1, i -> i * 2)
				.limit(24)
				.forEachOrdered(System.out::println);
	}
}

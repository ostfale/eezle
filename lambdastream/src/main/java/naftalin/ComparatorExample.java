package naftalin;

import java.awt.*;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Shows development of a comparator using lambda expression
 * Created : 06.11.2018
 *
 * @author : usauerbrei
 */
public class ComparatorExample {

	private int length = 20;

	private List<Integer> intList;

	public ComparatorExample() {
		setUpIntList();
	}

	public static void main(String[] args) {
		new ComparatorExample().doIt();
	}

	public void setUpIntList() {
		intList = IntStream.range(0, length).boxed().collect(toList());
	}

	private void doIt() {
		finalResult();
	}

	private void finalResult() {
		intList.stream()
				.map(i -> new Point(i % 3, i / 3))
				.sorted(comparing(p -> p.distance(0, 0)))
				.forEach(p -> System.out.printf("(%f, %f)\n", p.getX(), p.getY()));
	}
}

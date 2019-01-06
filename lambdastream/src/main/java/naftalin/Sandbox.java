package naftalin;

import java.awt.*;
import java.util.Comparator;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * Some tests...
 * Created : 06.11.2018
 *
 * @author : usauerbrei
 */
public class Sandbox {

	private Function<Point, Double> keyExtractor = Point::getX;
	Comparator<Double> keyComparer = (d1, d2) -> Double.compare(d1, d2);
	Comparator<Point> byX = (p1, p2) -> keyComparer.compare(keyExtractor.apply(p1), keyExtractor.apply(p2));
	Comparator<Point> compareByX = comparing(p -> p.getX());

	public static void main(String[] args) {
		doIt();
	}

	private static void doIt() {


	}
}

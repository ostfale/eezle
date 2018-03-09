package lambda.reduction;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * Shows examples from Naftalin talk at Oracle Conference 2017
 * Created : 09.03.2018
 *
 * @author : usauerbrei
 */
public class NaftalinSimple {

	public static void main(String[] args) {
		new NaftalinSimple().doIt();
	}

	private void doIt() {
		reductionOverAnIdentity();
		reductionOnImmutabeRefTypes();
		reductionOnPrimitives();
	}

	/**
	 * Doesn't return an Optional, since it will, even with an empty stream, return a value (ZERO)
	 */
	private void reductionOverAnIdentity() {
		BigDecimal[] vals = new BigDecimal[100];
		Arrays.setAll(vals, BigDecimal::new);

		BigDecimal sum = Arrays.stream(vals)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
		System.out.println("Sum by object reduction with base value: " + sum);
	}

	private void reductionOnImmutabeRefTypes() {
		BigDecimal[] vals = new BigDecimal[100];
		Arrays.setAll(vals, BigDecimal::new);

		Optional<BigDecimal> sum = Arrays.stream(vals)
				.reduce(BigDecimal::add);
		System.out.println("Sum by object reduction: " + sum.get());

	}

	private void reductionOnPrimitives() {
		int[] vals = new int[100];
		Arrays.setAll(vals, i -> i);
		OptionalInt sum = Arrays.stream(vals).reduce((a, b) -> a + b);
		System.out.println("Sum by primitiv reduction: " + sum.getAsInt());
	}
}

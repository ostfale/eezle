package lambda.reduction;

import java.util.Arrays;
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
		sumByReduction();
	}

	private void sumByReduction() {
		int[] vals = new int[100];
		Arrays.setAll(vals, i -> i);
		OptionalInt sum = Arrays.stream(vals).reduce((a, b) -> a + b);
		System.out.println("Sum by reduction: " + sum.getAsInt());
	}
}

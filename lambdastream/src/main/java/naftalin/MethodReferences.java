package naftalin;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Example for method reference types
 * Created : 08.11.2018
 *
 * @author : usauerbrei
 */
public class MethodReferences {

	private static Integer[] integerArray = {1, 2, 3, -4, -5, 6, 7};
	private static Comparator<Integer> cmp = (x, y) -> Integer.compareUnsigned(x, y);
	private static Comparator<Integer> mRef = Integer::compareUnsigned;

	public static void main(String[] args) {
		new MethodReferences().doIt();
	}

	private static void staticMethodReferenceExample() {
		printArray(integerArray);
		// Lambda solution
		Arrays.sort(integerArray, (x, y) -> Integer.compareUnsigned(x, y));
		// use as parameter
		Arrays.sort(integerArray, cmp);
		// method reference as parameter
		Arrays.sort(integerArray, mRef);
		printArray(integerArray);
	}

	private static void printArray(Integer[] anArray) {
		for (int element : anArray) {
			System.out.println(element);
		}
	}

	private void doIt() {
		staticMethodReferenceExample();
	}
}

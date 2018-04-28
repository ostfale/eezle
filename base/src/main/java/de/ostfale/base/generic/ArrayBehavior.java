package de.ostfale.base.generic;

import java.util.Arrays;

/**
 * In Java array subtyping is covariant. If Type S[] is considered  to be a subtype of T[],
 * whenever S is a subtype  * of T
 * Created by Uwe Sauerbrei on 28.04.2018
 */
public class ArrayBehavior {

    public static void main(String[] args) {
        new ArrayBehavior().doIt();
    }

    private void doIt() {
        exampleWithArrayStoreExeptionAtRuntime();
    }

    /**
     * When an array is allocated (first line), then it is tagged with its reified type
     * (runtime-representation of its component type) = Integer.
     */
    private void exampleWithArrayStoreExeptionAtRuntime() {
        Integer[] ints = new Integer[]{1, 2, 3, 4};
        Number[] nums = ints;
        nums[2] = 3.14;         // array store exception
        assert Arrays.toString(ints).equals("[1, 2, 3, 4, 3.14]");
    }
}

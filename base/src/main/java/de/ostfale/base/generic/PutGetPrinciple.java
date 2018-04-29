package de.ostfale.base.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Use extend wildcard when you only get values and super if you put values. To put values and get values into the same structure,
 * avoid super and extend. Subtyping relation is invariant meaning List <Integer> is not considered to be a subtype of List<Number>
 * Wildcards introduce contravariant subtyping for generics.
 * * Created by Uwe Sauerbrei on 27.04.2018
 */
public class PutGetPrinciple {

    private final static List<Integer> intsList = new ArrayList<>();
    private final static List<Number> numsList = new ArrayList<>();
    private final static List<Object> objsList = new ArrayList<>();
    private final static List<Integer> ints = Arrays.asList(1, 2, 3);
    private final static List<Double> dbls = Arrays.asList(2.78, 3.14);
    private final static List<Number> nums = Arrays.asList(1, 2, 2.78, 3.14);

    public static void main(String[] args) {
        new PutGetPrinciple().doIt();
    }

    private void doIt() {
        validGetExample();
        validPutExample();
        errorExamplePutInExtend();
        errorExampleGetInSuper();
    }

    /**
     * Add call is fine, because it puts a value into the list, but call to sum is not,
     * because it gets a value from the list.
     */
    private void errorExampleGetInSuper() {
        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add("four");
        List<? super Integer> ints = objs;
        ints.add(3);
        // double dbl = sum(ints); compile-time error
        String str = "";
        // one and only exception is the Object type !!!
        for (Object obj : ints) {
            str += obj.toString();
        }
        assert str.equals("1four3");
    }

    /**
     * Call to sum gets values from the list and is fine, but add is not, because it puts
     * values to the list.
     */
    private void errorExamplePutInExtend() {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
        double dbl = sum(nums);
        System.out.printf("Okay to sum: " + dbl);
        nums.add(null);  // null is the one and only exception !!!
        // nums.add(3.14); -> compile-time error
    }

    private void validPutExample() {
        count(intsList, 5);
        assert intsList.toString().equals("[0, 1, 2, 3, 4]");
        count(numsList, 5);                     // not legal without super
        numsList.add(5.0);
        assert numsList.toString().equals("[0, 1, 2, 3, 4, 5.0]");
        count(objsList, 5);                     // not legal without super
        objsList.add("five");
        assert objsList.toString().equals("[0, 1, 2, 3, 4, five]");
    }

    private void validGetExample() {
        assert sum(ints) == 6;          // not legal without extends
        assert sum(dbls) == 5.92;       // not legal without extends
        assert sum(nums) == 8.92;
    }


    /**
     * Extends allows to get data from collection
     *
     * @param nums parameter collection
     * @return sum of the values
     */
    private static double sum(Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number num : nums) {
            s += num.doubleValue();
        }
        return s;
    }

    private static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) {
            ints.add(i);
        }
    }
}

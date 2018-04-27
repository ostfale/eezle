package de.ostfale.base.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * If a structure contains elements  of the form '? extends E', we can get elements out of the structure (but not put into structure)
 * Created by Uwe Sauerbrei on 26.04.2018
 */
public class BaseSubstitution {

    public static void main(String[] args) {
        new BaseSubstitution().doIt();
    }

    private void doIt() {
        testAllSignatures();
        wildCardsWithSuper();
        wildCardsWithExtend();
        validSubtypes();
    }

    /**
     * Allows to put data into the structure but does not permit to get the data from the structure
     */
    private void wildCardsWithSuper() {
        List<Object> objs = Arrays.asList(2, 3.14, "four");
        List<Integer> ints = Arrays.asList(5, 6);
        Collections.copy(objs, ints);
        System.out.println("Put elements with super: " + objs.toString());
        assert objs.toString().equals("[5, 6, four]");

        // four possible versions
        Collections.copy(objs, ints);
        Collections.<Object>copy(objs, ints);
        Collections.<Number>copy(objs, ints);
        Collections.<Integer>copy(objs, ints);
    }

    private void testAllSignatures() {
        List<Object> objs = new ArrayList<>(3);
        List<Number> nums = new ArrayList<>(3);
        List<Integer> ints1 = new ArrayList<>(3);
        List<Integer> ints2 = Arrays.asList(1, 2, 3);
        List<Object> objs1 = Arrays.asList(2, 3.14, "four");
        List<Number> nums1 = Arrays.asList(1, 2, 3.14);

        copy3(ints1, ints2);
        copy2(objs, nums1);
        copy2(nums, ints2);
    }

    private static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    private static <T> void copy1(List<? super T> dest, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    private static <T> void copy2(List<T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
        System.out.println(dest.toString());
    }

    /**
     * Permits only calls, when destination and sourc have exactly the same type
     *
     * @param dest target
     * @param src  source
     * @param <T>  type parameter
     */
    private static <T> void copy3(List<T> dest, List<T> src) {
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
        System.out.println(dest.toString());
    }


    /**
     * <code>public boolean addAll(Collection &lt;? extends E&gt; c)</code>
     * Without wildcard call to add ints and double would not have been permitted
     */
    private void wildCardsWithExtend() {
        List<Number> nums = new ArrayList<>();
        List<Integer> ints = Arrays.asList(1, 2);
        List<Double> dbls = Arrays.asList(2.78, 3.14);
        nums.addAll(ints);
        nums.addAll(dbls);
        System.out.println("Get elements with extend: " + nums.toString());
        assert nums.toString().equals("[1, 2, 2.78, 3.14]");
    }

    /**
     * According to substitution principle we have a collection of numbers and we may add integer or double to it,
     * because Integer and Double are subtypes of Number
     */
    private void validSubtypes() {
        List<Number> nums = new ArrayList<>();
        nums.add(2);
        nums.add(3.14);
        System.out.println("Add valid subtypes: " + nums.toString());
        assert nums.toString().equals("[2, 3.14]");
    }
}

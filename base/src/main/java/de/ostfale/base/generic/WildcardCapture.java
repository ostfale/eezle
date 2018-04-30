package de.ostfale.base.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Wildcards may not appear: <br>
 *     <ul>
 *         <li>At the top level of class instance creation (new ArrayList<?>();)</li>
 *         <li>In explicit type parameters in generic method calls</li>
 *         <li>In supertypes (extends and implements)</li>
 *     </ul>
 * Created by Uwe Sauerbrei on 29.04.2018
 */
public class WildcardCapture {

    private final static List<Integer> ints = Arrays.asList(1, 2, 3, 4);

    public static void main(String[] args) {
        reverse(ints);
    }

    /**
     * Type T has captured the wildcard, since the reverse function does not work this way with wildcards
     *
     * @param list list of unknown type ( ?  = extends Object)
     */
    private static void reverse(List<?> list) {
        System.out.println("Original list: " + list.toString());
        rev(list);
        System.out.println("Reverse list: " + list.toString());
    }

    /**
     * Copies the arguments into a temporary list, and then writes from the copy back
     * into the original in reverse order
     *
     * @param list original List
     * @param <T>  type description
     */
    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, tmp.get(list.size() - i - 1));
        }
    }

    /**
     * Not working since we can't write from a list of objects into a list of unknown (?) type.
     *
     * @param list List of unknown type
     */
    public static void reverseFail(List<?> list) {
        List<Object> tmp = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            //  list.set(i, tmp.get(list.size() - i - 1)); => Compile-Time-Error
        }
    }
}

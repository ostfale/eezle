package de.ostfale.fp.lambda.basic;


import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Shows the development of a functional solution from a habitual way
 * Created by Uwe Sauerbrei on 05.01.2018
 */
public class FindCity {

    private static List<String> cities;

    public static void main(String[] args) {
        new FindCity().doIt();
    }

    private void doIt() {
        init();
        imperativeVersion();
        betterVersion();
    }

    /**
     * Imperative version is noisy and low level
     */
    private void imperativeVersion() {
        boolean found = false;
        for (String city : cities) {
            if (city.equals("Buchholz")) {
                found = true;
                break;
            }
        }
        System.out.println("Searching the common way via collection: found City: " + found);
    }

    /**
     * Hides interation, better clarity, less error prone, easier to understand
     */
    private void betterVersion() {
        System.out.println("Searching via collection contains function: found City: " + cities.contains("Buchholz"));
    }

    private void init() {
        cities = Collections.unmodifiableList(Stream.of("New York", "Chicago", "Buchholz", "Louisana").collect(toList()));
    }
}

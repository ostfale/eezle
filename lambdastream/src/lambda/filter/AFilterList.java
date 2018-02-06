package de.ostfale.fp.lambda.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Show use of filter operation
 * Created by Uwe Sauerbrei on 07.01.2018
 */
public class AFilterList {

    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    List<String> startsWithN = new ArrayList<>();

    public static void main(String[] args) {
        new AFilterList().doIt();
    }

    private void doIt() {
        pickElementCommonWay();
        pickElementWithFilter();
    }

    /**
     * In contrast to map method, filter return only a collection of valid elements (subset of input
     * collection)
     */
    private void pickElementWithFilter() {
        startsWithN.clear();
        startsWithN = friends.stream()
                .filter(name -> name.startsWith("N"))
                .collect(Collectors.toList());
        System.out.println("Shows relevant names using filter: " + startsWithN);
    }

    private void pickElementCommonWay() {
        for (String name : friends) {
            if (name.startsWith("N")) {
                startsWithN.add(name);
            }
        }
        System.out.println("Show all names starting with 'N' old fashioned way: " + startsWithN);
    }
}

package de.ostfale.fp.lambda.filter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Uwe Sauerbrei on 06.02.2018
 */
public class DPickALongest {

    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        new DPickALongest().doIt();
    }

    private void doIt() {
        pickSteveOrLonger(friends);
        pickALongestValue(friends);
        totalNumberOfAllCharacters(friends);
    }

    /**
     * Uses a default (Steve)
     *
     * @param friends list
     */
    private void pickSteveOrLonger(List<String> friends) {
        final String aLongName = friends.stream()
                .reduce("Steve", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        System.out.println(String.format("A longest name: %s", aLongName));
    }

    /**
     * Reduce is here a lightweight application of the  strategy pattern
     *
     * @param friends list of friends
     */
    private void pickALongestValue(List<String> friends) {
        final Optional<String> aLongName = friends.stream()
                .reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2);
        aLongName.ifPresent(name -> System.out.println(String.format("A longest name: %s", name)));
    }

    private void totalNumberOfAllCharacters(List<String> friends) {
        System.out.println("Total number of characters in all names: " +
                friends.stream()
                        .mapToInt(String::length)
                        .sum());
    }
}

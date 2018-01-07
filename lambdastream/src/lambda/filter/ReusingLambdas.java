package de.ostfale.fp.lambda.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Using DRY principle with lambdas. From within lambdas one can access only local variables  that
 * are final of effectively final (must not be changed to avoid race condition) in the enclosing scope.
 * Created by Uwe Sauerbrei on 07.01.2018
 */
public class ReusingLambdas {

    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    private final List<String> editors = Arrays.asList("Jackie", "John", "Mike");
    private final List<String> comrades = Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");

    /**
     * Compiler can infer type
     */
    private final Function<String, Predicate<String>> lambdaInferTypeStartsWithLetter = letter -> name -> name.startsWith(letter);

    /**
     * Improved version using a lambda
     */
    private final Function<String, Predicate<String>> lambdaStartsWithLetter = (String letter) -> (String name) -> name.startsWith(letter);

    /**
     * Functional interface to avoid a static method - verbose version through anonymous function
     */
    final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
        Predicate<String> checkStarts = (String name) -> name.startsWith(letter);
        return checkStarts;
    };

    /**
     * Higher order function! Variable 'letter' is not in the scope of the anonymous function but found in scope of lambda expression.
     * This is lexical scoping
     *
     * @param letter to search for
     * @return Predicate of type String
     */
    private static Predicate<String> checkIfStartsWith(final String letter) {
        return name -> name.startsWith(letter);
    }


    public static void main(String[] args) {
        new ReusingLambdas().doIt();
    }

    private void doIt() {
        filterNamesNaiveApproach();
        filterNamesWithDRY();
        lexicalScoping();
        pickForDifferentNames();
    }

    /**
     * Using higher order functions to avoid code duplication in code.
     */
    private void pickForDifferentNames() {
        final Long countFriendsWithStartN = friends.stream().filter(lambdaInferTypeStartsWithLetter.apply("N")).count();
        final Long countFriendsWithStartB = friends.stream().filter(lambdaInferTypeStartsWithLetter.apply("B")).count();
        System.out.println("Higher order functions: Friends with N: " + countFriendsWithStartN + " and Friends with B: " + countFriendsWithStartB);
    }

    /**
     * Avoid duplication in lambda expressions with lexical scoping
     */
    private void lexicalScoping() {
        final Long countFriendsWithStartN = friends.stream().filter(checkIfStartsWith("N")).count();
        final Long countFriendsWithStartB = friends.stream().filter(checkIfStartsWith("B")).count();
        System.out.println("Friends starting with N: " + countFriendsWithStartN + " and Friends starting with B: " + countFriendsWithStartB);
    }

    /**
     * Store lambda in an explicit reference of type Predicate
     */
    private void filterNamesWithDRY() {
        final Predicate<String> startsWithN = name -> name.startsWith("N");

        final long countFriendStartN = friends.stream().filter(startsWithN).count();
        final long countEditorsStartN = editors.stream().filter(startsWithN).count();
        final long countComradesStartN = comrades.stream().filter(startsWithN).count();
        System.out.println("DRY :: Number of all names starting with 'N':  " + (countFriendStartN + countEditorsStartN + countComradesStartN));

    }

    private void filterNamesNaiveApproach() {
        final long countFriendStartN = friends.stream().filter(name -> name.startsWith("N")).count();
        final long countEditorsStartN = editors.stream().filter(name -> name.startsWith("N")).count();
        final long countComradesStartN = comrades.stream().filter(name -> name.startsWith("N")).count();
        System.out.println("Number of all names starting with 'N':  " + (countFriendStartN + countEditorsStartN + countComradesStartN));
    }
}

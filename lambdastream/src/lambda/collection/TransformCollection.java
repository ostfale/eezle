package de.ostfale.fp.lambda.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Uwe Sauerbrei on 06.01.2018
 */
public class TransformCollection {

    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");
    final List<String> uppercaseNames = new ArrayList<>();

    public static void main(String[] args) {
        new TransformCollection().doIt();
    }

    private void doIt() {
        System.out.println("Original: " + friends.toString());
        oldIterationStyle();
        forEachSolution();
        usingLambdaMapToString();
        usingLambdaMapToInt();
        usingMethodReference();
    }

    private void usingMethodReference() {
        System.out.println("\nUse method references : ");
        friends.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private void usingLambdaMapToInt() {
        System.out.println("Use lambda expression and map to int: ");
        friends.stream()
                .map(name -> name.length())
                .forEach(count -> System.out.print(count + " "));
    }

    /**
     * Streams map method can map or transform  a sequence of input to a sequence of output.
     * The map method collects the results again in a collection.
     */
    private void usingLambdaMapToString() {
        System.out.println("Use lambda expression and map to string: ");
        friends.stream()
                .map(name -> name.toUpperCase())
                .forEach(name -> System.out.print(name + " "));


    }

    /**
     * Still uses empty list to move uppercase strings to the new list
     */
    private void forEachSolution() {
        uppercaseNames.clear();
        friends.forEach(name -> uppercaseNames.add(name.toUpperCase()));
        System.out.println("With forEach: " + uppercaseNames.toString());
    }

    private void oldIterationStyle() {
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println("Common solution: " + uppercaseNames.toString());
    }
}

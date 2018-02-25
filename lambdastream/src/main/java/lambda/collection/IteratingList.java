package lambda.collection;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by Uwe Sauerbrei on 06.01.2018
 */
public class IteratingList {

    final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    public static void main(String[] args) {
        new IteratingList().doIt();
    }

    private void doIt() {
        oldIterationStyle();
        betterIterationStyle();
        functionalConsumerInterface();
        functionalLambda();
        functionalLambdaInferType();
        functionLambdaInferSingleParameter();
        functionalLambdaWithMethodReference();
    }


    /**
     * Using method reference
     */
    private void functionalLambdaWithMethodReference() {
        friends.forEach(System.out::println);
    }

    /**
     * For single parameter parentheses can be removed
     */
    private void functionLambdaInferSingleParameter() {
        friends.forEach(name -> System.out.println(name));
    }

    /**
     * The compiler infers the type of parameter (name). It looks up signature of called method (forEach)
     * and analyzes the  functional interface used.
     */
    private void functionalLambdaInferType() {
        friends.forEach((name) -> System.out.println(name));
    }

    /**
     * The forEach function is a higher-order function which accepts a lambda function
     */
    private void functionalLambda() {
        friends.forEach((final String name) -> System.out.println(name));
    }

    /**
     * ForEach (internal iterator) solution with anonymous inner class syntax
     */
    private void functionalConsumerInterface() {
        friends.forEach(new Consumer<String>() {
            @Override
            public void accept(final String name) {
                System.out.println(name);
            }
        });
    }

    /**
     * Improved loop style
     * Calls hasnext() and next() interface of Iterator
     */
    private void betterIterationStyle() {
        for (String name : friends) {
            System.out.println(name);
        }
    }

    /**
     * Habitual (old) way
     */
    private void oldIterationStyle() {
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }
    }
}

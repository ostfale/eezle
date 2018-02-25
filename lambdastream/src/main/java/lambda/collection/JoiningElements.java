package lambda.collection;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by Uwe Sauerbrei on 10.02.2018
 */
public class JoiningElements {

    private final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");


    public static void main(String[] args) {
        new JoiningElements().doIt();
    }

    private void doIt() {
        combinedMethods();
        stringJoiner();
        avoidStupidComma();
        oldFashionedWay();
    }

    private void combinedMethods() {
        System.out.println(friends.stream()
                .map(String::toUpperCase)
                .collect(joining(", ")));
    }

    private void stringJoiner() {
        System.out.println(String.join(", ", friends));
    }

    private void avoidStupidComma() {
        for (int i = 0; i < friends.size() - 1; i++) {
            System.out.print(friends.get(i) + ", ");
        }
        if (friends.size() > 0) {
            System.out.println(friends.get(friends.size() - 1));
        }
    }

    private void oldFashionedWay() {
        for (String name : friends) {
            System.out.print(name + ", ");
        }
    }
}
